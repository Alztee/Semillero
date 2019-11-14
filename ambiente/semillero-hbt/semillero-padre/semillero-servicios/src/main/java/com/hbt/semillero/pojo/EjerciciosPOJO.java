/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Usuario
 * @version
 */
public class EjerciciosPOJO {

	/**
	 * 
	 * Metodo encargado de verificar una variable <b>Caso de Uso</b>
	 * 
	 * @author Usuario
	 * 
	 * @param palabra
	 */
	public void ejercicio1(String palabra) {
		String _a;

		if (!palabra.contains(" ") && !palabra.contains(".") && palabra != "true") {
			System.out.println("la palabra : " + palabra + " es un identificador valido");
		} else {
			System.out.println("la palabra : " + palabra + " no es un identificador valido");
		}
	}

	/**
	 * 
	 * Metodo encargado de verificar si un numero es primo <b>Caso de Uso</b>
	 * 
	 * @author Usuario
	 *
	 */
	public boolean ejercicio3(int numero) {
		boolean estado = true;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				estado = false;
			}
		}
		return estado;
	}

	/**
	 * 
	 * Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Usuario
	 *
	 */
	public int ejercicio4(LocalDate fecha) {
		int edad= LocalDate.now().getYear()-fecha.getYear() ;
		return edad+fecha.getYear();
	}
}
