package TestsPackage;

import mainPackage.GestionAmbulancia;
import mainPackage.Isistema;
import org.junit.Assert;
import org.junit.Test;


public class testCrearAmbulancia {
    
    @Test
    public void testCrearUnaAmbulancia(){
        GestionAmbulancia g = new GestionAmbulancia();
        Assert.assertEquals(Isistema.TipoRet.OK, g.registrarAmbulancia("ABC123", 1));
    }
    
    @Test
    public void testCrearTresAmbulancia(){
        GestionAmbulancia g = new GestionAmbulancia();
        Assert.assertEquals(Isistema.TipoRet.OK, g.registrarAmbulancia("ABC123", 1));
        Assert.assertEquals(Isistema.TipoRet.OK, g.registrarAmbulancia("ABC456", 2));
        Assert.assertEquals(Isistema.TipoRet.OK, g.registrarAmbulancia("ABC897", 3));
    }
    
    @Test
    public void testCrearAmbulanciaError(){
        GestionAmbulancia g = new GestionAmbulancia();
        g.registrarAmbulancia("ABC123", 1);//Ingreso una ambulancia que ya existe
        Assert.assertEquals(Isistema.TipoRet.OK, g.registrarAmbulancia("ABC123", 1));
    }
    
    //Agegar cuando no existe la cuidad. 
}
