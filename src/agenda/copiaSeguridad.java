/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Alberto
 */
public class copiaSeguridad {
    
    
    public void crearCopiaSeg (Agenda agd) {
        String ruta = "/copiaSeguridad/copia.dat";       //declaramos una nueva variable ruta
        try {
            FileOutputStream out = new FileOutputStream(ruta);
            ObjectOutputStream copia = new ObjectOutputStream(out);
            copia.writeObject(agd);
            copia.close();
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
            try{
                agd = (Agenda) copia.readObject();
            }
            catch (IOException ioe1) {

            }
            catch(ClassNotFoundException cnfe){

            }
            try{
                copia.close();
            }
            catch(IOException ex2){
            }
        }
        catch (FileNotFoundException fnfe) {
        }
        catch (IOException ioe1) {
        }
        return agd;
    }
    
    
}
