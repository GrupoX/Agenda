/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author pc
 */
import java.util.LinkedList;
import java.util.Objects;

public class Contacto {
    private String nombre;
    private LinkedList<Telefono> telefonos;

    
    public Contacto(String nombre, Telefono telefono) throws Exception {
        if ((nombre.equals(""))&&(telefono==null)){
             throw new Exception("Contacto requiere nombre y/o telefono");
        }
        else if((nombre.equals(""))&&telefono!=null){
            this.nombre=telefono.toString();
            telefonos = new LinkedList<>();
            this.telefonos.add(telefono);
        }else if((!nombre.equals(""))&&(telefono==null)){
            this.nombre=nombre;
            telefonos = new LinkedList<>();
        }
      
    }
    public Contacto(String nombre, LinkedList<Telefono> telefonos) throws Exception {
        
        if ((nombre==null || nombre=="") && (telefonos==null)){
             throw new Exception("Contacto requiere nombre y/o telefono");
        }
        this.nombre = nombre;
        this.telefonos = new LinkedList<>();
        if (telefonos!=null)
            this.telefonos = telefonos;
    }
    public void setNombre(String nomb) throws Exception{                
        if (this.telefonos.size()==0){
            if (nomb==null ||nomb=="")
             throw new Exception("Contacto requiere nombre y/o telefono");
        }
        this.nombre=nomb;
    }

    public String getNombre() {
        return this.nombre;
    }

    public LinkedList<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(LinkedList<Telefono> telefonos) throws Exception {
        if (this.nombre==null || this.nombre==""){
            if (telefonos==null || telefonos.size()==0)
                throw new Exception("Contacto requiere nombre y/o telefono");
        }
        this.telefonos=telefonos;
    }
    
    public void anadeTelefono(Telefono a){
        if (a!=null){
            telefonos.add(a);
        }
    }
    public void borraTelefono(Telefono a){
        if (a!=null){
            telefonos.remove(a);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public int compareTo(Contacto a){
       int ret =  this.nombre.compareTo(a.nombre);
       
       if (ret==0){
           return this.telefonos.get(0).compareTo(a.telefonos.get(0));
       }
       else{
           return ret;
       }
    }
}
