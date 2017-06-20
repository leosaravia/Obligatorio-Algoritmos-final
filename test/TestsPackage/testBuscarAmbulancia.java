package TestsPackage;


import mainPackage.Isistema;
import org.junit.Assert;
import org.junit.Test;
import mainPackage.GestionAmbulancia;


public class testBuscarAmbulancia {
    
    @Test
    public void testBuscarAbmulanciaConId() {
        GestionAmbulancia g = new GestionAmbulancia();
        Assert.assertEquals(Isistema.TipoRet.OK,g.buscarAmbulancia("ABC123"));
    }
    /*@Test
    public void testBuscarUnaAbmulanciaNoExistente() {
        GestionAmbulancia g = new GestionAmbulancia();
        g.inicializador();
        Assert.assertEquals(Isistema.TipoRet.ERROR,g.buscarAmbulancia("abr485"));
    }*/
}
