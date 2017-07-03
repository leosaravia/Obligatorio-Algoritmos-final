package Dominio;

import TAD.ListaAmbulancia;

public class Ciudad {
    static int codigoAutoNum=0;
    int codigo;
    String nombre;
    ListaAmbulancia listaAmbulancias;
    
    public ListaAmbulancia getListaAmbulancias() {
        return listaAmbulancias;
    }

    public void setListaAmbulancias(Ambulancia ambulancias) {
        this.listaAmbulancias.agregarOrdenado(ambulancias);
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
        codigoAutoNum++;
        codigo = codigoAutoNum;
        this.nombre = nombre;
        listaAmbulancias = new ListaAmbulancia();
    }
    public String mostrarCiudades(){
        return "ID: "+codigo+"-"+"Nombre: "+nombre+ "\n";
    }

}
