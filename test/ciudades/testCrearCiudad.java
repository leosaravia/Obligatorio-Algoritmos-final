package ciudades;

import org.junit.Assert;
import org.junit.Test;
import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;
import static org.junit.Assert.assertEquals;
import utils.FuncionalidadesComunes;

public class testCrearCiudad {

    @Test
    public void testCrearUnaCiudad() {
        SistemaAmbulancia s = new SistemaAmbulancia();
        s.crearSistemaDeEmergencias(1);
        Assert.assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Montevideo"));
    }
    
    @Test
    public void testCiudadesEnRadio() {
       
        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutas();
        
        assertEquals(ISistema.TipoRet.OK,s.ciudadesEnRadio(1, 60));
    
    }
}
