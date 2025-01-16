package com.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

	CuentaBancaria cuenta;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new CuentaBancaria(1000);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/*
	 * Pruebas del constructor
	 */

	@Test
	@DisplayName("Prueba el saldo inicial es correcto")
	void testConstructorValido() {
		double resultadoEsperado = 1000.0;
		assertEquals(resultadoEsperado, cuenta.getSaldo(), "No se corresponde el saldo obtenido con el pasado.");
	}
	
	@Test
	@DisplayName("Prueba donde el saldo inicial es negativo")
	void testConstructorNoValido() {
		String mensajeEsperado = "El saldo inicial no puede ser negativo.";
		Exception e = assertThrows(IllegalArgumentException.class, () -> new CuentaBancaria(-200));
		
		assertEquals(mensajeEsperado, e.getMessage(), "Deben coincidir las respuestas al crear la cuenta");
	}
	
	
	/*
	 * Método depositar
	 */
	
	@Test
	@DisplayName("Depositar saldo positivo")
	void testDepositarSaldoPositivo() {
		Double valorEsperado = 1500.0;
		Double valor = cuenta.depositar(500);
		
		assertEquals(valorEsperado, valor, "La cuenta depositar no se corresponde");
	}
	
	@Test
	@DisplayName("Retirar saldo negativo")
	void testDepositarSaldoNegativo() {
		String mensajeEsperado = "La cantidad a depositar debe ser positiva.";
		Exception e = assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-100));
		String mensajeRetornado = e.getMessage();
		
		assertEquals(mensajeEsperado, mensajeRetornado, "No se puede retirar saldo negativo");
	}
	
	@Test
	@DisplayName("Retirar cantidad negativa")
	void testRetirarCantidadNegativa() {
		String mensajeEsperado = "La cantidad a retirar debe ser positiva.";
		Exception e = assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(-100));
		String mensajeRetornado = e.getMessage();
		
		assertEquals(mensajeEsperado, mensajeRetornado);
	}
	
	
	@Test
	@DisplayName("Retirar fondos insuficientes")
	void testRetirarFondosInsuficientes() {
		String mensajeEsperado = "Fondos insuficientes para retirar.";
		Exception e = assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(1500));
		String mensajeRetornado = e.getMessage();
		
		assertEquals(mensajeEsperado, mensajeRetornado);
	}
	
	@Test
	@DisplayName("Retirar fondos válidos")
	void testRetirarFondosValidos() {
		Double valorEsperado = 500.0;
		Double valor = cuenta.retirar(500);
		
		assertEquals(valorEsperado, valor, "El saldo no se correspondecon la cuenta.");
	}
	
	@Test
	@DisplayName("Retirar misma cantidad que saldo disponible")
	void testRetirarMismaCantidadSaldo() {
		Double valorEsperado = 0.0;
		Double valor = cuenta.retirar(1000);
		assertEquals(valorEsperado, valor, "El saldo no se correspondecon la cuenta.");
	}
	
	@Test
	@DisplayName("El saldo no debe cambiar si se lanza una excepción.")
	void testEstadoConsistente() {
		Double valorEsperado = cuenta.getSaldo();
		try {
			cuenta.retirar(1500);
		}catch(Exception e) {
			
		}
		Double valor = cuenta.getSaldo();
		
		assertEquals(valorEsperado, valor);
	}
	
	// Secuencias
	
	@Test
	@DisplayName("Secuencia de operaciones de depósito y retirar")
	void testSecuenciaDeOperaciones() {
		Double valorEsperado = 1200.0;	
		cuenta.depositar(500);
		cuenta.retirar(300);
		Double valor = cuenta.getSaldo();
		
		assertEquals(valorEsperado, valor);
	}

}
