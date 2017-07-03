
package ambulancias;

import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.FuncionalidadesComunes;

public class pruebaEliminarAmbulancia {

    /**
     * Si la ambulancia ambulanciaID no existe en el sistema de emergencias,
     * deberá imprimir en pantalla: “No existe una ambulancia con identificador
     * ambulanciaID.”
     *
     * Si la ambulancia ambulanciaID está asignada a un viaje, deberá imprimir
     * en pantalla: “No es posible eliminar la ambulancia ambulanciaID
     */
    
    @Test
    public void testEliminarUnaAmbulanciaInexisteConNingunaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        assertEquals(ISistema.TipoRet.ERROR, s.eliminarAmbulancia("SBA1232"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testEliminarUnaAmbulanciaInexisteConAlMenosUnaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 2);
        assertEquals(ISistema.TipoRet.ERROR, s.eliminarAmbulancia("SBA1232"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testEliminarUnaAmbulanciaYaEliminadaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 2);
        assertEquals(ISistema.TipoRet.OK, s.eliminarAmbulancia("SBA1234"));
        assertEquals(ISistema.TipoRet.ERROR, s.eliminarAmbulancia("SBA1234"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testEliminarUnaAmbulanciaValidaConVariasAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 1);
        s.registrarAmbulancia("SBA1235", 1);
        s.registrarAmbulancia("SBA1236", 1);
        s.registrarAmbulancia("SBA1237", 1);
        s.registrarAmbulancia("SBA1238", 1);
        s.registrarAmbulancia("SBA1239", 1);
        s.registrarAmbulancia("SBA1210", 1);
        s.registrarAmbulancia("SBA1211", 1);
        s.registrarAmbulancia("SBA1212", 2);
        s.registrarAmbulancia("SBA1213", 2);
        assertEquals(ISistema.TipoRet.OK, s.eliminarAmbulancia("SBA1234"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testEliminarVariasAmbulanciasValidasConVariasAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 1);
        s.registrarAmbulancia("SBA1235", 1);
        s.registrarAmbulancia("SBA1236", 1);
        s.registrarAmbulancia("SBA1237", 1);
        s.registrarAmbulancia("SBA1238", 1);
        s.registrarAmbulancia("SBA1239", 1);
        s.registrarAmbulancia("SBA1210", 1);
        s.registrarAmbulancia("SBA1211", 1);
        s.registrarAmbulancia("SBA1212", 2);
        s.registrarAmbulancia("SBA1213", 2);
        assertEquals(ISistema.TipoRet.OK, s.eliminarAmbulancia("SBA1235"));
        assertEquals(ISistema.TipoRet.OK, s.eliminarAmbulancia("SBA1236"));
        assertEquals(ISistema.TipoRet.OK, s.eliminarAmbulancia("SBA1237"));
        assertEquals(ISistema.TipoRet.OK, s.eliminarAmbulancia("SBA1238"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

}
