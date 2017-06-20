/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Dominio.Ambulancia;

/**
 *
 * @author Usuario
 */
public class NodoAmbulancia {

    Ambulancia valor; 
    NodoAmbulancia siguiente;

    public void setValor(Ambulancia valor) {
        this.valor = valor;
    }

    public NodoAmbulancia(Ambulancia valor) {
        this.valor = valor;
        this.siguiente = null; // siguiente lo inicializo en null porque puede ser el ultimo elemente de la lista.
    }

    //Retorna valor
    public Ambulancia ObtenerValor() {
        return valor;
    }

    //Enlaza con el siguiente nodo de la Lista
    public void enlazarSiguiente(NodoAmbulancia n) {
        siguiente = n;
    }

    //Retorna valor del siguiente Nodo
    public NodoAmbulancia obtenerSiguiente() {
        return siguiente;
    }

}
