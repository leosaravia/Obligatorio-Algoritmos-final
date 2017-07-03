package rutas;

import org.junit.Assert;
import org.junit.Test;
import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;
import static org.junit.Assert.assertEquals;
import utils.FuncionalidadesComunes;

public class testCiudadesEnRadio {

    @Test
    public void testCiudadesEnRadio() {
        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        assertEquals(ISistema.TipoRet.OK, s.ciudadesEnRadio(4, 130));
    }
    
    @Test
    public void testCiudadesEnRadioCiudadNoExiste() {
        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        assertEquals(ISistema.TipoRet.ERROR, s.ciudadesEnRadio(30, 130));
    }
    
    @Test
    public void testCiudadesEnRadioSinCiudadesEnRadio() {
        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        assertEquals(ISistema.TipoRet.OK, s.ciudadesEnRadio(4, 10));
    }
    
    @Test
    public void testCiudadesEnRadioDuracionViajeMenorAUno() {
        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        assertEquals(ISistema.TipoRet.ERROR, s.ciudadesEnRadio(4, 0));
    }

}
