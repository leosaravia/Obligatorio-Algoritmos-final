/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import Dominio.Chofer;

/**
 *
 * @author Usuario
 */
public class ListaChofer {

    NodoChofer head;
    int size;

    public NodoChofer getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void setHead(NodoChofer head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ListaChofer() {
        this.head = null;
        size = 0;
    }

    public void agregarInicio(Chofer chofer) {
        if (head == null) {
            head = new NodoChofer(chofer);
        } else {
            //creamos un nodo temporal para almacenar el head y luego lo enlazamos con el nuevo nodo que pasaria a ser el head actual
            NodoChofer temporal = head;
            NodoChofer nuevo = new NodoChofer(chofer);
            nuevo.enlazarSiguiente(temporal);
            head = nuevo;
        }
        size++;
    }

    public void borrarInicio() {
        head = head.obtenerSiguiente();
        size--;

    }

    public boolean esVacia() {
        return head == null;
    }

    public void vaciar() {
        while (head != null) {
            borrarInicio();
        }
    }

    public void agregarFinal(Chofer chofer) {
        // Define un nuevo nodo.
        NodoChofer nuevo = new NodoChofer(chofer);
        // Agrega al valor al nodo.
        nuevo.ObtenerValor();
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            head = nuevo;
            // Caso contrario recorre la lista hasta llegar al ultimo nodo
            //y agrega el nuevo.
        } else {
            // Crea ua copia de la lista.
            NodoChofer aux = head;
            // Recorre la lista hasta llegar al ultimo nodo.
            while (aux.obtenerSiguiente() != null) {
                aux = aux.obtenerSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.enlazarSiguiente(nuevo);
        }
        // Incrementa el contador de tamaño de la lista
        size++;
    }

    //PRE:Debe existir lista
    //POS: Elimina la lista
    public void eliminarLista() {
        // Elimina el valor y la referencia a los demas nodos.
        head = null;
        // Reinicia el contador de tamaño de la lista a 0.
        size = 0;
        System.out.println("Lista Chofer a sido destruida");
    }

    public void listar() {
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            NodoChofer aux = head;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while (aux != null) {
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.ObtenerValor().mostrarChofer() + " ]" + " ->  ");
                // Avanza al siguiente nodo.
                aux = aux.obtenerSiguiente();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }
    //PRE: 
    public boolean existenteChofer(String cedula){
 
        boolean existe=false;
        NodoChofer aux=head;
 
        while(aux!=null && !existe){
 
            if(aux.ObtenerValor().equals(cedula)){
                existe=true;
            }
             
            //Actualizamos
            aux=aux.obtenerSiguiente();
        }
 
        return existe;
    }
    public Chofer getChofer(String cedula) {

        NodoChofer aux = head;
        Chofer c = null;
        boolean flag = false;

        while (aux.obtenerSiguiente() != null && !flag) {
            if (aux.valor.getCedula().equals(cedula)) {
                flag = true;
                c = aux.valor;
            } else {
                aux = aux.obtenerSiguiente();
            }
        }
        return c;
    }
}
