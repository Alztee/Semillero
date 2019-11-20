/**
 * GestionarProveedorBean.java
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.Proveedor;

/**
 * <b>Descripción: gestionar proveedor Bean
 * 
 * @author Alzate
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarProveedorBean implements IGestionarProveedorLocal {

	/**
	 * atributo que tiene contacto con la DB, los manipula
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#crearNuevoProveedor(com.hbt.semillero.dto.ProveedorDTO)
	 *      metodo que crea un nuevo proveedor
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearNuevoProveedor(ProveedorDTO nuevoProveedor) {
		int cantidadProveedores = consultarProveedores().size();
		if (nuevoProveedor != null && cantidadProveedores < 30 && consultarProveedor(nuevoProveedor.getId()) == null) {
			if (verificarMonto(nuevoProveedor.getMontoCredito())) {
				Proveedor proveedor = convertirProveedroDTOToProveedor(nuevoProveedor);
				em.persist(proveedor);
				System.out.println("el monto es correcto, cantidad de proveedores correcto");
			}
		}
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#cambiarEstadoProveedor(com.hbt.semillero.dto.ProveedorDTO)
	 *      metodo que cambia el estado del proveedor
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cambiarEstadoProveedor(ProveedorDTO proveedor) {
		Proveedor nuevoProveedor = convertirProveedroDTOToProveedor(proveedor);
		if (nuevoProveedor != null) {
			if (nuevoProveedor.getEstado().equals((EstadoEnum.ACTIVO))) {
				nuevoProveedor.setEstado(EstadoEnum.INACTIVO);
			} else {
				nuevoProveedor.setEstado(EstadoEnum.ACTIVO);
			}
		}
		em.merge(nuevoProveedor);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedores()
	 *      metodo que retona la lista de proveedores que hay
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProveedorDTO> consultarProveedores() {
		List<ProveedorDTO> resultadosProveedores = new ArrayList<ProveedorDTO>();
		List<Proveedor> resultados = em.createQuery("select p from TC_PROVEEDOR p").getResultList();
		for (Proveedor proveedor : resultados) {
			resultadosProveedores.add(convertirProveedorToProveedorDTO(proveedor));
		}
		return resultadosProveedores;
	}

	/**
	 * Metodo encargado de convertir un ProveedorDTO a un Proveedor
	 * 
	 * @author Alzate Leon
	 * 
	 * @param proveedorDTO a convertir
	 * @return Proveedor
	 */
	private Proveedor convertirProveedroDTOToProveedor(ProveedorDTO proveedorDTO) {
		Proveedor proveedor = new Proveedor();
		if (proveedorDTO.getId() != null) {
			proveedor.setId(proveedorDTO.getId());
		}
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setDocumento(proveedorDTO.getDocumento());
		proveedor.setEstado(proveedorDTO.getEstado());
		proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
		// proveedor.setIdPersona(proveedorDTO.getId());
		proveedor.setMontoCredito(proveedorDTO.getMontoCredito());
		proveedor.setNombre(proveedorDTO.getNombre());

		return proveedor;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#editarProveedor(java.lang.Long,
	 *      com.hbt.semillero.dto.ProveedorDTO) metodo que edita el monto del
	 *      proveedor si el monto es aceptable y el nombre si no es null
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarProveedor(Long nuevoMonto, String nombre, ProveedorDTO proveedorDTO) {
		Proveedor proveedor = convertirProveedroDTOToProveedor(proveedorDTO);
		if (proveedor != null) {
			if (verificarMonto(nuevoMonto) == Boolean.TRUE) {

				proveedor.setMontoCredito(nuevoMonto);
			}
			if (nombre != null) {
				proveedor.setNombre(nombre);
			}
		}
		em.merge(proveedor);
	}

	/**
	 * metodo que permite verificar que el monto esten en el rango que es
	 * 
	 * @author Alzate
	 * 
	 * @param monto
	 * @return true, si el monto es aceptado, false si no
	 */
	public Boolean verificarMonto(Long monto) {
		Boolean estado = Boolean.FALSE;
		if (monto < 15000000) {
			estado = Boolean.TRUE;
		}
		if (monto > 15000000 && monto < 20000000) {
			estado = Boolean.TRUE;
			System.out.println("credito a coparse");
		} else {
			System.out.println("credito imposible");
		}
		return estado;
	}

	/**
	 * 
	 * Metodo encargado de convertir un proveedor a un proveedorDTO
	 * 
	 * @author Lzate
	 * 
	 * @param proveedor a convertir en proveedorDTO
	 * @return 1.0
	 */
	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		if (proveedorDTO.getId() != null) {
			proveedorDTO.setId(proveedor.getId());
		}
		proveedorDTO.setDireccion(proveedor.getDireccion());
		proveedorDTO.setDocumento(proveedor.getDocumento());
		proveedorDTO.setEstado(proveedor.getEstado());
		proveedorDTO.setFechaCreacion(proveedor.getFechaCreacion());
		proveedorDTO.setMontoCredito(proveedor.getMontoCredito());
		proveedorDTO.setNombre(proveedor.getNombre());
		return proveedorDTO;

	}

	/**
	 * 
	 * Metodo encargado de validar que el contrato este en el tiempo correcto
	 * 
	 * @author Alzate
	 * 
	 * @param fecha, fecha se creacion del contrato @return, true si esta en el
	 *               tiempo, false si ya se paso el año
	 */
	public Boolean validarContrato(LocalDate fecha) {
		Boolean estado = Boolean.FALSE;
		LocalDate fechaValidacion = LocalDate.now();
		long dias = ChronoUnit.DAYS.between(fecha, fechaValidacion);
		if (dias < 360) {
			estado = Boolean.TRUE;
		}

		return estado;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedor(java.lang.String)
	 *      metodo que consulta un proveedor
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProveedorDTO consultarProveedor(String id) {
		Proveedor proveedor = em.find(Proveedor.class, Long.parseLong(id));
		if (proveedor != null) {
			ProveedorDTO proveedorDTO = convertirProveedorToProveedorDTO(proveedor);
			return proveedorDTO;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * Metodo encargado de retornar lista de los proveedores
	 * 
	 * @author Alzate
	 * 
	 * @return lista con los proveedores
	 */
	public List<Proveedor> consultarTodos() {
		// nombre, entidades
		List<Proveedor> resultados = (List<Proveedor>) em.createQuery("select p from TC_PROVEEDOR p").getResultList();
		return resultados;
	}

}
