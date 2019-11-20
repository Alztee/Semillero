/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b> comunicacion entre
 * bd y la aplicacion
 * 
 * @author Usuario
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	/**
	 * atributo que tiene contacto con la DB, los manipula
	 */
	@PersistenceContext
	private EntityManager em;

	// TODO
	/**
	 * agregar interfaz
	 */
	/**
	 * Metodo encargado de ingresar un comic a la BD a traves del EM
	 * 
	 * @author Alzate Leon
	 * 
	 * @param comicDTO, comicDTO que ayuda a mapear un COmic para persistir
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = convertirComicDTOToComic(comicDTO);
		em.persist(comic);
	}

	/**
	 * 
	 * Metodo encargado de modificar un comic
	 * 
	 * @author Alzate Leon
	 * 
	 * @param comicDTO
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicDTO) {

		if (comicDTO != null) {
			Comic comic = convertirComicDTOToComic(comicDTO);
			em.merge(comic);
		}
	}

	/**
	 * 
	 * Metodo encargado de buscar un comic en el em y retornarlo como comicDTO
	 * 
	 * @author Alzate Leon not supported por que no es una transaccion, osea no se
	 *         manipula info
	 * @param id del comic a buscar
	 * @return comic convertido en comicDTO
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class, Long.parseLong(id));
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de consultar todos los comics
	 * 
	 * @author Alzate Leon
	 * 
	 * @return lista de comics
	 */
	public List<ComicDTO> consultarTodos() {
		// nombre, entidades
		List<Comic> resultados = (List<Comic>) em.createQuery("Select c from Comic").getResultList();
		return null;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	// TODO
	/*
	 * resultado de llamas r modificar comic
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {

		Comic comicModificar;
		if (comicNuevo == null) {
			// manejada nustra entidad
			comicModificar = em.find(Comic.class, id);
		} else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		comicModificar.setNombre(nombre);
		// TODO verificar si el comic a editar llego con datos.
		// si encuentra en la bd actualiza si no crea
		em.merge(comicModificar);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 *      metodo encargado de eliminar un comic del entity manager
	 */
	/**
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComic(Long idComic) {
		// TODO Auto-generated method stub
		if (idComic != null) {
			ComicDTO comicEliminarDTO = consultarComic(idComic.toString());
			Comic comicEliminar = convertirComicDTOToComic(comicEliminarDTO);
			if (comicEliminar != null) {
				em.remove(comicEliminar);
			}
		}

	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}

	/**
	 * Metodo encargado de convertir un comicDTo a un Comic
	 * 
	 * @author Alzate Leon
	 * 
	 * @param comicDTO
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		if (comicDTO.getID() != null) {
			comic.setId(Long.parseLong(comicDTO.getID()));
		}
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematica());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFecha());
		comic.setEstadoEnum(comicDTO.getEstado());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	/**
	 * 
	 * Metodo encargado de convertir un Comic a un ComicDTO
	 * 
	 * @author Alzate Leon
	 * 
	 * @param comic, comic a ser transformado en comicDTO
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setID(comic.getId().toString());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematica(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFecha(comic.getFechaVenta());
		comicDTO.setEstado(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}
}
