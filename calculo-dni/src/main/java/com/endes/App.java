package com.endes;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ControladorDNI controlador = new ControladorDNI();
        
       
        boolean esvalido = controlador.esValido("23456788T");
        System.out.println("23456788T --> " + esvalido);
    }
}
