
package mapa;

import ambulancias.*;
import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;
import utils.FuncionalidadesComunes;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class pruebaModificarDemoraDeViaje {

    /**
     * Si ciudadOrigen no existe. Deberá imprimir en pantalla: “La ciudad
     * ciudadOrigen no existe.”
     *
     * Si ciudadDestino no existe. Deberá imprimir en pantalla: “La ciudad
     * ciudadDestino no existe.”
     *
     * Si minutosViaje es menor o igual a 0. Deberá imprimir en pantalla: “La
     * duración del viaje debe ser mayor que 0.”
     */
    @Test
    public void testModificarDemoraDeViajeConListaVaciaDeCiudades() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        assertEquals(ISistema.TipoRet.ERROR, s.modificarDemora(1, 2, 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testModificarDemoraDeViajeConListaConVariasCiudadesPeroUnaDeLaRutaNoExistente() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

       s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        
        assertEquals(ISistema.TipoRet.ERROR, s.modificarDemora(1, 5, 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    @Test
    public void testModificarDemoraDeViajeConListaConVariasCiudadesYLasDosCiudadesExistentesPeroMinutosEnCero() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

       s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        
        assertEquals(ISistema.TipoRet.ERROR, s.modificarDemora(1, 2, 0));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    @Test
    public void testModificarDemoraDeViajeConListaConVariasCiudadesYLasDosCiudadesExistentesPeroMinutosMenorQueCero() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

       s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        
        assertEquals(ISistema.TipoRet.ERROR, s.modificarDemora(1, 2, -1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testModificarDemoraDeViajeRutaConListaConVariasCiudadesYLasDosCiudadesExistentes() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

       s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        
        assertEquals(ISistema.TipoRet.OK, s.modificarDemora(1, 2, 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testModificarDemoraDeViajeVariasCiudadesVariasAmbulanciasVariasRutas() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
       
        ISistema s=FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        
        assertEquals(ISistema.TipoRet.OK, s.modificarDemora(1, 5, 100));
        assertEquals(ISistema.TipoRet.OK, s.modificarDemora(1, 4, 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

  

}
