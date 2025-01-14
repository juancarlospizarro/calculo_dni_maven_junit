/**
 * 
 */
package com.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class ControladorDNITest {

	ControladorDNI controlador;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		controlador = new ControladorDNI();
	}



	@Test
	@DisplayName("Validación de DNI válido")
	void testValidoDNI() {
		assertTrue(controlador.esValido("11111111H"));
	}
	
	@Test
	@DisplayName("Validación de DNI falso")
	void testFalsoDNI() {
		assertFalse(controlador.esValido("11111111R"));
	}
	
	@Test
	@DisplayName("Validación de entradas inválidas para DNI")
	void testEsVallidoDNI() {
		assertFalse(controlador.esValido(null), "Un DNI nulo fue reconocido como válido");
	}
	
	@Test
	@DisplayName("Un DNI demasiado corto")
	void testDNIcorto() {
		assertTrue(controlador.esValido("1111H"), "El DNI es demasiado corto");
	}
	
	@Test
	@DisplayName("DNI con caractéres no numéricos")
	void testDNIconCaracteresNoNumericos() {
		assertFalse(controlador.esValido("++23ed4t+"), "El DNI contiene carácteres no numéricos");
	}
	
	
}
