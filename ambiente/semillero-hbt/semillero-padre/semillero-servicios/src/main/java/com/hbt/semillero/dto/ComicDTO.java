package com.hbt.semillero.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.entidades.TematicaEnum;

/**
 * 
 * <b>Descripción:<b> Clase que determina un comic
 * <b>Caso de Uso:<b> 
 * @author Sebastian Alzate
 * @version 1.0
 */
public class ComicDTO {
//-----------------------------ATRIBUTOS-----------------------------------------------
	/*
	 * ID del comic
	 */
	private String id;
	/**
	 * Nombre del comic
	 */
	private String nombre;
	/**
	 * Editorial del comic
	 */
	private String editorial;
	/**
	 * tematica del comic
	 */
	private TematicaEnum tematicaEnum;
	/**
	 * coleccion del comic
	 */
	private String coleccion;
	/**
	 * numero de paginas del comic
	 */
	private Integer numeroPaginas;
	/**
	 * precio del comic
	 */
	private BigDecimal precio;
	/**
	 * Autores del comic
	 */
	private String autores;
	/**
	 * color del comic
	 */
	private Boolean color;
	/**
	 * fecha de publicacion del comic
	 */
	private LocalDate fecha;
	/**
	 * estado del comic (activo o inactivo)
	 */
	//TODO
	private String estado;
	/**
	 * cantidad de comics
	 */
	private Long cantidad;
	
	
	//-----------------------------------------CONSTRUCTORES-----------------------------------
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fecha
	 * @param estado
	 * @param cantidad
	 */
	public ComicDTO(String id, String nombre, String editorial, TematicaEnum tematica, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fecha, String estado,
			Long cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematicaEnum = tematica;
		this.coleccion = coleccion;
		this.numeroPaginas = numeroPaginas;
		this.precio = precio;
		this.autores = autores;
		this.color = color;
		this.fecha = fecha;
		this.estado = estado;
		this.cantidad = cantidad;
	}
	
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 */
	public ComicDTO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	
	/**
	 * Constructor de la clase.
	 */
	public ComicDTO() {
		super();
	}

	//-------------------------------------------------- GETS AND SETS-------------------------------------------
	/**
	 * Metodo encargado de retornar el valor del atributo SCID
	 * @return El sCID asociado a la clase
	 */
	public String getSCID() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo SCID
	 * @param sCID El nuevo sCID a modificar.
	 */
	public void setSCID(String sCID) {
		id = sCID;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo editorial
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo tematica
	 * @return El tematica asociado a la clase
	 */
	public TematicaEnum getTematica() {
		return tematicaEnum;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematica(TematicaEnum tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo numeroPaginas
	 * @return El numeroPaginas asociado a la clase
	 */
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo numeroPaginas
	 * @param numeroPaginas El nuevo numeroPaginas a modificar.
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo autores
	 * @return El autores asociado a la clase
	 */
	public String getAutores() {
		return autores;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo autores
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fecha
	 * @return El fecha asociado a la clase
	 */
	public LocalDate getFecha() {
		return fecha;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fecha
	 * @param fecha El nuevo fecha a modificar.
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Long getCantidad() {
		return cantidad;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
