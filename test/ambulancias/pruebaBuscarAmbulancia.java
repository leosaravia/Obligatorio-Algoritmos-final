/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambulancias;


import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;
import utils.FuncionalidadesComunes;
import static org.junit.Assert.assertEquals;
import org.junit.Test;



/**
 *
 * @author docenteFI
 */
public class pruebaBuscarAmbulancia {
    
    public pruebaBuscarAmbulancia() {
    }

    @Test
    public void testBuscarAmbulanciaConAmbulanciaIdExistente() {
       
        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutas();
        
        assertEquals(ISistema.TipoRet.OK,s.buscarAmbulancia("SBT6101"));
    
    }
    
    @Test
    public void testBuscarAmbulanciaConAmbulanciaIdNOExistente() {
    
    
    }
    
    @Test
    public void testBuscarUltimaAmbulanciaAgregada() {
    
    
    }
    
    
    @Test
    public void testBuscarPrimeraAmbulanciaAgregada() {
    
    
    }
    
    @Test
    public void testBuscarAmbulanciaConUnaSolaAmbulanciaEnLaLista() {
        ISistema s = new SistemaAmbulancia();
        
        s.crearSistemaDeEmergencias(5);
        
        for (int i = 0; i < 5; i++) {
            s.agregarCiudad("Ciudad"+i);
        }
        
        s.registrarAmbulancia("SBT6100", 0);
        
        assertEquals(ISistema.TipoRet.OK,s.buscarAmbulancia("SBT6101"));
    
    }
    
    @Test
    public void testBuscarAmbulanciaConLaListaVacia() {
        ISistema s = new SistemaAmbulancia();
        
        s.crearSistemaDeEmergencias(5);
        
        for (int i = 0; i < 5; i++) {
            s.agregarCiudad("Ciudad"+i);
        }
        
        assertEquals(ISistema.TipoRet.ERROR,s.buscarAmbulancia("SBT6101"));
    
    
    }
}
