/**
 * PersonaDTO.java
 */
package com.hbt.semillero.dto;

/**
 * <b>Descripción:<b> Clase que determina una personaDTO
 * 
 * @author Alzate
 * @version 1.0
 */
public class PersonaDTO {
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
	public PersonaDTO(String id, String nombre, String documento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
	}

	/**
	 * Constructor de la clase.
	 */
	public PersonaDTO() {
		super();
	}

	// ------------------------------------GETS AND SETS----
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
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo documento
	 * 
	 * @return El documento asociado a la clase
	 */
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
