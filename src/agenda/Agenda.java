/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import SearchTree.*;
import com.google.i18n.phonenumbers.NumberParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 
 * @author Oscar de la Cuesta Campillo. www.palentino.es
 */
public class Agenda{

    private LinkedBinarySearchTree<Contacto> arbolDeContactos = new LinkedBinarySearchTree<>();
    
    //Consulta si existe un contacto
    public boolean Consultar(String nombre) throws Exception {
        Contacto contactoParaBuscar = new Contacto(nombre);
        return arbolDeContactos.find(contactoParaBuscar)!=null;
    }
    public boolean Consultar(Contacto contacto) {
        if (contacto!=null){
            return this.arbolDeContactos.find(contacto)!=null;
        }else{
            return true;
        }
    }
    public boolean Anadir(Contacto nuevoContacto){
        if(this.Consultar(nuevoContacto)){
            return false;
        }
        else{
            this.arbolDeContactos.insert(nuevoContacto);
            return true;
        }
    }
    
    public boolean Anadir(String nombre, LinkedList telefonos){
        boolean anyadido = false;
        Contacto aConsultar = null;
        try{
        aConsultar = new Contacto (nombre, telefonos);
        }catch(Exception ex){
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!this.Consultar(aConsultar)){
            try {
                Contacto nuevoContacto = new Contacto(nombre, telefonos);
                this.arbolDeContactos.insert(nuevoContacto);
                anyadido = true;
            } catch (NumberParseException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //YA EXISTE CON EL MISMO NOMBRE
            anyadido = false;
        }
        return anyadido;
    }
    
    public boolean Anadir(String nombre, String telefono) throws Exception {
        boolean anyadido = false;
        if(!this.Consultar(nombre)){
            try {
                Telefono tlf = new Telefono(telefono);
                Contacto nuevoContacto = new Contacto(nombre, tlf);
                this.arbolDeContactos.insert(nuevoContacto);
                anyadido = true;
            } catch (NumberParseException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //YA EXISTE CON EL MISMO NOMBRE
            anyadido = false;
        }
        return anyadido;
    }

    public Contacto Buscar(String nombre) {
        Contacto encontrado = null;
        try {
            Telefono tlf = null;
            Contacto contactoParaBuscar = new Contacto(nombre,tlf);
            encontrado = arbolDeContactos.find(contactoParaBuscar).getElement();
        } catch (Exception ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encontrado;
    }

    public void Ordenar() {
       //Ordenado :)
    }

    public LinkedList<Contacto> Mostrar() {
        //Devolver una coleccion?
        Iterator it = this.arbolDeContactos.iterator();
        LinkedList<Contacto> devuelta = new LinkedList<>();
        while(it.hasNext()){
            Position<Contacto> sig = (Position)it.next();
            devuelta.add(sig.getElement());
        }
        return devuelta;
    }

    public void Vaciar() {
        //Mostrar feedBack
        this.arbolDeContactos = null;
        this.arbolDeContactos = new LinkedBinarySearchTree<>();
    }
    //Suponiendo que no exista la posibilidad de dos contactos con el mismo nombre
    public void Eliminar(String nombre) {
        try {
            Telefono tlf = null;
            Contacto contactoParaEliminar = new Contacto(nombre,tlf);
            //Mostrar notificacion de "ELIMINADO"
            this.arbolDeContactos.remove(contactoParaEliminar);
        } catch (Exception ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModificarNombre(String nombreAnt, String nuevoNombre) {
        try {
            Contacto aModificar = this.Buscar(nombreAnt);
            Contacto modificado = aModificar;
             modificado.setNombre(nuevoNombre);
            if (!this.Anadir(modificado)) {
                //Lanzar mensaje, no se ha podido modificar, nombre ya existente
            }else{
                this.arbolDeContactos.remove(aModificar);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearCopiaSeg () {
        String ruta = "/copiaSeguridad/copia.dat";       //declaramos una nueva variable ruta
        try {
            FileOutputStream out = new FileOutputStream(ruta);
            ObjectOutputStream copia = new ObjectOutputStream(out);
            copia.writeObject(this);
            copia.close();
            out.close();
        }
        catch (IOException ex) {
            
        }
    }
    
    public Agenda restCopiaSeg(){
        String ruta = "/copiaSeguridad/copia.dat";
        ObjectInputStream copia = null;
        Agenda agd = new Agenda();
        //String nombreArchivo = "nadkd.dat";
        try {
            FileInputStream in = new FileInputStream(ruta);
            copia = new ObjectInputStream(in);
            agd = (Agenda) copia.readObject();
            copia.close();
            in.close();
        }
        catch(IOException | ClassNotFoundException e){
            
        }
        return agd;
    }
    
}
