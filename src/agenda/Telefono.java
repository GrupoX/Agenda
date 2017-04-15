/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import com.google.i18n.phonenumbers.*;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author yunai
 */
public class Telefono implements Serializable{
    
private String numero;

 
public Telefono (String a) throws NumberParseException{
    PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    ShortNumberInfo shortInfo = ShortNumberInfo.getInstance();
    Phonenumber.PhoneNumber numeroP = new Phonenumber.PhoneNumber();
    if (a.length()>=3){ 
        numeroP = phoneUtil.parse(a, "ES");
        numero = String.valueOf(numeroP.getNationalNumber());
    }
    else{
        numero = null;
    }
 }
    public String getNumero(){
        return numero;
    }


    public void setNumero(String a) throws NumberParseException {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        ShortNumberInfo shortInfo = ShortNumberInfo.getInstance();
        Phonenumber.PhoneNumber numeroP = new Phonenumber.PhoneNumber();
        if (a.length()>=3){ 
            numeroP = phoneUtil.parse(a, "ES");
            numero = String.valueOf(numeroP.getNationalNumber());
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
       return this.numero.compareTo(a.numero);  
    }
 
}

