package Dominio;

import TAD.ListaAmbulancia;

public class Ciudad {

    int codigo=0;
    String nombre;
    ListaAmbulancia listaAmbulancias;
    
    public ListaAmbulancia getListaAmbulancias() {
        return listaAmbulancias;
    }

    public void setListaAmbulancias(Ambulancia ambulancias) {
        this.listaAmbulancias.agregarInicio(ambulancias);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad(String nombre) {
        //codigoAutoNum++;
        codigo++;
        this.nombre = nombre;
    }
    public String mostrarCiudades(){
        return "ID: "+codigo+"-"+"Nombre: "+nombre+ "\n";
    }

}
