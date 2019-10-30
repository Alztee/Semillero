package com.hbt.semillero.servicios;

import java.awt.color.CMMException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test
	public void primeraPU() {
		Long resultadoEsperado = 150l;
		Long sumando1 = 100l;
		Long sumando2 = 50l;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultadoEsperado, resultado);

	}

	@Test
	/**
	 * Segunda prueba unitaria que prueba si una cadena se invierte correctamente
	 */
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
	 * metodo para invertir una cadena
	 * 
	 * @param cadena
	 * @return String, cadena invertida
	 */
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
	@Test
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
	@Test
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
}
