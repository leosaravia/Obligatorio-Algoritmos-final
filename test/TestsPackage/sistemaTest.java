/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsPackage;

import TestsPackage.Inicializar;
import Dominio.Ciudad;
import TAD.ListaCiudad;
import mainPackage.Isistema;
import mainPackage.SistemaAmbulancia;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class sistemaTest {
    
    public sistemaTest() {
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
     * Test of eliminarAmbulancia method, of class sistema.
     */
    /*@Test
    public void testEliminarAmbulancia() {
        System.out.println("eliminarAmbulancia");
        String ambulanciaID = "";
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.eliminarAmbulancia(ambulanciaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of crearSistemaDeEmergencias method, of class sistema.
     */
    /*@Test
    public void testCrearSistemaDeEmergencias() {
        System.out.println("crearSistemaDeEmergencias");
        int cantidadCiudades = 0;
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.crearSistemaDeEmergencias(cantidadCiudades);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of destruirSistemaEmergencias method, of class sistema.
     */
  /*  @Test
    public void testDestruirSistemaEmergencias() {
        System.out.println("destruirSistemaEmergencias");
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.destruirSistemaEmergencias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of registrarAmbulancia method, of class sistema.
     */
    @Test
    public void testRegistrarAmbulancia() {
        System.out.println("registrarAmbulancia");
        String ambulanciaId = "GBA 1000";
        int ciudadID = 1;
        SistemaAmbulancia instance = new SistemaAmbulancia();
        Inicializar ini = new Inicializar();
        Isistema.TipoRet expResult = Isistema.TipoRet.OK;
        Isistema.TipoRet result = instance.registrarAmbulancia(ambulanciaId, ciudadID);
        assertEquals(expResult, result);
        if(result ==expResult)
        {
           // instance.ambulancias.listar();
            System.out.println("Ambulancia creada correctamente");
            
            //instance.ambulancias.listar(); Uso inicializar y llamo a la lista
        }
        else
        {
          fail("The test case is a prototype.");   
        }
        // TODO review the generated test code and remove the default call to fail.
       
    }
     /*
     GestionAmbulancia g = new GestionAmbulancia();
        Assert.assertEquals(Isistema.TipoRet.OK, g.registrarAmbulancia("ABC123", 1));
    */


    /**
     * Test of deshabilitarAmbulancia method, of class sistema.
     */
   /* @Test
    public void testDeshabilitarAmbulancia() {
        System.out.println("deshabilitarAmbulancia");
        String ambulanciaId = "";
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.deshabilitarAmbulancia(ambulanciaId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of habilitarAmbulancia method, of class sistema.
     */
   /* @Test
    public void testHabilitarAmbulancia() {
        System.out.println("habilitarAmbulancia");
        String ambulanciaID = "";
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.habilitarAmbulancia(ambulanciaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAmbulancia method, of class sistema.
     */
    /*@Test
    public void testBuscarAmbulancia() {
        System.out.println("buscarAmbulancia");
        String ambulanciaID = "GBA 1000";
        sistema instance = new sistema();
        Isistema.TipoRet expResult = Isistema.TipoRet.OK;;
        Isistema.TipoRet result = instance.buscarAmbulancia(ambulanciaID);
        assertEquals(expResult, result);
        if(result ==expResult)
        {
            System.out.println("Buscar ambulasncia ID"+ambulanciaID+"exitoso");
        }else{
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }*/
    /**
     * Test of informeAmbulancia method, of class sistema.
     */
   /* @Test
    public void testInformeAmbulancia_0args() {
        System.out.println("informeAmbulancia");
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.informeAmbulancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of informeAmbulancia method, of class sistema.
     */
    /*@Test
    public void testInformeAmbulancia_int() {
        System.out.println("informeAmbulancia");
        int ciudadID = 0;
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.informeAmbulancia(ciudadID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of cambiarUbicacion method, of class sistema.
     */
    /*@Test
    public void testCambiarUbicacion() {
        System.out.println("cambiarUbicacion");
        String ambulanciaID = "";
        int ciudadID = 0;
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.cambiarUbicacion(ambulanciaID, ciudadID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of agregarCiudad method, of class sistema.
     */
    @Test
    public void testAgregarCiudad() {
        System.out.println("agregarCiudad");
        String ciudadNombre = "Bella Union";
        SistemaAmbulancia instance = new SistemaAmbulancia();
        Isistema.TipoRet expResult =  Isistema.TipoRet.OK;;
        Isistema.TipoRet result = instance.agregarCiudad(ciudadNombre);
        assertEquals(expResult, result);
        if(result ==expResult )
        {
            System.out.println("Ciudad Registrada");
        }else
        {
            fail("The test case is a prototype.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarCiudades method, of class sistema.
     */
    /*@Test
    public void testListarCiudades() {
        System.out.println("listarCiudades");
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.listarCiudades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of agregarRuta method, of class sistema.
     */
   /* @Test
    public void testAgregarRuta() {
        System.out.println("agregarRuta");
        int ciudadOrigen = 0;
        int ciudadDestino = 0;
        int minutosViaje = 0;
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.agregarRuta(ciudadOrigen, ciudadDestino, minutosViaje);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of modificarDemora method, of class sistema.
     */
    /*@Test
    public void testModificarDemora() {
        System.out.println("modificarDemora");
        int ciudadOrigen = 0;
        int ciudadDestino = 0;
        int minutosViaje = 0;
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.modificarDemora(ciudadOrigen, ciudadDestino, minutosViaje);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of ambulanciaMasCercana method, of class sistema.
     */
   /* @Test
    public void testAmbulanciaMasCercana() {
        System.out.println("ambulanciaMasCercana");
        int ciudadID = 0;
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.ambulanciaMasCercana(ciudadID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of rutaMasRapida method, of class sistema.
     */
   /* @Test
    public void testRutaMasRapida() {
        System.out.println("rutaMasRapida");
        int ciudadOrigen = 0;
        int ciudadDestino = 0;
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.rutaMasRapida(ciudadOrigen, ciudadDestino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of informeCiudades method, of class sistema.
     */
   /* @Test
    public void testInformeCiudades() {
        System.out.println("informeCiudades");
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.informeCiudades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of ciudadesEnRadio method, of class sistema.
     */
   /* @Test
    public void testCiudadesEnRadio() {
        System.out.println("ciudadesEnRadio");
        int ciudadID = 0;
        int duracionViaje = 0;
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.ciudadesEnRadio(ciudadID, duracionViaje);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of registrarChofer method, of class sistema.
     */
    /*@Test
    public void testRegistrarChofer() {
        System.out.println("registrarChofer");
        String ambulanciaID = "GBA 1000";
        String nombre = "Gianni";
        String cedula = "45043255";
        sistema instance = new sistema();
        Isistema.TipoRet expResult = Isistema.TipoRet.OK;
        Isistema.TipoRet result = instance.registrarChofer(ambulanciaID, nombre, cedula);
        assertEquals(expResult, result);
        if(result==expResult)
        {
            System.out.println("Chofer registrado correctamente");
        }
        else
        {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }*/
   
    /**
     * Test of eliminarChofer method, of class sistema.
     */
   /* @Test
    public void testEliminarChofer() {
        System.out.println("eliminarChofer");
        String ambulanciaID = "";
        String cedula = "";
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.eliminarChofer(ambulanciaID, cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of informeChoferes method, of class sistema.
     */
    /*@Test
    public void testInformeChoferes() {
        System.out.println("informeChoferes");
        String ambulanciaID = "";
        sistema instance = new sistema();
        Isistema.TipoRet expResult = null;
        Isistema.TipoRet result = instance.informeChoferes(ambulanciaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
