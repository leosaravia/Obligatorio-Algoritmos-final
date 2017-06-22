package mainPackage;

import Dominio.Ambulancia;
import Dominio.Chofer;
import Dominio.Ciudad;
import TAD.ListaAmbulancia;
import TAD.ListaChofer;
import TAD.ListaCiudad;

public class SistemaAmbulancia implements ISistema {

    ListaAmbulancia listaAmbulancias;
    ListaChofer listaChofer;
    ListaCiudad listaCiudad;
    int[][] mapa;

    

    //Pre: ambulanciaID !=null y habilitada =true
    //Post: Elimina ambulanciaID y dependencias del sistema 
    @Override
    public TipoRet eliminarAmbulancia(String ambulanciaID) {
        boolean retorno = false;
        if (listaAmbulancias.existeAmbulancia(ambulanciaID)) {
            Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaID);
            if (a.isOcupada()) {
                System.out.println("No es posible eliminar la ambulancia " + ambulanciaID
                        + " porque está asignada a un viaje.");
            } else {
                listaAmbulancias.eliminar(ambulanciaID);
                a = null;
                System.out.println("Ambulancia eliminada correctamente");
                retorno = true;
            }
        } else {
            System.out.println("La ambulancia no existe");
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: cantidadCiudades > 0
    //Post: Retorna OK. Crea e sistema de emergencias 
    @Override
    public TipoRet crearSistemaDeEmergencias(int cantidadCiudades) {

        //Inicializa el mapa en -1
        if (cantidadCiudades > 0) {
            listaAmbulancias = new ListaAmbulancia();
            listaChofer = new ListaChofer();
            listaCiudad = new ListaCiudad();
            mapa = new int[cantidadCiudades + 1][cantidadCiudades + 1];
            listaCiudad.setSize(cantidadCiudades);
            for (int i = 1; i <= cantidadCiudades; i++) {
                for (int j = 1; j <= cantidadCiudades; j++) {
                    mapa[i][j] = -1;
                }
            }
            System.out.println("El sistema de emergencias pudo ser creado exitosamente");
            return TipoRet.OK;
        } else {
            System.out.println("La cantidad de ciudades es inferior a 1");
            return TipoRet.ERROR;
        }

    }

    //Pre: Sistema de emergencias debe estar creado
    //Post: retorna OK si se pudo destruir sistema 
    @Override
    public TipoRet destruirSistemaEmergencias() {
        listaAmbulancias.setHead(null);
        listaChofer.setHead(null);
        listaCiudad.setHead(null);
        mapa = null;
        System.out.println("El sistema de emergencias fue destruido exitosamente");
        return TipoRet.OK;
    }

    //Pre: ciudadID >0 y ambulanciaId no debe existir en sitema
    //Post: Crea ambulancia con ambulanciaId asignada a ciudadID 
    @Override
    public TipoRet registrarAmbulancia(String ambulanciaId, int ciudadID) {
        boolean retorno = false;
        Ciudad c = listaCiudad.getCiudad(ciudadID);
        if (c == null) {
            System.out.println("La ciudad" + "    " + ciudadID + "    " + "no existe");
        } else {
            if (c.getListaAmbulancias().existeAmbulancia(ambulanciaId)) {
                System.out.println("Ya existe una ambulancia con identificador ambulanciaID" + ambulanciaId);
            } else {
                Ambulancia a = new Ambulancia(ambulanciaId, ciudadID);
                listaAmbulancias.agregarInicio(a);
                c.setListaAmbulancias(a);
                retorno = true;
                System.out.println("Ambulancia " + ambulanciaId + " pudo ser creada exitosamente");
            }
        }
        if (retorno == true) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: ambulanciaId !=null , ambulanciaId debe estar disponible y sin viajes asignados
    //Post: retorna OK , ambulanciaId habilitada=false 
    @Override
    public TipoRet deshabilitarAmbulancia(String ambulanciaId) {
        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaId);
        boolean retorno = false;

        if (a == null) {
            System.out.println("No existe la ambulancia");
        } else if (!a.isHabilitada()) {
            System.out.println("La ambulancia " + ambulanciaId + " ya está en estado no disponible");
        } else {
            a.setHabilitada(false);
            System.out.println("Estado modificado satisfactoriamente");
            retorno = true;
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: ambulanciaID !=null ambulanciaID habilitada=false.
    //Post: retorna OK.Habilita una ambulancia que esté deshabilitada 
    @Override
    public TipoRet habilitarAmbulancia(String ambulanciaID) {
        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaID);
        boolean retorno = false;

        if (a == null) {
            System.out.println("No existe la ambulancia");
        } else if (a.isHabilitada()) {
            System.out.println("“La ambulancia " + ambulanciaID + " ya está en estado habilitado");
        } else {
            a.setHabilitada(true);
            System.out.println("Estado modificado satisfactoriamente");
            retorno = true;
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: ambulanciaID !=null.
    //Post: retorna OK e imprime datos de ambulacia 
    @Override
    public TipoRet buscarAmbulancia(String ambulanciaID) {
        boolean retorno = false;

        Ambulancia aux = listaAmbulancias.getAmbulancia(ambulanciaID);
        if (aux != null) {
            System.out.println("Datos de ambulancia: " + aux.getIdAmbulancia());
            System.out.println("Habilitada: " + aux.isHabilitada());
            System.out.println("Ciudad Actual: " + aux.getidCiudadActual());
            System.out.print("Cantidad de emergencias: " + aux.getCantEmergencias());
            retorno = true;
        }
        if (retorno == true) {
            return TipoRet.OK;
        } else {
            System.out.println("No existe una ambulancia con identificador " + ambulanciaID);
            return TipoRet.ERROR;
        }
    }
    //Pre: debe existir por lo menos 1 ambulancia en el sistema.
    //Post: retorna OK, lista detalles de ambulancias 
    @Override
    public TipoRet informeAmbulancia() {

        if (listaAmbulancias.getHead() != null) {
            listaAmbulancias.listar();
            return TipoRet.OK;
        } else {
            System.out.println("Lista vacía de ambulancias");
            return TipoRet.OK;
        }
    }
    //Pre: ciudadID != null
    //Post: retorna OK, imprime detalles de ambulancias por ciudad 
    @Override
    public TipoRet informeAmbulancia(int ciudadID) {

        Ciudad c = listaCiudad.getCiudad(ciudadID);
        if (c != null) {
            c.getListaAmbulancias().listar();
            return TipoRet.OK;
        } else {
            System.out.println("La ciudad " + ciudadID + " no existe");
            return TipoRet.ERROR;
        }
    }

    //Pre: ciudadID != null, ambulanciaID!=null
    //Post: retorna OK y modifica Ciudad 
    @Override
    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID) {
        boolean retorno = false;

        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaID);
        if (a == null) {
            System.out.println("La ambulancia " + ambulanciaID + " no existe");
        } else {
            Ciudad cNueva = listaCiudad.getCiudad(ciudadID);
            if (cNueva == null) {
                System.out.println("La ciudad " + ciudadID + " no existe");
            } else {
                //Guardo el IDCiudad anterior para quitar de la lista de esa ciudad la ambulancia
                //y luego la agrego a la lista de la nueva ciudad
                Ciudad cAnterior = listaCiudad.getCiudad(a.getidCiudadActual());
                cAnterior.getListaAmbulancias().eliminar(ambulanciaID);
                cNueva.setListaAmbulancias(a);
                a.setidCiudadActual(ciudadID);
                System.out.println("Ciudad modificada correctamente");
                retorno = true;
            }
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: cantidad de ciudades < a cantidad establecida en CrearSistema.
    //Post: agrega una ciudad con ciudadNombre al sistema. 
    @Override
    public TipoRet agregarCiudad(String ciudadNombre) {
        boolean retorno = false;
        if (listaCiudad.getSize() >= 100) {
            System.out.println("No se pueden ingresar la ciudad " + ciudadNombre + " al sistema por no tener más capacidad.");
        } else {
            Ciudad ciudad = new Ciudad(ciudadNombre);
            listaCiudad.agregarInicio(ciudad);
            retorno = true;
        }
        if (retorno == true) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: debe existir por lo menos 1 Ciudad.
    //Post: retorna OK , imprime lista de ciudades. 
    @Override
    public TipoRet listarCiudades() {
        if (listaCiudad.getSize() > 0) {
            listaCiudad.listar();
            return TipoRet.OK;
        } else {
            System.out.println("Lista vacía de Ciudades");
            return TipoRet.OK;
        }
    }

    //Pre: ciudadOrigen !=null , ciudadDestino !=null, minutosViaje >0.
    //Post: retorna OK , agrega ruta al sistema. 
    @Override
    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        Ciudad c1 = listaCiudad.getCiudad(ciudadOrigen);
        Ciudad c2 = listaCiudad.getCiudad(ciudadDestino);
        boolean retorno = false;

        if (c1 == null) {
            System.out.println("La ciudad origen no existe");
        } else {
            if (c2 == null) {
                System.out.println("La ciudad destino no existe");
            } else {
                if (minutosViaje <= 0) {
                    System.out.println("La duración del viaje debe ser mayor a 0.");
                } else {
                    System.out.println("Ruta agregada correctamente");
                    mapa[ciudadOrigen][ciudadDestino] = minutosViaje;
                    mapa[ciudadDestino][ciudadOrigen] = minutosViaje;
                    retorno = true;
                }
            }
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: ciudadOrigen!=null ,ciudadDestino !=null, minutosViaje>0.
    //Post: modifica demora en la coordenada de ciudad origen y ciudad destino. 
    @Override
    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        Ciudad c1 = listaCiudad.getCiudad(ciudadOrigen);
        Ciudad c2 = listaCiudad.getCiudad(ciudadDestino);
        boolean retorno = false;

        if (c1 == null) {
            System.out.println("La ciudad origen no existe");
        } else {
            if (c2 == null) {
                System.out.println("La ciudad destino no existe");
            } else {
                if (minutosViaje <= 0) {
                    System.out.println("La duración del viaje debe ser mayor a 0.");
                } else if (mapa[ciudadOrigen][ciudadDestino] == -1) {
                    System.out.println("La ruta no ha sido ingresada, ");
                } else {
                    System.out.println("Ruta modificada correctamente");
                    mapa[ciudadOrigen][ciudadDestino] = minutosViaje;
                    mapa[ciudadDestino][ciudadOrigen] = minutosViaje;
                    retorno = true;
                }
            }
        }
        if (retorno) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: ciudadID != null.
    //Post: retorna OK + informe de la ambulancia más cercana. 
    @Override
    public TipoRet ambulanciaMasCercana(int ciudadID) {

        Ciudad c = listaCiudad.getCiudad(ciudadID);
        if (c == null) {
            System.out.println("La ciudad " + ciudadID + " no existe");
            return TipoRet.ERROR;
        } else {
            if (c.getListaAmbulancias() != null) {
                System.out.println("Ambulancia más cercana a " + c.getCodigo() + " - " + c.getNombre() + "\n");
                System.out.println("Ambulancia: " + c.getListaAmbulancias().getHead().ObtenerValor().getIdAmbulancia() + "\n");
                System.out.println("Demora de viaje: 0");
            } else if (mapa != null) {
                int cont = 1;
                boolean flag = false;
                while (mapa[ciudadID][cont] < mapa[ciudadID].length) {
                    if (mapa[ciudadID][cont] != -1) {
                        Ciudad ciudadCercada = listaCiudad.getCiudad(cont);
                        if (ciudadCercada.getListaAmbulancias() != null) {
                            System.out.println("Ambulancia más cercana a " + c.getCodigo() + " - " + c.getNombre() + "\n");
                            System.out.println("Se encuentra en " + ciudadCercada.getCodigo() + " - " + ciudadCercada.getNombre() + "\n");
                            System.out.println("Ambulancia: " + ciudadCercada.getListaAmbulancias().getHead().ObtenerValor().getIdAmbulancia() + "\n");
                            System.out.println("Demora de viaje: " + mapa[ciudadID][cont]);
                            flag = true;
                        }
                    }
                    cont++;
                }
                if (!flag) {
                    System.out.println("No hay ambulancias disponibles");
                }
            }
            return TipoRet.OK;
        }
    }

    //Pre: ciudadOrigen !=null, ciudadDestino != null.
    //Post: retorna OK , muestra ruta más rápida para ir desde ciudadOrigen a ciudadDestino. 
    @Override
    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino) {

        boolean ret = false;
        int col = mapa[0].length;
        int rutaMasRapida;
        int ciudadIntermedia = 0;

        Ciudad origen = listaCiudad.getCiudad(ciudadOrigen);
        Ciudad destino = listaCiudad.getCiudad(ciudadDestino);

        if (origen == null) {
            System.out.println("La ciudad origen" + ciudadOrigen + " no existe. \n");
            if (destino == null) {
                System.out.println("La ciudad destino" + ciudadDestino + " no existe.");
            }
        } else if (destino == null) {
            System.out.println("La ciudad destino" + ciudadDestino + " no existe.");
        } else {
            ret = true;
            if (mapa[ciudadOrigen][ciudadDestino] > 0) {
                rutaMasRapida = mapa[ciudadOrigen][ciudadDestino];
            } else {
                rutaMasRapida = Integer.MAX_VALUE;
            }
            for (int i = 1; i < col; i++) {
                if (mapa[ciudadOrigen][i] > 0) {
                    for (int j = 0; j < mapa[i].length; j++) {
                        if (j == ciudadDestino) {
                            if (rutaMasRapida > (mapa[ciudadOrigen][i] + mapa[i][j])) {
                                rutaMasRapida = mapa[ciudadOrigen][i] + mapa[i][j];
                                ciudadIntermedia = i;
                            }
                        }
                    }
                }
            }
            if (ciudadIntermedia > 0) {
                Ciudad intermedia = listaCiudad.getCiudad(ciudadIntermedia);
                System.out.println("Ruta más rápida: \n");
                System.out.println("Ciudad origen: " + origen.getNombre() + " - 0 \n");
                System.out.println("Ciudad intermedia: " + intermedia.getNombre() + " - " + mapa[ciudadOrigen][ciudadIntermedia] + "\n");
                System.out.println("Ciudad destino: " + destino.getNombre() + " - " + mapa[ciudadOrigen][ciudadDestino] + "\n\n");
                System.out.println("Demora total de ambulancias: " + rutaMasRapida);
            } else if (ciudadIntermedia == 0) {
                System.out.println("Ruta más rápida: \n");
                System.out.println("Ciudad origen: " + origen.getNombre() + " - 0 \n");
                System.out.println("Ciudad destino: " + destino.getNombre() + " - " + mapa[ciudadOrigen][ciudadDestino] + "\n\n");
                System.out.println("Demora total de ambulancias: " + rutaMasRapida);
            } else {
                System.out.println("No hay ruta desde " + ciudadOrigen + " a " + ciudadDestino);
            }
        }
        if (ret) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: debe existir por lo menos 1 ciudad
    //Post: retorna OK, imprime listado de ciudades 
    @Override
    public TipoRet informeCiudades() {
        int fila = mapa.length;
        int col = mapa[0].length;

        for (int i = 0; i < fila; i++) {
            System.out.println("Informe de ciudad " + i + "\n");
            for (int j = 0; j < col; j++) {
                if (mapa[i][j] > 0) {
                    Ciudad c = listaCiudad.getCiudad(i);
                    System.out.println("\t Ruta directa con " + j + " - Minutos de viaje: " + mapa[i][j]
                            + "\n\t Ambulancias disponibles: " + c.getListaAmbulancias().ambulanciasDisponibles()
                            + "\n\t Ambulancias no disponibles: " + c.getListaAmbulancias().ambulanciasNoDisponibles() + "\n");
                }
            }
        }
        return TipoRet.OK;
    }

    //Pre: ciudadID !=null , duracionViaje >0
    //Post: retorna OK, Imprime por pantalla todas las ciudades en un radio 
    @Override
    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje) {
        boolean ret = false;
        int col = mapa[0].length;

        if (duracionViaje <= 0) {
            System.out.println("La duración del viaje debe ser mayor a 0");
        } else if (!listaCiudad.existeCiudad(ciudadID)) {
            System.out.println("La ciudad " + ciudadID + " no existe.");
        } else {
            ret = true;
            for (int i = 1; i < col; i++) {
                if (mapa[ciudadID][i] <= duracionViaje && mapa[ciudadID][i] > 0) {
                    System.out.println("Ciudad: " + listaCiudad.getCiudad(i).getNombre() + " - Duración: " + mapa[ciudadID][i] + "\n");
                    for (int j = 1; j < mapa[i].length; j++) {
                        if ((mapa[i][j] + mapa[ciudadID][i]) < duracionViaje && mapa[i][j] > 0 && j != ciudadID) {
                            System.out.println("Ciudad: " + listaCiudad.getCiudad(j).getNombre() + " - Duración: " + mapa[i][j] + "\n");
                        }
                    }
                }
            }
        }
        if (ret) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }
    }

    //Pre: ambulanciaID !=null.
    //Post: retorna OK , crea un nuevo Chofer. 
    @Override
    public TipoRet registrarChofer(String ambulanciaID, String nombre,
            String cedula
    ) {
        boolean retorno = false;
        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaID);
        if (a != null) {
            Chofer chofer = new Chofer(nombre, cedula, ambulanciaID);
            a.getChoferes().agregarInicio(chofer);
            listaChofer.agregarInicio(chofer);
            retorno = true;
            System.out.println("Chofer agregado correctamente");
        } else {
            System.out.println("La ambulancia con id " + ambulanciaID + " no existe");
        }
        if (retorno == true) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }

    }

    //Pre: ambulanciaID !=null.
    //Post: retorna OK , elimina chofer del sistema 
    @Override
    public TipoRet eliminarChofer(String ambulanciaID, String cedula
    ) {

        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaID);
        boolean flag = false;

        if (a != null) {
            Chofer c = a.getChoferes().getChofer(cedula);
            c = null;
            flag = true;
        }
        if (flag) {
            System.out.println("Chofer eliminado correctamente");
            return TipoRet.OK;
        } else {
            System.out.println("La ambulancia id " + ambulanciaID + " no existe");
            return TipoRet.ERROR;
        }
    }

    //Pre: debe existir por lo menos un Chofer.
    //Post: retorna OK , lista informacion del Chofer. 
    @Override
    public TipoRet informeChoferes(String ambulanciaID
    ) {
        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaID);
        if (a != null) {
            a.getChoferes().listar();
        } else {
            System.out.println("La ambulancia con id " + ambulanciaID + " no exise");
            return TipoRet.ERROR;
        }
        return TipoRet.OK;
    }

}
