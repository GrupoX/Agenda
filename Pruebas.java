/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import com.google.i18n.phonenumbers.NumberParseException;

/**
 *
 * @author yunai
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NumberParseException {
        
        Telefono ej1 = new Telefono(String.valueOf(649988141));
        Telefono ej2 = new Telefono(String.valueOf(916888888));

        System.out.println(ej1.getNumero());
        System.out.println(ej2.getNumero());
        
        System.out.println(ej1.compareTo(ej2));

    }
    
}
