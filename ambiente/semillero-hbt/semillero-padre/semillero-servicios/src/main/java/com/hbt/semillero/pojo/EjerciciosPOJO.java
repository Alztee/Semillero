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

	public int[] arreglo = new int[4];
	public int contador = 0;

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
		int edad = LocalDate.now().getYear() - fecha.getYear();
		return edad + fecha.getYear();
	}

	/**
	 * 
	 * Metodo encargado de realizar el ejercicio 5
	 * 
	 * @author Alzate
	 *
	 */
	public void ejercicio5(int numero) {
		arreglo[contador] = numero;
		contador++;
	}

	/**
	 * 
	 * Metodo encargado de organizar el arreglo usando el metodo burbuja <b>Caso de
	 * Uso</b>
	 * 
	 * @author Alzate
	 *
	 */
	public void organizarEjercicio5() {
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo.length - 1; j++) {
				if (arreglo[j] > arreglo[j + 1]) {
					int auxiliar = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = auxiliar;
				}
			}
		}
	}
}
