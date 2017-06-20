package TAD;

import Dominio.Ciudad;

public class NodoCiudad {

    Ciudad valor;
    NodoCiudad siguiente;

    public Ciudad getValor() {
        return valor;
    }

    public NodoCiudad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCiudad siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCiudad(Ciudad valor) {

        this.valor = valor;
        this.siguiente = null;
    }

}
