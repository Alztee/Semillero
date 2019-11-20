/**
 * Usuario.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina un usuario comprador de comic
 * @author Alzate
 * @version 1.0
 */
@Entity
@Table(name = "TC_USUARIO")
public class Usuario extends Persona implements Serializable{
	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id del usuario
	 */
	private String id;
	/**
	 * fecha creaacion del usuario
	 */
	private LocalDate fechaCreacion;
	/**
	 * estado del usuario
	 */
	private EstadoEnum estado;
	/**
	 * id de la persona padre
	 */
	private Long idPersona;
	//-------------------------------COnstructores_---------------------------------
	
	
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param documento
	 */
	public Usuario() {
		super();
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param documento
	 * @param id2
	 * @param fechaCreacion
	 * @param estado
	 * @param idPersona
	 */
	public Usuario(String id, String nombre, String documento, String id2, LocalDate fechaCreacion, EstadoEnum estado,
			Long idPersona) {
		super(id, nombre, documento);
		id = id2;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.idPersona = idPersona;
	}

	//__--------------------------------------------geTS
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Column(name="SUID")
	public String getId() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	@Column(name="SUFECHA_CREACION")
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	@Column(name="SUESTADO")
	public EstadoEnum getEstado() {
		return estado;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo idPersona
	 * @return El idPersona asociado a la clase
	 */
	@Column(name="SUIDPERSONA")
	public Long getIdPersona() {
		return idPersona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	
}
