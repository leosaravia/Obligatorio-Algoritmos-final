/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambulancias;

import mainPackage.ISistema;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import utils.FuncionalidadesComunes;



/**
 *
 * @author docenteFI
 */
public class pruebaInformeAmbulanciaPorCiudad {
    
    public pruebaInformeAmbulanciaPorCiudad() {
    }

    @Test
    public void testInformeAmbulanciaConCiudadNoExistente() {
        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutas();
        
        assertEquals(ISistema.TipoRet.ERROR,s.informeAmbulancia(10));
    }
    
    @Test
    public void testInformeAmbulanciaConCiudadExistenteQueSeaLaPrimerCiudadAgregada() {
        
        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutas();
        
        assertEquals(ISistema.TipoRet.ERROR,s.informeAmbulancia(1));
        
        
    }
    
    @Test
    public void testInformeAmbulanciaConCiudadExistenteQueSeaCualquierCiudadAgregada() {
        ISistema s = FuncionalidadesComunes.crearSistemaConXCiudadesUnaAmbulanciaPorCiudad(6);
        assertEquals(ISistema.TipoRet.OK,s.informeAmbulancia(5));
    }
}
