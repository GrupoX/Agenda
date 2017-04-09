/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import com.google.i18n.phonenumbers.NumberParseException;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yunai
 */
public class ContactoTest {
    
    public ContactoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setNombre method, of class Contacto.
     */
    
    @Test
    public void testConstructor() throws Exception {
        Telefono tel = new Telefono(String.valueOf(69994499));
        Contacto instance = new Contacto("Ejemplo Martín",tel);
        assertEquals(instance.getNombre(),"Ejemplo Martín");
        assertEquals(instance.getTelefonos().get(0),tel);
        // TODO review the generated test code and remove the default call to fail.
    }
       @Test
    public void testConstructor2() throws Exception {
        Telefono tel = new Telefono(String.valueOf(69994499));
        Contacto instance = new Contacto("",tel);
        assertEquals(instance.getNombre(),tel.getNumero().toString());
        assertEquals(instance.getTelefonos().get(0).getNumero(),tel.getNumero());
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testConstructor3() throws Exception {       
        Exception exception = null;
        try{
           Contacto instance = new Contacto("");
        }
        catch (Exception ex){
            exception = ex;
        }

        assertNotNull(exception);
    }
    @Test
    public void testConstructor4() throws Exception {       
        Exception exception = null;
        try{
           Contacto instance = new Contacto("al");
        }
        catch (Exception ex){
            exception = ex;
        }

        assertNull(exception);
    }
    @Test
    public void testConstructor5() throws Exception {       
        Exception exception = null;
        try{
           Contacto instance = new Contacto(null);
        }
        catch (Exception ex){
            exception = ex;
        }
        assertNotNull(exception);
    }
    @Test
    public void testConstructor6() throws Exception {       
        Exception exception = null;
        try{
           Contacto instance = new Contacto("");
        }
        catch (Exception ex){
            exception = ex;
        }
        assertNotNull(exception);
    }
    @Test
    public void testConstructor7() throws Exception {       
        Exception exception = null;
        try{
           Telefono x = null; 
           Contacto instance = new Contacto("al",x);
        }
        catch (Exception ex){
            exception = ex;
        }
        assertNull(exception);
    }
    @Test
    public void testConstructor8() throws Exception {       
        Exception exception = null;
        try{
           Telefono x = null; 
           Contacto instance = new Contacto(null,x);
        }
        catch (Exception ex){
            exception = ex;
        }
        assertNotNull(exception);
    }
    @Test
    public void testConstructor9() throws Exception {       
        Exception exception = null;
        try{
           Telefono x = null; 
           Contacto instance = new Contacto("",x);
        }
        catch (Exception ex){
            exception = ex;
        }
        assertNotNull(exception);
    }
    @Test
    public void testTelefono1() throws Exception {
        Telefono tel = new Telefono(String.valueOf(6));   
        assertEquals(null,tel.getNumero());       
    }
    @Test
    public void testTelefono2() throws Exception {
        Telefono tel = new Telefono(String.valueOf(60));   
        assertEquals(null,tel.getNumero());       
    }
    @Test
    public void testTelefono3() throws Exception {
        Telefono tel = new Telefono(String.valueOf(600));   
        assertNotNull(tel.getNumero());
    }
    
    @Test 
    public void testSetNombre1() throws Exception{
        Exception exception=null;
        try{
        Telefono t =new Telefono(String.valueOf(800));
        Contacto ejemplo = new Contacto("al",t);
        ejemplo.setNombre("");
        } catch (Exception e){
            exception = e;
        }
        assertNull(exception);
    }
    @Test 
    public void testSetNombre2() throws Exception{
        Exception exception=null;
        try{
        Telefono t =new Telefono(String.valueOf(800));
        Contacto ejemplo = new Contacto("al",t);
        ejemplo.setNombre(null);
        } catch (Exception e){
            exception = e;
        }
        assertNull(exception);
    }
    @Test 
    public void testSetNombre3() throws Exception{
        Exception exception=null;
        try{
        Telefono t =null;
        Contacto ejemplo = new Contacto("al",t);
        ejemplo.setNombre("");
        } catch (Exception e){
            exception = e;
        }
        assertNotNull(exception);
    }
    @Test 
    public void testSetNombre4() throws Exception{
        Exception exception=null;
        try{
        Telefono t =null;
        Contacto ejemplo = new Contacto("al",t);
        ejemplo.setNombre(null);
        } catch (Exception e){
            exception = e;
        }
        assertNotNull(exception);
    }
    @Test
    public void testAnadeTelefono1() throws Exception {
        Exception exception=null;
        try{
            Telefono t = new Telefono("600");
            Contacto ejemplo = new Contacto("al");
            ejemplo.anadeTelefono(t);
        } catch (Exception e){
            exception = e;
        }
        assertNull(exception);
    }
    @Test
    public void testBorraTelefono1() throws Exception {
        Exception exception=null;
        try{
            Telefono t = new Telefono("600");
            Contacto ejemplo = new Contacto("al",t);
            ejemplo.borraTelefono(t);
        } catch (Exception e){
            exception = e;
        }
        assertNull(exception);
    }

    /**
     * Test of equals method, of class Contacto.
     */
    @Test
    public void testEquals1() throws Exception {       
        Telefono ej1 = new Telefono("666");
        Telefono ej2 = new Telefono("999");
        
        Contacto x = new Contacto("pepe",ej1);
        Contacto y = new Contacto("pepe",ej2);
        Boolean resp = x.equals(y);
        assertEquals(resp, true);
    }
    @Test
    public void testEquals2() throws Exception {   
        Telefono ej1 = new Telefono("666");
        Telefono ej2 = new Telefono("666");
        
        Contacto x = new Contacto("pepe",ej1);
        Contacto y = new Contacto("jose",ej2);
        Boolean resp = x.equals(y);
        assertEquals(resp, false);
    }
}
