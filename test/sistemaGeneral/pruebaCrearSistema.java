
package sistemaGeneral;

import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;
import org.junit.Test;
import static org.junit.Assert.*;

public class pruebaCrearSistema {
    
    public pruebaCrearSistema() {
    }

    @Test
    public void testCrearSistemaConCeroCiudades() {
        ISistema s = new SistemaAmbulancia();
        assertEquals(ISistema.TipoRet.ERROR,s.crearSistemaDeEmergencias(0));
    }
    @Test
    public void testCrearSistemaConNumeroNegativoCiudades() {
        ISistema s = new SistemaAmbulancia();
        assertEquals(ISistema.TipoRet.ERROR,s.crearSistemaDeEmergencias(-100));
    }
    
    @Test
    public void testCrearSistemaConUnoCiudades() {
        ISistema s = new SistemaAmbulancia();
        assertEquals(ISistema.TipoRet.OK,s.crearSistemaDeEmergencias(1));
    }
    
    @Test
    public void testCrearSistemaConMayorAUnoCiudades() {
        ISistema s = new SistemaAmbulancia();
        assertEquals(ISistema.TipoRet.OK,s.crearSistemaDeEmergencias(1000));
    }
    

}
