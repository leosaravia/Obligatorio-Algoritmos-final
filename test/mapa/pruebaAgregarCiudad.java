
package mapa;

import ambulancias.*;
import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;
import utils.FuncionalidadesComunes;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class pruebaAgregarCiudad {

    /**
     * Si ya hay registradas cantCiudades en el Sistema de emergencias Se deberá
     * imprimir en pantalla: “No se pueden ingresar la ciudadNombre al sistema
     * por no tener más capacidad.”
     */
   

    @Test
    public void testAgregarUnaCiudad() {
     FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        assertEquals(ISistema.TipoRet.OK,s.agregarCiudad("Ciudad1"));
   

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testAgregarUnaCiudadMasQueLaCantidadMaximaDeCiudades() {

        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(5);

        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad1"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad2"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad3"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad4"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad5"));
        assertEquals(ISistema.TipoRet.ERROR, s.agregarCiudad("Ciudad5"));
     

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testAgregarJustoLaCantidadMaximaDeCiudades() {

        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(5);

        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad1"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad2"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad3"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad4"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad5"));
     

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    

}
