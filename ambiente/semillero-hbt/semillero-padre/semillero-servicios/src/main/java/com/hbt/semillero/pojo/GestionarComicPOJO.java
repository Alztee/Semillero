/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina la gestion de los comics como la
 * creacion, edicion y demas de los comics
 * 
 * @author Alzate Leon
 * @version
 */
public class GestionarComicPOJO {

	/**
	 * lista donde se guaradan los comics
	 */
	private List<ComicDTO> listaComics = null;

	/**
	 * 
	 * Metodo encargado de crear un comic <b>Caso de Uso</b>
	 * 
	 * @author Alzate Leon
	 * 
	 * @param id             del nuevo comic a crear
	 * @param nombre,        nombre del nuevo comic a crear
	 * @param editorial,     editorial del nuevo comic a crear
	 * @param tematica,      tematica del nuevo comic a crear
	 * @param coleccion,     coleccion del nuevo comic a crear
	 * @param numeroPaginas, numero de paginas del nuevo comic a crear
	 * @param precio,        precio del nuevo comic a crear
	 * @param autores,       autores del nuevo comic a crear
	 * @param color,         si el comic o no esta a color (true=con color,
	 *                       false=sin color)
	 * @param fecha,         fecha del nuevo comic a crear
	 * @param estadoEnum,    estado del comic (Activo o inactivo)
	 * @param cantidad,      cantidad de comics existentes
	 * @return
	 */
	public ComicDTO crearComicDTO(String id, String nombre, String editorial, TematicaEnum tematica, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fecha,
			EstadoEnum estadoEnum, Long cantidad) {

		ComicDTO comicDTO = new ComicDTO(id, nombre, editorial, tematica, coleccion, numeroPaginas, precio, autores,
				color, fecha, estadoEnum, cantidad);

		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de.... <b>Caso de Uso</b>
	 * 
	 * @author Alzate Leon
	 * 
	 * @param comicDTO
	 * @return
	 */
	public ComicDTO CrearComicDTO(ComicDTO comicDTO) {
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de agregar un comic a la lista de comics <b>Caso de Uso</b>
	 * 
	 * @author Alzate Leon
	 * 
	 * @param comic, comic para agregar a la lista
	 */
	public void agregarComicDTOLista(ComicDTO comic) {
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}

		listaComics.add(comic);
	}

	/**
	 * 
	 * Metodo encargado de modificar un comidDTO dentro de la lista <b>Caso de
	 * Uso</b>
	 * 
	 * @author Alzate Leon
	 * 
	 * @param i,        posicion de la lista donde se va a editar el elemento
	 * @param comicDTO, comic editado.
	 */
	public void modificarComicDTO(int i, ComicDTO comicDTO) {
		listaComics.set(i, comicDTO);
	}

	public void modificarComicDTO(String id, String nombre) {
		ComicDTO comicModificar=null;
		for (int i = 0; i < listaComics.size(); i++) {
			comicModificar=listaComics.get(i);
			if (comicModificar.getID().equals(id)) {
				comicModificar.setNombre(nombre);
				return;
			}
		}
	}

	// TODO
	/**
	 * llenar para la sesion del jueves. Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Alzate
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setID("100");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta còmic");
		comicDTO.setTematica(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFecha(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}
