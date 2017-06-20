package TestsPackage;

import mainPackage.GestionAmbulancia;
import mainPackage.Isistema;
import org.junit.Assert;
import org.junit.Test;

public class testCrearCiudad {

    @Test
    public void testCrearCiudad() {
        GestionAmbulancia g = new GestionAmbulancia();
        Assert.assertEquals(Isistema.TipoRet.OK, g.agregarCiudad("Montevideo"));
    }

    @Test
    public void testCrearCiudadError() {
        GestionAmbulancia g = new GestionAmbulancia();
        g.agregarCiudad("Montevideo");
        Assert.assertEquals(Isistema.TipoRet.ERROR, g.agregarCiudad("Montevideo"));
    }

    @Test
    public void testCrearCiudades() {
        GestionAmbulancia g = new GestionAmbulancia();
        Assert.assertEquals(Isistema.TipoRet.OK, g.agregarCiudad("Montevideo"));
        Assert.assertEquals(Isistema.TipoRet.OK, g.agregarCiudad("Maldonado"));
        Assert.assertEquals(Isistema.TipoRet.OK, g.agregarCiudad("Canelones"));
    }

}
