package Dominio;

import TAD.ListaChofer;
import TAD.NodoChofer;

public class Ambulancia {

    String idAmbulancia;
    boolean ocupada; //true = en viaje, false= libre
    boolean habilitada; //true = habilitada, false = deshabilitada
    int idCiudadActual;
    int cantEmergencias;
    ListaChofer choferes = new ListaChofer();

    //Controlar si funciona
    public void setChoferes(NodoChofer chofer) {
        this.choferes.getHead().enlazarSiguiente(chofer);
    }

    public ListaChofer getChoferes() {
        return choferes;
    }

    public Ambulancia(String idAmbulancia, int idCiudadActual) {
        this.idAmbulancia = idAmbulancia;
        this.idCiudadActual = idCiudadActual;
        this.habilitada = true;
        this.ocupada = false;
        this.cantEmergencias = 0;
    }

    public String getIdAmbulancia() {
        return idAmbulancia;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public int getidCiudadActual() {
        return idCiudadActual;
    }

    public int getCantEmergencias() {
        return cantEmergencias;
    }

    public void setIdAmbulancia(String idAmbulancia) {
        this.idAmbulancia = idAmbulancia;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public void setidCiudadActual(int idCiudadActual) {
        this.idCiudadActual = idCiudadActual;
    }

    public void setCantEmergencias(int cantEmergencias) {
        this.cantEmergencias = cantEmergencias;
    }

    public String mostrarAbmbulancia() {

        return "Id: " + idAmbulancia + "-" + "Ocupada: " + ocupada + "-" + "Se encuentra en la cuidad: " + idCiudadActual+"\n";
    }
}
