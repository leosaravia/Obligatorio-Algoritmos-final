
package Dominio;

import TAD.NodoChofer;

public class Chofer {

    String nombre;
    String cedula;
    String idAmbulancia;

    public String getIdAmbulancia() {
        return idAmbulancia;
    }

    public void setIdAmbulancia(String idAmbulancia) {
        this.idAmbulancia = idAmbulancia;
    }

    public String getNombre() {
        return nombre;
    }

    /*public int getCedula() {
        return cedula;
    }*/
    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Chofer(String nombre, String cedula,String idAmbulancia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.idAmbulancia= idAmbulancia;
    }
    
    public String mostrarChofer(){
        return "Nombre: "+ nombre + "CI: "+ cedula;
    }
}
