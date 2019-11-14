/**
 * EjercicioPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;

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

	/**
	 * 
	 * Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Usuario
	 *
	 */
	@Test(enabled= false)
	public void ejercicio4() {
		Assert.assertEquals(ejercicio.ejercicio4(LocalDate.of(1996, 12, 22)), 2019);
	}

	/**
	 * 
	 * Metodo encargado de probar el ejercicio 5
	 * 
	 * @author Alzate
	 *
	 */
	@Test(enabled=false)
	public void ejercicio5() {
		ejercicio.ejercicio5(50);
		ejercicio.ejercicio5(1);
		ejercicio.ejercicio5(249);
		ejercicio.ejercicio5(-2);
		
		ejercicio.organizarEjercicio5();
		
		Assert.assertEquals(ejercicio.arreglo[0], -2);
		Assert.assertEquals(ejercicio.arreglo[ejercicio.arreglo.length], 249);
		Assert.assertEquals(ejercicio.arreglo.length, 4);
	}

	/**
	 * 
	 * Metodo encargado de  probar el ejercicio 7
	 * @author Alzate
	 *
	 */
	@Test
	public void ejercicio7() {
		int[] f= {3,6,1,6,4};
		int[] d= {6,4,6,5,6};
		
		
		//validamos que haya ganado dominic
		Assert.assertEquals(ejercicio.ejercicio7(f, d),1 );
		//validamos que haya perdido federer
		Assert.assertEquals(ejercicio.ejercicio7(f, d),0 );
		
	}
	
	/**
	 * 
	 * Metodo encargado de  probar el ejercicio 8
	 * @author Azlte
	 *
	 */
	@Test
	public void ejercicio8(){
		int[] res= {1, 0,0,1,5};
		Assert.assertEquals(ejercicio.ejercicio8(5550), res);
	}
	
}
