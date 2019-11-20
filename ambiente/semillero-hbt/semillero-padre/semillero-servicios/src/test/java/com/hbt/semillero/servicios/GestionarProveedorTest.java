/**
 * GestionarProveedorTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.time.Month;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.ejb.GestionarProveedorBean;

/**
 * <b>Descripción:clse que permite realizar las pruebas unitarias de egstionar
 * un proveedor
 * 
 * @author Alzate
 * @version 1.0
 */
public class GestionarProveedorTest {

	public GestionarProveedorBean bean = new GestionarProveedorBean();

	/**
	 * 
	 * Metodo encargado de validar si el contrato esta en el tiempo correcto
	 * 
	 * @author Alzate
	 *
	 */
	@Test(enabled = false)
	public void validarFecha() {
		LocalDate fecha = LocalDate.of(2000, Month.JANUARY, 1);

		// mandar falso por que ya lleva mas de un año
		Assert.assertEquals(bean.validarContrato(fecha), Boolean.FALSE);

	}

	/**
	 * Metodo encargado de test validar si el monto esta bien
	 * 
	 * @author Azalte
	 *
	 */
	@Test
	public void validarMonto() {
		Long monto = 19000000L;
		Long monto2 = 21000000L;
		Assert.assertEquals(bean.verificarMonto(monto), Boolean.TRUE);
		Assert.assertEquals(bean.verificarMonto(monto2), Boolean.FALSE);
	}

}
