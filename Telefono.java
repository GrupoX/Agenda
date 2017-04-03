/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import com.google.i18n.phonenumbers.*;
import java.util.Objects;

/**
 *
 * @author yunai
 */
public class Telefono {
    
 private PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
 private ShortNumberInfo shortInfo = ShortNumberInfo.getInstance();
 private Phonenumber.PhoneNumber numero = new Phonenumber.PhoneNumber();
 
 public Telefono (String a) throws NumberParseException{
    if (a.length()>=3){ 
        numero = phoneUtil.parse(a, "ES");
    }
    else{
        numero = null;
    }
 }

    public Phonenumber.PhoneNumber getNumero() {
        return numero;
    }

    public void setNumero(String a) throws NumberParseException {
        if (a.length()>=3){ 
        numero = phoneUtil.parse(a, "ES");
        }
        else{
            numero = null;
        }
    }
    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }
    
    public int compareTo(Telefono a){
       return this.numero.toString().compareTo(a.numero.toString());  
    }
 
}
