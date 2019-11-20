/**
 * GestionarProveedorRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;

/**
 * Clase que determina el rest de gestionar el proveedor
 * 
 * @author Alzate
 * @version 1,o
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {

	/**
	 * variable que nos permite comunicarnos con el ejb
	 */
	@EJB
	private IGestionarProveedorLocal gestionarProveedor;

	/**
	 * 
	 * Metodo encargado de crear un proveedor
	 * 
	 * @author Alzate
	 * 
	 * @param proveedorNuevo, nuevo proveedor a agregar
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	public void crearProveedor(ProveedorDTO proveedorNuevo) {
		if (proveedorNuevo != null) {
			gestionarProveedor.crearNuevoProveedor(proveedorNuevo);
		}
	}

	/**
	 * 
	 * Metodo encargado de cambiarle el estado al proveedor
	 * 
	 * @author Alzate
	 * 
	 * @param proveedorDTO proveedor a cambiar el estado
	 */
	@POST
	@Path("/cambiarEstado")
	@Produces(MediaType.APPLICATION_JSON)
	public void cambiarEstado(ProveedorDTO proveedorDTO) {
		if (proveedorDTO != null) {
			gestionarProveedor.cambiarEstadoProveedor(proveedorDTO);
		}

	}

	/**
	 * 
	 * Metodo encargado de editar un proveedor
	 * 
	 * @author Alzate
	 * 
	 * @param nuevoMonto,   monto nuevo
	 * @param nombre
	 * @param proveedorDTO, proveedor a editar
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public void editarProveedor(Long nuevoMonto, String nombre, ProveedorDTO proveedorDTO) {
		if (proveedorDTO != null) {
			gestionarProveedor.editarProveedor(nuevoMonto, nombre, proveedorDTO);
		}
	}

	/**
	 * 
	 * Metodo encargado de consultar un proveedor
	 * 
	 * @author Alzate
	 *
	 */
	@GET
	@Path("/consultarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public void consultarProveedor(String id) {
		gestionarProveedor.consultarProveedor(id);
	}

}
