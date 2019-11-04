/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que determina las pruebas de la gestion de los
 * comics
 * 
 * @author Alzate Leon
 * @version 1.0
 */
public class GestionarComicPOJOTest {
	GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
	ComicDTO comicDTO = null;

	/**
	 * 
	 * Metodo encargado de probar que se agregen los tres comics a la lista 
	 * @author Alzate Leon
	 *
	 */
	@Test
	public void crearComics() {
		// creamos el primer comic
		gestionarComicPOJO.crearComicDTO();
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==1);

		//creamos y agregamos el segundo comic
		comicDTO = gestionarComicPOJO.crearComicDTO("101", "Captain America Corps 1-5 USA", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 128, new BigDecimal(5000),
				"Phillippe Briones, Roger Stern", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);
		
		//probamos que el comic no sea nulo
		Assert.assertNotNull(comicDTO);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		//probamos que se haya agregado a la lista
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==2);
		
		//agregamos el tercer comic
		comicDTO = gestionarComicPOJO.crearComicDTO("102", "The Spectacular Spider-Man v2 USA", "Panini Comics",
				TematicaEnum.FANTASTICO, "MARVEL COMICS", 208, new BigDecimal(6225),
				"Straczynski,Deodato Jr.,Barnes,Eaton", Boolean.TRUE, LocalDate.now(), EstadoEnum.INACTIVO, 0L);
		
		//probamos que el comic no sea nulo
		Assert.assertNotNull(comicDTO);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		//probamos que se haya agregado a la lista el tercer comic
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==3);
		
	}
	
	/**
	 * 
	 * Metodo encargado de probar el metodo modificar comic 
	 * @author Alzate Leon
	 *
	 */
	@Test
	public void modificarComic102() {
		//buscamos el comic a editar por el id
		comicDTO=gestionarComicPOJO.buscarComicDTO("102");
		//editamos lo que queramos
		comicDTO.setNombre("Comic prueba de modificacion");
		comicDTO.setPrecio(new BigDecimal(1000));
		comicDTO.setAutores("Sebastian Alzate");
		
		//modificamos la lista
		gestionarComicPOJO.modificarComicDTO(1, comicDTO);
		
		//volvemos a buscar el comic ya modificado
		comicDTO= gestionarComicPOJO.buscarComicDTO("102");
		//prbamos que el nombre haya cambiado
		Assert.assertTrue(comicDTO.getNombre().equals("Comic prueba de modificacion"));
		//validamos que los autores ya no sea los definidos al principio si no el que se modifico
		Assert.assertNotEquals(comicDTO.getAutores(), "Phillippe Briones, Roger Stern");
		
	}
	
	/**
	 * 
	 * Metodo encargado de validar que se pueda elimiar el comic 101 
	 * <b>Caso de Uso</b>
	 * @author Alzate Leon
	 *
	 */
	@Test
	public void eliminarComic() {
		//llamamos el metodo eliminar
		gestionarComicPOJO.eliminarComicDTO("101");
		
		//validamos que en la lista haya 2 elementos no mas
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==2);
	}
}
