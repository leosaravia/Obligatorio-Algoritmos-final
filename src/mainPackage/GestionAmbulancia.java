package mainPackage;

import Dominio.Ambulancia;
import Dominio.Ciudad;
import TAD.ListaAmbulancia;
import TAD.ListaChofer;
import TAD.ListaCiudad;

public class GestionAmbulancia implements Isistema {

    ListaAmbulancia ambulancias = new ListaAmbulancia();
    ListaChofer choferes = new ListaChofer();
    ListaCiudad ciudades = new ListaCiudad();

    @Override
    public TipoRet eliminarAmbulancia(String ambulanciaID) {
        boolean retorno = false;
        boolean flag = false;
        int cont = 0;

        while (ambulancias.getSize() > cont && !flag) {

            if (ambulancias.getAmbulancia(ambulanciaID) != null) {
                if (ambulancias.getHead().ObtenerValor().isOcupada()) {
                    System.out.println("No es posible eliminar la ambulancia " + ambulanciaID
                            + "porque está asignada a un viaje.");
                } else {
                    ambulancias.setHead(null);
                    ambulancias.setHead(ambulancias.getHead().obtenerSiguiente());
                    System.out.println("Ambulancia eliminada correctamente");
                    retorno = true;
                }
            } else {
                ambulancias.setHead(ambulancias.getHead().obtenerSiguiente());
            }
            cont++;
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            System.out.println("La ambulancia no existe.");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet crearSistemaDeEmergencias(int cantidadCiudades) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet destruirSistemaEmergencias() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    //PRE: los datos pasados por parámetro no pueden estar vacíos y deben existir. 
    @Override
    public TipoRet registrarAmbulancia(String ambulanciaId, int ciudadID) {
        boolean retorno = false;

        if (ambulancias.getSize() > 0) {
            if (ambulancias.getAmbulancia(ambulanciaId)!=null) {
                System.out.println("La ambulancia ya existe");
            } else {
                Ambulancia a = new Ambulancia(ambulanciaId, ciudadID);
                ambulancias.agregarInicio(a);
                retorno = true;
            }
        } else {
            Ambulancia a = new Ambulancia(ambulanciaId, ciudadID);
            ambulancias.agregarInicio(a);
            retorno = true;
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet deshabilitarAmbulancia(String ambulanciaId) {
        Ambulancia a = ambulancias.getAmbulancia(ambulanciaId);
        boolean retorno = false;

        if (a == null) {
            System.out.println("No existe la ambulancia");
        } else if (ambulancias.getAmbulancia(ambulanciaId).isOcupada()) {
            System.out.println("“La ambulancia " + ambulanciaId + " ya está en estado\n"
                    + "\n"
                    + "NO_DISPONIBLE.”");
        } else {
            ambulancias.getAmbulancia(ambulanciaId).setOcupada(true);
            System.out.println("Estado modificado satisfactoriamente");
            retorno = true;
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet habilitarAmbulancia(String ambulanciaID) {

        Ambulancia a = ambulancias.getAmbulancia(ambulanciaID);
        boolean retorno = false;

        if (a == null) {
            System.out.println("No existe la ambulancia");
        } else if (!ambulancias.getAmbulancia(ambulanciaID).isOcupada()) {
            System.out.println("“La ambulancia " + ambulanciaID + " ya está en estado\n"
                    + "\n"
                    + "DISPONIBLE.”");
        } else {
            ambulancias.getAmbulancia(ambulanciaID).setOcupada(false);
            System.out.println("Estado modificado satisfactoriamente");
            retorno = true;
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    /*Un buscar estándar, recorre con while con flag en false hasta que la encuentra y cambia flag a true para salir y 
    retornar el ENUM. Caso contrario retorna mensaje apropiado y ERROR en ENUM*/
    @Override
    public TipoRet buscarAmbulancia(String ambulanciaID) {
        int cont = 0;
        boolean flag = false;
        if (ambulancias.getSize() > 0) {
            int largo = ambulancias.getSize();

            while (cont < largo && !flag) {
                if (ambulancias.getAmbulancia(ambulanciaID) != null) {
                    if (ambulancias.getAmbulancia(ambulanciaID).getIdAmbulancia().equals(ambulanciaID)) {
                        flag = true;
                    }
                }
                cont++;
            }
        } else {
            System.out.println("Lista de ambulancias vacía");
        }

        if (flag) {
            return TipoRet.OK;
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID.");
            return TipoRet.ERROR;
        }
    }

    /*Desplegaŕa en pantalla todas las ambulancias y sus atributos utilizando el método mostrar de la clase
    Ambulancia. Caso contrario indica que la lista esa vacía. */
    @Override
    public TipoRet informeAmbulancia() {

        int largo = ambulancias.getSize();
        if (largo > 0) {
            ambulancias.listar();
            return TipoRet.OK;
        } else {
            System.out.println("Lista vacía de ambulancias");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet informeAmbulancia(int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    /*busca el indice de la ambulancia y el objeto ciudad con los métodos buscarIndiceAmbulancia()
    y buscarCiudad, el indice es >0 y el objeto ciudad no es null, cambia el atributo CiudadActual de la clase
    ambulancia a la nueva cuidad pasada por parámetro, envía mnsj y retorna OK. caso contrario devuelve mensaje apropiado
    y retorna ERROR. */
    @Override
    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID) {
        boolean retorno = false;
        Ambulancia amb = ambulancias.getAmbulancia(ambulanciaID);
        Ciudad nuevaCiudad = ciudades.getCiudad(ciudadID);

        if (nuevaCiudad != null && amb != null) {
            ambulancias.getAmbulancia(ambulanciaID).setidCiudadActual(ciudadID);
            System.out.println("Ciudad modificada correctamente");
            retorno = true;
        } else {
            System.out.println("No fue posible cambiar la ciudad");
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //PRE: Dos ciudades no pueeden tener el mismo nombre 
    @Override
    public TipoRet agregarCiudad(String ciudadNombre) {
        boolean retorno = false;

        if (ciudadNombre.isEmpty()) {
            System.out.println("Debe completar los datos");
        } else if (ciudades.getCiudadNombre(ciudadNombre) != null) {
            System.out.println("La ciudad ya existe");
        } else {
            Ciudad c = new Ciudad(ciudadNombre );
            ciudades.agregarFinal(c);
            retorno = true;
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet listarCiudades() {

        int largo = ciudades.getSize();
        if (largo > 0) {
            ciudades.listar();
            return TipoRet.OK;
        } else {
            System.out.println("Lista vacía de Ciudades");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet ambulanciaMasCercana(int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeCiudades() {

        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet registrarChofer(String ambulanciaID, String nombre, String cedula) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet eliminarChofer(String ambulanciaID, String cedula) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeChoferes(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;
    }
}
