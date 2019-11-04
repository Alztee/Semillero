package com.hbt.semillero.servicios;

import java.awt.color.CMMException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * 
 * <b>Descripción:<b> Clase que determina las pruebas unitarias <b>Caso de
 * Uso:<b>
 * 
 * @author Alzate Leon
 * @version
 */
public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	/**
	 * primera prueba unitaria Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Alzate Leon
	 *
	 */
	@Test(enabled = false)
	public void primeraPU() {
		Long resultadoEsperado = 150l;
		Long sumando1 = 100l;
		Long sumando2 = 50l;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultadoEsperado, resultado);

	}

	/**
	 * segunda prueba unitaria Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Usuario
	 *
	 */
	@Test(enabled = false)
	public void segundaPU() {
		String cadena = "hola";
		String cadenaBienInvertida = "aloh";
		// correcto
		Assert.assertEquals(cadenaBienInvertida, invertirCadena(cadena));

		// mal
		String cadenaMalInvertida = "alho";
		// Assert.assertEquals(cadenaMalInvertida, invertirCadena(cadena));

		// correcto, si es una sola letra siempre da true
		String cadena2 = "a";
		Assert.assertEquals(cadena2, invertirCadena(cadena2));
	}

	/**
	 * metodo para probar invertir una cadena
	 * 
	 * @param cadena
	 * @return String, cadena invertida
	 */
	@Test(enabled = false)
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";

		for (int x = cadena.length() - 1; x >= 0; x--) {

			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}

	/**
	 * 
	 * Metodo encargado de validar el metodo TOString de comic se crea un nuevo
	 * comic y se le agregan valores y se imprime <b>Caso de Uso</b>
	 * 
	 * @author Alzate
	 *
	 */
	@Test(enabled = false)
	public void validarToString() {
		Comic comicNuevoComic = new Comic();
		comicNuevoComic.setNombre("PUNISHER. EL CASTIGADOR: BLANCO Y NEGRO");
		comicNuevoComic.setAutores("Rick Remender, Roland Boschi");
		comicNuevoComic.setCantidad(50l);
		comicNuevoComic.setColeccion("MARVEL COMICS");
		comicNuevoComic.setColor(true);
		comicNuevoComic.setEditorial("Panini Comics");
		comicNuevoComic.setEstadoEnum(EstadoEnum.ACTIVO);
		comicNuevoComic.setFechaVenta(LocalDate.now());
		comicNuevoComic.setId("0001");
		comicNuevoComic.setNumeroPaginas(184);
		comicNuevoComic.setPrecio(new BigDecimal("15.68"));
		comicNuevoComic.setTematicaEnum(TematicaEnum.AVENTURAS);

		System.out.println(comicNuevoComic.toString());
	}

	/**
	 * pruebas unitarias para validar los enum Metodo encargado de <b>Caso de
	 * Uso</b>
	 * 
	 * @author Alzate
	 *
	 */
	@Test(enabled = false)
	public void terceraPU() {
		EstadoEnum estadoEnumActivo = EstadoEnum.ACTIVO;
		// validar que se instancio correctamente el Enum
		Assert.assertNotNull(estadoEnumActivo, "no es nulo");

		// devolevr un String con el nombre de la constante
		System.out.println("el nombre de la constante es: " + estadoEnumActivo.name());

		// Devolver un entero con la posicion del enum segun esta declarada
		System.out.println("la posicion del Enum es: " + estadoEnumActivo.ordinal());

		// comparar un enum
		EstadoEnum estadoInactivo = EstadoEnum.INACTIVO;
		// -1 si no son iguales, 0 si lo son
		System.out.println(estadoEnumActivo.compareTo(estadoInactivo));
		// comparar con rden declarado de los estados
		for (EstadoEnum estados : EstadoEnum.values()) {
			// comentado para que no salga errores y se puedan ver los otros sout
			// uno da exitosa por que compara activo con activo y la otra falla
			// Assert.assertEquals(estadoEnumActivo, estados);
		}

		// devolver un array con todos los enum
		ArrayList<String> list = new ArrayList<String>();
		for (EstadoEnum estados : EstadoEnum.values()) {
			list.add(estados.name());
			System.out.println("dato en el array: " + estados.name());
		}

	}

	/**
	 * prueba para probar la lista en la sesion 4 Metodo encargado de <b>Caso de
	 * Uso</b>
	 * 
	 * @author Alzate Leon
	 *
	 */
	@Test(enabled=false)
	public void GestionarComicPojo() {

		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() != 0);
		// es mejor usar esta
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
	}

	@Test(enabled = false)
	public void CrearComicDTO() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("101", "Captain America Corps 1-5 USA ", "panini comics",
				TematicaEnum.FANTASTICO, "Biblioteca Marvel", 128, new BigDecimal(5000),
				"Phillipe Briones, ROger Stern", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);
		
		comicDTO = new ComicDTO();
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
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() >1);

	}

	/**
	 * 
 	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Usuario
	 *
	 */
	@Test (enabled=false)
	public void AgregarComicDTOLista() {

	}
}
