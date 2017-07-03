package TestsPackage;

import org.junit.Assert;
import org.junit.Test;
import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;


public class testCrearAmbulancia {
    
//    @Test
//    public void testCrearUnaAmbulancia(){
//        GestionAmbulancia g = new GestionAmbulancia();
//        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("ABC123", 1));
//    }
    
    @Test
    public void testCrearTresAmbulancia(){
        SistemaAmbulancia g = new SistemaAmbulancia();
        g.crearSistemaDeEmergencias(10);
        g.agregarCiudad("Montevideo");
        g.agregarCiudad("Maldonado");
        g.agregarCiudad("Lavalleja");
        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("ABC123", 1));
        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("ABC897", 2));
        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("ABC456", 3));
    }
    
    @Test
    public void testCrearCincoAmbulancia(){
        SistemaAmbulancia g = new SistemaAmbulancia();
        g.crearSistemaDeEmergencias(10);
        g.agregarCiudad("Montevideo");
        g.agregarCiudad("Maldonado");
        g.agregarCiudad("Lavalleja");
        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("ABC123", 1));
        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("ABC897", 2));
        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("ABC456", 3));
        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("FBC456", 3));
        Assert.assertEquals(ISistema.TipoRet.OK, g.registrarAmbulancia("ZBC456", 3));
    }
    
}
