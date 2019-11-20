/**
 * ProveedorDTO.java
 */
package com.hbt.semillero.dto;

import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina el DTO de proveedor
 * 
 * @author Alzate
 * @version
 */
public class ProveedorDTO extends PersonaDTO {

	/**
	 * id del proveedor
	 */
	private String id;
	/**
	 * direecion del proveedor
	 */
	private String direccion;
	/**
	 * fecha creaacion del proveedor
	 */
	private LocalDate fechaCreacion;
	/**
	 * estado del proveedor
	 */
	private EstadoEnum estado;
	/**
	 * monto de credito que tiene el proveedor
	 */
	private Long montoCredito;

	// __---------------------------------constructores-------------------------
	/**
	 * Constructor de la clase.
	 */
	public ProveedorDTO() {
		super();
	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param id
	 * @param nombre
	 * @param documento
	 * @param id2
	 * @param direccion
	 * @param fechaCreacion
	 * @param estado
	 * @param montoCredito
	 */
	public ProveedorDTO(String id, String nombre, String documento, String id2, String direccion,
			LocalDate fechaCreacion, EstadoEnum estado, Long montoCredito) {
		super(id, nombre, documento);
		id = id2;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.montoCredito = montoCredito;
	}

	// ---------------------------------------GETS AND SETS----------------------
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * 
	 * @return El direccion asociado a la clase
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * 
	 * @param direccion El nuevo direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * 
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * 
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * 
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * 
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * 
	 * @return El montoCredito asociado a la clase
	 */
	public Long getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo montoCredito
	 * 
	 * @param montoCredito El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(Long montoCredito) {
		this.montoCredito = montoCredito;
	}

}
