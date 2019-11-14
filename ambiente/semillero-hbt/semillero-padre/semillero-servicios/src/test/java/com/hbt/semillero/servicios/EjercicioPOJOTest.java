/**
 * EjercicioPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Usuario
 * @version
 */
public class EjercicioPOJOTest {
	public EjerciciosPOJO ejercicio = new EjerciciosPOJO();

	@Test(enabled = false)
	public static void ejercicio2() {
		// private String brand;
		// private boolean empty;
		// public static void ejercicioIni() {
		// WatterBottle wb = new WatterBottle();
		// System.out.println("Empty = "+ wb.Empty);
		// System.out.println("Brand = "+ wb.brand);
	}

	@Test(enabled = false)
	public void ejercicio3() {
		Assert.assertTrue(ejercicio.ejercicio3(222));
		Assert.assertTrue(ejercicio.ejercicio3(0));
		Assert.assertTrue(ejercicio.ejercicio3(5));
	}

	@Test
	public void ejercicio4() {
		Assert.assertEquals(ejercicio.ejercicio4(LocalDate.of(1996, 12, 22)), 2019);
	}

}
