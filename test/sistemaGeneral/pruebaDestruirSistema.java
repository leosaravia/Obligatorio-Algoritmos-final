
package sistemaGeneral;

import mainPackage.ISistema;
import mainPackage.SistemaAmbulancia;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.FuncionalidadesComunes;

public class pruebaDestruirSistema {
    
    public pruebaDestruirSistema() {
    }

  @Test
  public void testDestruirSistemaConSistemaVacio() {
        ISistema s = new SistemaAmbulancia();
        s.crearSistemaDeEmergencias(10);
        assertEquals(ISistema.TipoRet.OK,s.destruirSistemaEmergencias());
  }
  
  @Test
  public void testDestruirSistemaConSistemaConAmbulancias() {
        ISistema s= FuncionalidadesComunes.crearSistemaConXCiudadesUnaAmbulanciaPorCiudad(100);
        assertEquals(ISistema.TipoRet.OK,s.destruirSistemaEmergencias());
  }
  @Test
  public void testDestruirSistemaConSistemaConAmbulanciasYRutas() {
        ISistema s= FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        assertEquals(ISistema.TipoRet.OK,s.destruirSistemaEmergencias());
  }
  
  @Test
  public void testDestruirSistemaConSistemaConAmbulanciasChoferesYRutas() {
        ISistema s = new SistemaAmbulancia();
        s.crearSistemaDeEmergencias(10);
        assertEquals(ISistema.TipoRet.OK,s.destruirSistemaEmergencias());
  }
  
}
