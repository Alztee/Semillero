/**
 * EstadoEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Usuario
 * @version 
 */
public enum EstadoEnum {
	
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo");
	
	/**
	 * 
	 */
	private String codigoMensaje;

	/**
	 * Constructor de la clase.
	 * @param codigoMensaje
	 */
	private EstadoEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
}
