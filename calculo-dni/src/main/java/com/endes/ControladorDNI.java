package com.endes;

public class ControladorDNI {

	private final char[] LETRAS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	private final int DIVISOR_DNI = 23;
	private final int LONGITUD_NUMERO_DNI = 8;
	private final int LONGITUD_DNI_COMPLETO = 9;
	
	
	/**
	 * Calcula la letra correspondiente a un número de DNI
	 * @param numeroDNI cadena con el número del DNI (8 dígitos)
	 * @return Letra correspondiente al DNI
	 * @throws IllegalArgumentException Si el número tiene un formato inválido
	 */
	private char calcularLetra(String numeroDNI) {
		if(numeroDNI == null || numeroDNI.length() != LONGITUD_NUMERO_DNI || !numeroDNI.matches("\\d+")) {
			throw new IllegalArgumentException("El número del DNI no es válido");
		}
		int num = Integer.parseInt(numeroDNI);
		int resto = num % DIVISOR_DNI;
		return LETRAS[resto];
	}
	
	/**
	 * Verifica si un DNI completo es válido
	 * @param dniCompleto DNI completo de 8 dígitos y una letra
	 * @return true si el DNI es válido. False si es caso contrario
	 */
	public boolean esValido(String dniCompleto) {
		
		if(dniCompleto == null || dniCompleto.length() != LONGITUD_DNI_COMPLETO) {
			return false;
		}
		try {
			String numero = dniCompleto.substring(0, LONGITUD_NUMERO_DNI);
			char letra_proporcionada = Character.toUpperCase(dniCompleto.charAt(LONGITUD_DNI_COMPLETO - 1));
			return letra_proporcionada == calcularLetra(numero);
		}catch(IllegalArgumentException exception) {
			return false;
		}
	}
	
}
