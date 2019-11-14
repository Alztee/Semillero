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

	/**
	 * 
	 * Metodo encargado de partido tennis retorna 1 si gana federer retorna 0 si
	 * gana dominic
	 * 
	 * @author Alzate
	 *
	 */
	public int ejercicio7(int[] rogerFedere, int[] dominic) {
		int setsFederer = 0;
		int setsDominic = 0;

		for (int i = 0; i < dominic.length; i++) {
			if (rogerFedere[i] > dominic[i]) {
				setsFederer++;
			} else {
				setsDominic++;
			}
		}
		if (setsFederer > setsDominic) {
			return 1;
		} else {
			return 0;
		}

	}

	/**
	 * 
	 * Metodo encargado de
	 * 
	 * @author Alzate
	 *
	 */
	public int[] ejercicio8(Integer cambio) {

		int[] monedas = { 50, 100, 200, 500, 1000 };
		int[] devuelta = { 0, 0, 0, 0, 0 };

		while (cambio > 50) {
			if (cambio / 1000 > 0) {
				devuelta[0]++;
				cambio = cambio - 1000;
			}
			if (cambio / 500 > 0) {
				devuelta[1]++;
				cambio = cambio - 500;
			}
			if (cambio / 200 > 0) {
				devuelta[2]++;
				cambio = cambio - 200;
			}
			if (cambio / 100 > 0) {
				devuelta[3]++;
				cambio = cambio - 100;
			}
			if (cambio / 50 > 0) {
				devuelta[4]++;
				cambio = cambio - 50;
			}

		}
		return devuelta;
	}
	
	/**
	 * 
	 * Metodo encargado de 
	 * @author Alzate
	 *
	 */
	public void ejercicio9() throws Exception{
		throw new Exception();
		
	}
	
	/**
	 * 
	 * Metodo encargado de continuar la secuencia
	 * @author Alzate
	 *
	 */
	public int ejercicio11(Integer numero) {
		Integer numero1= numero/10;
		Double numero2= (double) (numero/10);
		String numeroAux=String.valueOf(numero2);
		String[] numeroo=numeroAux.split(",");
		Integer numero3= Integer.parseInt(numeroo[1]);
		
		Integer numeroAnterior= numero3+numero1;
		
		return numeroAnterior+1;
	}
}
