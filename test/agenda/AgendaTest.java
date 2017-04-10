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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class AgendaTest {
    Agenda testAgenda;
    
    public AgendaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testAgenda = new Agenda();
        testAgenda.Anadir("Manuel","666777888");
        testAgenda.Anadir("Manu","555666777");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Consultar method, of class Agenda.
     */
    @Test
    public void testConsultar_String_String_False() {
        this.setUp();
        System.out.println("Consultar");
        String nombre = "Manue";
        String telefono = "";
        boolean expResult = false;
        boolean result = this.testAgenda.Consultar(nombre, telefono);
        assertEquals(expResult, result);
    }
     @Test
    public void testConsultar_String_String_True() {
        this.setUp();
        System.out.println("Consultar");
        String nombre = "Manuel";
        String telefono = "";
        boolean expResult = true;
        boolean result = this.testAgenda.Consultar(nombre, telefono);
        assertEquals(expResult, result);
    }

    /**
     * Test of Consultar method, of class Agenda.
     */
    @Test
    public void testConsultar_Contacto_False() throws NumberParseException, Exception {
        this.setUp();
        System.out.println("Consultar");
        String nombre = "Manue";
        String telefono = "";
        Telefono tlf = new Telefono(telefono);
        Contacto test = new Contacto(nombre,tlf);
        boolean expResult = false;
        boolean result = this.testAgenda.Consultar(test);
        assertEquals(expResult, result);
    }
     public void testConsultar_Contacto_True() throws NumberParseException, Exception {
        this.setUp();
        System.out.println("Consultar");
        String nombre = "Manuel";
        String telefono = "";
        Telefono tlf = new Telefono(telefono);
        Contacto test = new Contacto(nombre,tlf);
        boolean expResult = true;
        boolean result = this.testAgenda.Consultar(test);
        assertEquals(expResult, result);
    }

    /**
     * Test of Anadir method, of class Agenda.
     */
    @Test
    public void testAnadir_Contacto_False() throws NumberParseException, Exception {
        this.setUp();
        System.out.println("Anadir");
        String nombre = "Manuel";
        Telefono tlf = new Telefono("666777888");
        Contacto nuevoContacto = new Contacto(nombre, tlf);
        boolean expResult = false;
        boolean result = this.testAgenda.Anadir(nuevoContacto);
        assertEquals(expResult, result);
    }
    
    @Test
     public void testAnadir_Contacto_True() throws NumberParseException, Exception {
        this.setUp();
        System.out.println("Anadir");
        String nombre = "Manue";
        Telefono tlf = new Telefono("666777888");
        Contacto nuevoContacto = new Contacto(nombre, tlf);
        boolean expResult = true;
        boolean result = this.testAgenda.Anadir(nuevoContacto);
        assertEquals(expResult, result);
    }

    /**
     * Test of Anadir method, of class Agenda.
     */
    @Test
    public void testAnadir_String_String_True() {
        this.setUp();
        System.out.println("Anadir");
        String nombre = "Manue";
        String tlf = "666777888";
        boolean expResult = true;
        boolean result = this.testAgenda.Anadir(nombre,tlf);
        assertEquals(expResult, result);
    }
     @Test
    public void testAnadir_String_String_False() {
        this.setUp();
        System.out.println("Anadir");
        String nombre = "Manuel";
        String tlf = "666777888";
        boolean expResult = false;
        boolean result = this.testAgenda.Anadir(nombre,tlf);
        assertEquals(expResult, result);
    }

    /**
     * Test of Buscar method, of class Agenda.
     */
    @Test
    public void testBuscar() throws NumberParseException, Exception {
        this.setUp();
        System.out.println("Buscar");
        Telefono tlf = new Telefono("666555444");
        Contacto expResult = new Contacto("Manuel",tlf);
        Contacto result = this.testAgenda.Buscar("Manuel");
        assertEquals(expResult, result);
    }

    /**
     * Test of Mostrar method, of class Agenda.
     */
    @Test
    public void testMostrar() throws NumberParseException, Exception {
        this.setUp();
        System.out.println("Mostrar");
        Contacto test1 = new Contacto("Manuel", new Telefono("666777888"));
        Contacto test2 = new Contacto("Manu", new Telefono("555666777"));
        LinkedList<Contacto> expResult = new LinkedList<>();
        expResult.add(test1);
        expResult.add(test2);
        LinkedList<Contacto> result = this.testAgenda.Mostrar();
        assertEquals(expResult, result);
    }

    /**
     * Test of Vaciar method, of class Agenda.
     */
    /*@Test
    public void testVaciar() {
        this.setUp();
        System.out.println("Vaciar");
        this.testAgenda.Vaciar();
    }*/

    /**
     * Test of Eliminar method, of class Agenda.
     */
    @Test
    public void testEliminar() {
        this.setUp();
        System.out.println("Eliminar");
        String nombre = "Manuel";
        this.testAgenda.Eliminar(nombre);
        boolean expected = true;
        boolean returned = this.testAgenda.Anadir("Manuel", "666777888");
        assertEquals(expected, returned);;
    }

    /**
     * Test of ModificarNombre method, of class Agenda.
     */
    @Test
    public void testModificarNombre() {
        this.setUp();
        this.testAgenda.ModificarNombre("Manue","Manolo");
        boolean expResult = false;
        boolean result = this.testAgenda.Anadir("Manolo", "666777888");
        assertEquals(expResult, result);
    }
    
}
