/**
 * Persona.java
 */
package com.hbt.semillero.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>Descripción: clase que determina una persona
 * 
 * @author Alzate
 * @version 1.0
 */
@Entity
@Table(name = "TC_PERSONA")
public class Persona {
	/**
	 * id de la persona
	 */
	private String id;
	/**
	 * nombre de la persona
	 */
	private String nombre;

	/**
	 * cc de la persona
	 */
	private String documento;
	// --------------------------------CONSTRUCTORES------------------------------------------

	/**
	 * Constructor de la clase.
	 * 
	 * @param id
	 * @param direccion
	 * @param documento
	 */
	public Persona(String id, String nombre, String documento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
	}

	/**
	 * Constructor de la clase.
	 */
	public Persona() {
		super();
	}

	// ----------------------------------GETS and
	// SETS.-------------------------------

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name= "SPID")
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
	@Column(name="SCNOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * 
	 * @param direccion El nuevo direccion a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo documento
	 * 
	 * @return El documento asociado a la clase
	 */
	@Column(name="SCNUMIDENTIFICACION")
	public String getDocumento() {
		return documento;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo documento
	 * 
	 * @param documento El nuevo documento a modificar.
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
