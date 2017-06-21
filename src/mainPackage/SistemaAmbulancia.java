package mainPackage;

import Dominio.Ambulancia;
import Dominio.Chofer;
import Dominio.Ciudad;
import TAD.ListaAmbulancia;
import TAD.ListaChofer;
import TAD.ListaCiudad;

public class SistemaAmbulancia implements Isistema {

    ListaAmbulancia listaAmbulancias;
    ListaChofer listaChofer;
    ListaCiudad listaCiudad;
    int[][] mapa;

    //PRE: NA
    //POST: si la ambulancia no está ocupada y existe, la elimina
    @Override
    public TipoRet eliminarAmbulancia(String ambulanciaID) {
        boolean retorno = false;
        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaID);
        if (a != null) {
            if (a.getIdAmbulancia().equals(ambulanciaID)) {
                if (a.isOcupada()) {
                    System.out.println("No es posible eliminar la ambulancia " + ambulanciaID
                            + "porque está asignada a un viaje.");
                } else {
                    a = null;
                    System.out.println("Ambulancia eliminada correctamente");
                    retorno = true;
                }
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

    //PRE: Siempre se ingresan valores numéricos
    //POST: Inicializa las listas y setea la cantidad de ciudades
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

    //ver si el mapa se puede vaciar de esa forma
    //NA
    @Override
    public TipoRet destruirSistemaEmergencias() {
        listaAmbulancias.setHead(null);
        listaChofer.setHead(null);
        listaCiudad.setHead(null);
        mapa = null;
        System.out.println("El sistema de emergencias fue destruido exitosamente");
        return TipoRet.OK;
    }

    //PRE: Ingresa numero en idCiudad
    //POST: si la ciudad existe y la ambulancia aún  no, entonces da el alta de la misma. Si no,  devuelve mensaje de error
    /*NOTA: FALTA MODIFICAR LA FUNCIÓN PARA QUE INGRESE ORDENADAMENTE SEGÚN IDAMBULANCIA DE FORMA ASCENDENTE*/
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

    //PRE: NA
    //POST: Deshabilita una hambulancia que esté habilitada
    @Override
    public TipoRet deshabilitarAmbulancia(String ambulanciaId) {
        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaId);
        boolean retorno = false;

        if (a == null) {
            System.out.println("No existe la ambulancia");
        } else if (!a.isHabilitada()) {
            System.out.println("“La ambulancia " + ambulanciaId + " ya está en estado no disponible");
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

    //PRE:NA
    //POST: Habilita una ambulancia que esté deshabilitada
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

    //PRE:NA
    //POST: Si existe devuelve OK y mensaje apropiado, de lo contrario devuelve error
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

    //PRE: Se ingresa un int en ID ciudad
    //POST: Si la ciudad o la ambulancia no existe, devuelve error y el mensaje propicio, de lo contrario cambia
    //la ciudad.
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

    //PRE: el nombre de la cuidad no se puede repetir
    //POST: Agrega una ciudad
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

    //PRE: NA
    //POST: Devuelve la lista de cuidades
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

    //PRE: Se ingresan las dos ciudades o coordenadas y la duracion del viaje de una a otra. 
    //POST: agrega demora a la coordenada de ciudad origen y ciudad destino. 
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

    //PRE: El monto minutos de viaje debe ser un int
    //POST: Modifica demora en la coordenada de ciudad origen y ciudad destino. 
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

    /*Busca si la ciudad existe, si existe busca si tiene ambulancias, de no tener
    bsuca el mapa la ciudad más cercana y corrobora que dicha tenga ambulancias, si nada de 
    esto es true indica que no hay ambulancias disponibles.*/
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

    @Override
    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino) {

        boolean ret = false;
        int col = mapa[0].length;
        int rutaMasRapida;
        int ciudadIntermedia = 0;

        Ciudad origen = listaCiudad.getCiudad(ciudadOrigen);
        Ciudad destino = listaCiudad.getCiudad(ciudadDestino);

        if (origen == null) {
            System.out.println("La ciudad origen" + ciudadOrigen + " no existe.");
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
                System.out.println("Nombre de ciudad origen: " + origen.getNombre() + " - 0 \n");
                System.out.println("Nombre de ciudad destino: " + destino.getNombre() + " - " + mapa[ciudadOrigen][ciudadDestino] + "\n\n");
                System.out.println("Demora total de ambulancias: " + rutaMasRapida);
            } else {
                System.out.println("No hay ruta desde " + ciudadOrigen + " a " + ciudadDestino);
            }
        }
        return TipoRet.OK;
    }

    @Override
    public TipoRet informeCiudades() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    //PRE: Ingresamos un id de ciudad y una duración de viaje
    //POST: Imprime en pantalla todas las ciudades que tengan una duración de viaje menor a la ingresada. 
    //NOTA: Solo retorna error si la ciudad no existe o si la duración es <=0. 
    @Override
    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje
    ) {
        boolean ret = false;
        int col = mapa[0].length;

        if (duracionViaje <= 0) {
            System.out.println("La duración del viaje debe ser mayor a 0");
        } else if (!listaCiudad.existeCiudad(ciudadID)) {
            System.out.println("La ciudad " + ciudadID + " no existe.");
        } else {
            ret = true;
            //Imprime en pantalla que? el ID o el nombre? ver ya que sería mucho más eficiente que solo sea el ID
            for (int i = 1; i < col; i++) {
                if (mapa[ciudadID][i] <= duracionViaje && mapa[ciudadID][i] > 0) {
                    System.out.println("Ciudad: " + listaCiudad.getCiudad(mapa[ciudadID][i]).getNombre() + " - Duración: " + mapa[ciudadID][i] + "\n");
                    for (int j = 0; j < mapa[i].length; j++) {
                        if ((mapa[i][j] + mapa[ciudadID][i]) < duracionViaje) {
                            System.out.println("Ciudad: " + listaCiudad.getCiudad(mapa[i][j]).getNombre() + " - Duración: " + mapa[i][j] + "\n");
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

    /*PRE:  No existe un chofer de cédula cedula como chofer habilitado para conducir la ambulancia ambulanciaID. */
    @Override
    public TipoRet registrarChofer(String ambulanciaID, String nombre,
            String cedula
    ) {
        boolean retorno = false;
        Ambulancia a = listaAmbulancias.getAmbulancia(ambulanciaID);
        if (a != null) {
            Chofer chofer = new Chofer(nombre, cedula, ambulanciaID);
            a.getChoferes().agregarFinal(chofer);
            listaChofer.agregarFinal(chofer);
            retorno = true;
            System.out.println("Chofer agregado correctamente");
        } else {
            System.out.println("La ambulancia con id " + ambulanciaID + " no existe");
        }
        if (retorno
                == true) {
            return TipoRet.OK;
        } else {
            return TipoRet.ERROR;
        }

    }

    //PRE: Si la ambulancia existe, el chofer a eliminar debe manejar esa ambulancia
    //POST: Elimina un chofer de la lista de choferes habilitados para manejar una ambulancia dada
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
