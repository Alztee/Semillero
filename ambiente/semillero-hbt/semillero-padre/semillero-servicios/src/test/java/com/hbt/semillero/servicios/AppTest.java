package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

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
		String cadena= "hola";
		String cadenaBienInvertida = "aloh";
		//correcto
		Assert.assertEquals(cadenaBienInvertida, invertirCadena(cadena));
		
		//mal
		String cadenaMalInvertida = "alho";
		Assert.assertEquals(cadenaMalInvertida, invertirCadena(cadena));
		
		//correcto, si es una sola letra siempre da true
		String cadena2= "a";
		Assert.assertEquals(cadena2, invertirCadena(cadena2));
	}

	/**
	 * metodo para invertir una cadena
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
	
	//TODO
	/**
	 *  Pediente hacer un método que use el método ToString de la entidad COMIC
	 */
}
