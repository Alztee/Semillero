/**
 * TematicaEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina el enum de la tematica
 * <b>Caso de Uso:<b> 
 * @author Alzate
 * @version 
 */
public enum TematicaEnum {
	
	
	AVENTURAS("enum.tematica.aventuras"), 
	BELICO("enum.tematica.belico"), 
	HUMORISTICO("enum.tematica.humoristico"),
	DEPORTIVO("enum.tematica.deportivo"), 
	FANTASTICO("enum.tematica.fantastico"), 
	CIENCIA_FICCION("enum.tematica.ciencia_ficcion"), 
	HISTORICO("enum.tematica.historico"),
	HORROR("enum.tematica.horror");
	
	/**
	 * 
	 */
	private String codigoMensaje;

	/**
	 * Constructor de la clase.
	 * @param codigoMensaje
	 */
	private TematicaEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
	
	

}
