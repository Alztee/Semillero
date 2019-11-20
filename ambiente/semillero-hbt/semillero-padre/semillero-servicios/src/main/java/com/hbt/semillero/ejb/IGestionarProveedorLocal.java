/**
 * IGestionarProveedor.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.ProveedorDTO;

/**
 * Interface que determina gestionar proveedor
 * 
 * @author Alzate
 * @version 1.0
 */
public interface IGestionarProveedorLocal {

	/**
	 * 
	 * Metodo encargado de crear un nuevo proveedor de comics
	 * 
	 * @author Alzate
	 * 
	 * @param nuevoProveedor
	 */
	public void crearNuevoProveedor(ProveedorDTO nuevoProveedor);

	/**
	 * 
	 * Metodo encargado de cambiarle el estado al proveedor
	 * 
	 * @author Alzate
	 * 
	 * @param proveedor, al que se le va a cambiar el estado
	 */
	public void cambiarEstadoProveedor(ProveedorDTO proveedor);

	/**
	 * 
	 * Metodo encargado de mostrar la lista de todos ls proveedores
	 * 
	 * @author Alzate
	 * 
	 * @return lista de proveedores actuales
	 */
	public List<ProveedorDTO> consultarProveedores();

	/**
	 * 
	 * Metodo encargado de editar el nombre y/o el monto al proveedor
	 * 
	 * @author Alzate
	 * 
	 * @param nuevoMonto, nuevo monto a agregar
	 * @param nombre,     nuevo nombre a cambias
	 * @param proveedor,  proveedor a editar
	 */
	public void editarProveedor(Long nuevoMonto, String nombre, ProveedorDTO proveedor);

	/**
	 * 
	 * Metodo encargado de retornar un proveedor por su id
	 * 
	 * @author Alzate
	 * 
	 * @param id por el cual se va a buscar el proveedor
	 * @return proveedorDTO
	 */
	public ProveedorDTO consultarProveedor(String id);
}
