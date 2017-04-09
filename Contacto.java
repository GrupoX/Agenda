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
import SearchTree.Position;
import java.util.LinkedList;
import java.util.Objects;

public class Contacto implements Position{
    private String nombre;
    private LinkedList<Telefono> telefonos;

    public Contacto (String nombre) throws Exception{
        if (nombre!="" && nombre!=null){
           this.nombre=nombre;
           this.telefonos=new LinkedList<>();
        }
        else
          throw new Exception("Contacto requiere nombre y/o telefono");      
    }
    public Contacto(String nombre, Telefono telefono) throws Exception {
        if ((nombre.equals("") ||nombre.equals(null))&&(telefono==null)){
             throw new Exception("Contacto requiere nombre y/o telefono");
        }
        else if((nombre.equals("") ||nombre.equals(null))&&telefono!=null){
            this.nombre=telefono.toString();
            telefonos = new LinkedList<>();
            this.telefonos.add(telefono);
        }else if((!(nombre.equals("") || nombre.equals(null))) &&(telefono==null)){
            this.nombre=nombre;
            telefonos = new LinkedList<>();
        }else{
            this.nombre = nombre;
            this.telefonos=new LinkedList<>();
            this.telefonos.add(telefono);
        }
    }
    public Contacto(String nombre, LinkedList<Telefono> telefonos) throws Exception {
         if ((nombre.equals("") ||nombre.equals(null))&&(telefonos==null)){
             throw new Exception("Contacto requiere nombre y/o telefono");
        }
        else if((nombre.equals("") ||nombre.equals(null))&&telefonos!=null){
            this.nombre=telefonos.get(0).toString();
            this.telefonos=telefonos;
        }else if((!(nombre.equals("") ||nombre.equals(null)))&&(telefonos==null)){
            this.nombre=nombre;
            this.telefonos = new LinkedList<>();
        }else{
            this.nombre = nombre;
            this.telefonos=new LinkedList<>();
            this.telefonos = telefonos;
        }
    }
    public void setNombre(String nomb) throws Exception{                
        if(nomb==null || nomb.equals("")){
            if(this.telefonos.size()==0){
                throw new Exception("Contacto requiere nombre y/o telefono");
            }
            else{
                this.nombre=this.telefonos.get(0).toString();
            }
        }
        else{
            this.nombre=nomb;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public LinkedList<Telefono> getTelefonos() {
        return telefonos;
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
        return this.nombre.equals(other.nombre); 
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

    @Override
    public Object getElement() {
        return this;
    }
}
