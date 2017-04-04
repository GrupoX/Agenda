/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import SearchTree.Position;
import SearchTree.RBTree;
import com.google.i18n.phonenumbers.NumberParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 
 * @author Oscar de la Cuesta Campillo. www.palentino.es
 */
public class Agenda{

    private RBTree<Contacto> arbolDeContactos = new RBTree<>();
    
    //Consulta si existe un contacto
    public boolean Consultar(String nombre, String telefono) {
        Contacto encontrado = null;
        try {
            Telefono tlf = null;
            Contacto contactoParaBuscar = new Contacto(nombre,tlf);
            encontrado = (Contacto)arbolDeContactos.find(contactoParaBuscar);
        } catch (Exception ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encontrado!=null;
    }
    public boolean Consultar(Contacto contacto) {
        return this.arbolDeContactos.find(contacto)!=null;
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

    public boolean Anadir(String nombre, String telefono) {
        boolean anyadido = false;
        if(!this.Consultar(nombre, telefono)){
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
            encontrado = (Contacto)arbolDeContactos.find(contactoParaBuscar);
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
           devuelta.add((Contacto)it.next());
        }
        return devuelta;
    }

    public void Vaciar() {
        //Mostrar feedBacj
        this.arbolDeContactos = null;
    }
    //Suponiendo que no exista la posibilidad de dos contactos con el mismo nombre
    public void Eliminar(String nombre) {
        try {
            Telefono tlf = null;
            Contacto contactoParaEliminar = new Contacto(nombre,tlf);
            //Mostrar notidicacion de "ELIMINADO2
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
    

}

