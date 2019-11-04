/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
public class GestionarComicBean {

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
	 * 
	 * Metodo encargado de ingresar un comic a la BD
	 * 
	 * @author Alzate Leon
	 * 
	 * @param comicDTO, comicDTO que ayuda a mapear un COmic para persistir
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getID());
		comic.setAutores(comicDTO.getAutores());
		comic.setCantidad(comicDTO.getCantidad());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setColor(comicDTO.getColor());
		comic.setEstadoEnum(comicDTO.getEstado());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setFechaVenta(comicDTO.getFecha());
		comic.setNombre(comicDTO.getNombre());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setTematicaEnum(comicDTO.getTematica());

		em.persist(comic);
	}

	/**
	 * 
	 * Metodo encargado de 
	 * 
	 * @author Alzate Leon
	 * 
	 * @param comicDTO
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicDTO) {
		// si no manda id, crea uno nuevo, si manda update
		Comic comic = new Comic();

		em.merge(comic);
	}
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Alzate Leon
	 * not supported por que no es una transaccion
	 * @param id
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic= em.find(Comic.class, id);
		ComicDTO comicDTO= new ComicDTO(comic.getNombre(), comic.getId());
		return comicDTO;
	}
}
