package TestsPackage;


import org.junit.Assert;
import org.junit.Test;
import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;


public class testBuscarAmbulancia {
    
    @Test
    public void testBuscarAbmulanciaConIdCorrecto() {
        SistemaAmbulancia g = new SistemaAmbulancia();
        g.crearSistemaDeEmergencias(10);
        g.agregarCiudad("Lavalleja");
        g.registrarAmbulancia("ABC123", 1);
        Assert.assertEquals(ISistema.TipoRet.OK,g.buscarAmbulancia("ABC123"));
    }
     @Test
    public void testBuscarAbmulanciaConIdErrone() {
        SistemaAmbulancia g = new SistemaAmbulancia();
        g.crearSistemaDeEmergencias(10);
        g.agregarCiudad("Lavalleja");
        g.registrarAmbulancia("ABC123", 1);
        Assert.assertEquals(ISistema.TipoRet.ERROR,g.buscarAmbulancia("ABC124"));
    }
    
    
}
