/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Usuario
 * @version 
 */
public class EjerciciosPOJO {

	public void ejercicio1(String palabra) {
		String _a;
		
		if(!palabra.contains(" ")&& !palabra.contains(".")&& palabra != "true"  ) {
			System.out.println("la palabra : "+ palabra +" es un identificador valido");
		}
		else {
			System.out.println("la palabra : "+ palabra +" no es un identificador valido");
		}
	}
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Usuario
	 *
	 */
	public boolean ejercicio3(int numero ) {
		boolean estado= true;
		for (int i = 2; i < numero; i++) {
			if(numero%i==0) {
				estado= false;
			}
		}
		return estado;
	}
}
