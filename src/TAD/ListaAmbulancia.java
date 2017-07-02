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
public class ListaAmbulancia {

    NodoAmbulancia head;
    int size;//creo esta variable para controlar el tamaño de mi lista , cada vez que agrego un elemento aumento el tamaño

    public void setHead(NodoAmbulancia head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodoAmbulancia getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    //al momento de crear la lista el head es null , ya que la Lista es null
    public ListaAmbulancia() {
        head = null;
        size = 0;
    }

    //Agrega un elemento al head(primero elemento de la lista)
    public void agregarInicio(Ambulancia ambulancia) {
        if (head == null) {
            head = new NodoAmbulancia(ambulancia);
        } else {
            boolean flag = false;
            //creamos un nodo temporal para almacenar el head y luego lo enlazamos con el nuevo nodo que pasaria a ser el head actual
            NodoAmbulancia aux = head;
            NodoAmbulancia nuevo = new NodoAmbulancia(ambulancia);
            NodoAmbulancia anterior = aux;
            boolean inter = false;
            while (aux != null && !flag) {
                int esMayor = aux.ObtenerValor().getIdAmbulancia().compareTo(ambulancia.getIdAmbulancia());
                if (esMayor >= 0) {
                    head = nuevo;
                    nuevo.enlazarSiguiente(aux);
                    if (inter) {
                        anterior.enlazarSiguiente(nuevo);
                    }
                    flag = true;
                } else if (aux.obtenerSiguiente() != null) {
                    anterior = aux;
                    aux = aux.obtenerSiguiente();
                    inter = true;
                } else {
                    aux.enlazarSiguiente(nuevo);
                    flag = true;

                }
            }
        }
        size++;
    }

//    //Elimina un elemento en lista
//    public boolean eliminar(String ambulanciaID) {
//        boolean eliminado = false;
//        if (head != null) {
//            NodoAmbulancia actual = head;
//            NodoAmbulancia aux = null;
//            while (actual != null && !eliminado) {
//                if (actual.ObtenerValor().getIdAmbulancia().equals(ambulanciaID)) {
//                    actual.setValor(null);
//                    eliminado = true;
//                    size--;
//                }
//                if (!eliminado) {
//                    if (actual.obtenerSiguiente() != null) {
//                        aux.enlazarSiguiente(actual.obtenerSiguiente());
//                    } else {
//                        actual = actual.obtenerSiguiente();
//                    }
//                }
//            }
//        }
//        return eliminado;
//    }
    //Ver si este funciona bien
    public boolean eliminar(String ambulanciaID) {
        boolean eliminado = false;
        if (!esVacia()) {
            NodoAmbulancia aux = head;
            if (aux.ObtenerValor().getIdAmbulancia().equals(ambulanciaID)) {
                aux = aux.obtenerSiguiente();
                eliminado = true;
            } else {
                while (aux.ObtenerValor() != null) {
                    if (aux.ObtenerValor().getIdAmbulancia().equals(ambulanciaID)) {
                        aux.setValor(null);
                        eliminado = true;
                    } else if (aux.siguiente != null) {
                        aux = aux.obtenerSiguiente();
                    } else {
                        aux = null;
                    }
                }
            }
        }
        return eliminado;
    }

    //Elimina el primer elemento de la Lista
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

    //Devuelve la cantidad de ambulancias habilitadas 
    public int ambulanciasDisponibles() {
        int disponibles = 0;
        NodoAmbulancia aux = head;
        while (aux != null) {
            if (aux.valor.isHabilitada()) {
                disponibles++;
            }
            aux = aux.obtenerSiguiente();
        }
        return disponibles;
    }

    //Devuelve la cantidad de ambulancias deshabilitadas 
    public int ambulanciasNoDisponibles() {
        int Nodisponibles = 0;
        NodoAmbulancia aux = head;

        while (aux != null) {
            if (!aux.valor.isHabilitada()) {
                Nodisponibles++;
            }
            aux = aux.obtenerSiguiente();
        }
        return Nodisponibles;
    }

    public void listar() {
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            NodoAmbulancia aux = head;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while (aux != null) {
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.ObtenerValor().mostrarAbmbulancia() + " ]" + " ->  ");
                // Avanza al siguiente nodo.
                aux = aux.obtenerSiguiente();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }

    //busca ambulancia por iD y devuelve el objeto. 
    public Ambulancia getAmbulancia(String idAmb) {
        NodoAmbulancia aux = head;
        Ambulancia a = null;
        boolean flag = false;

        if (aux == null) {
            return a;
        } else {
            while (aux != null && !flag) {
                if (aux.valor.getIdAmbulancia().equals(idAmb)) {
                    flag = true;
                    a = aux.valor;
                } else {
                    aux = aux.obtenerSiguiente();
                }
            }
        }
        return a;
    }

    public boolean existeAmbulancia(String idAmb) {
        boolean existe = false;

        NodoAmbulancia aux = head;
        if (!esVacia()) {
            while (aux != null&&!existe) {
                if (aux.ObtenerValor().getIdAmbulancia().equals(idAmb)) {
                    existe = true;
                }
                aux = aux.obtenerSiguiente();
            }
        }
        return existe;
    }
}
