/**
 * Proveedor.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * <b>Descripción:<b> Clase que determina un proveedor
 * 
 * @author Alzate
 * @version 1.0
 */
@Entity
@Table(name = "TC_PROVEEDOR", uniqueConstraints = { @UniqueConstraint(columnNames = { "SPID", "SPDIRECCION" }) })
public class Proveedor extends Persona implements Serializable {

	/**
	 * Atributo que determina el serial
	 */
	private static final long serialVersionUID = 1L;
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
	 * estado del proveedor Activo o inactivo
	 */
	private EstadoEnum estado;
	/**
	 * monto de credito que tiene el proveedor
	 */
	private Long montoCredito;
	/**
	 * id de la persona padre
	 */
	private Long idPersona;

	// ---------------------------------------------constructores---------------------

	/**
	 * Constructor de la clase.
	 */
	public Proveedor() {
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
	 * @param idPersona
	 */
	public Proveedor(String id, String nombre, String documento, String id2, String direccion, LocalDate fechaCreacion,
			EstadoEnum estado, Long montoCredito, Long idPersona) {
		super(id, nombre, documento);
		id = id2;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.montoCredito = montoCredito;
		this.idPersona = idPersona;
	}

	// -----------------------------Gets and sets----------------------------------
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	// @SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR",
	// sequenceName = "SEQ_COMIC")
	@Column(name = "SPID")
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
	@Column(name = "SPDIRECCION")
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
	@Column(name = "SPFECHA_CREACION")
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
	@Column(name = "SPESTADO")
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
	@Column(name = "SPMONTO_CREDITO")
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

	/**
	 * Metodo encargado de retornar el valor del atributo idPersona
	 * 
	 * @return El idPersona asociado a la clase
	 */
	@Column(name = "SPIDPERSONA")
	public Long getIdPersona() {
		return idPersona;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * 
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", direccion=" + direccion + ", fechaCreacion=" + fechaCreacion + ", estado="
				+ estado + ", montoCredito=" + montoCredito + ", idPersona=" + idPersona + "]";
	}

}
