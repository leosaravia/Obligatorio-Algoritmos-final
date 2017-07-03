package TAD;

import Dominio.Ciudad;

public class ListaCiudad {

    NodoCiudad head;
    int size;
    int tope;

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public NodoCiudad getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void setHead(NodoCiudad head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ListaCiudad(int tope) {
        this.head = null;
        this.size = 0;
        this.tope = tope;
    }

    public void agregarInicio(Ciudad ciudad) {
        if (head == null) {
            head = new NodoCiudad(ciudad);
        } else {
            //creamos un nodo temporal para almacenar el head y luego lo enlazamos con el nuevo nodo que pasaria a ser el head actual
            NodoCiudad temporal = head;
            NodoCiudad nuevo = new NodoCiudad(ciudad);
            nuevo.setSiguiente(temporal);
            head = nuevo;
        }
        size++;
    }

    public void borrarInicio() {
        head = head.getSiguiente();
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

    public void listar() {
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            NodoCiudad aux = head;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while (aux != null) {
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getValor().mostrarCiudades() + " ]" + " ->  ");
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }

    //Busca Ciudad por ID y devuelve el objeto
    public Ciudad getCiudad(int id) {

        NodoCiudad aux = head;
        Ciudad c = null;
        boolean flag = false;

        while (aux != null && !flag) {
            if (aux.valor.getCodigo() == id) {
                flag = true;
                c = aux.valor;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return c;
    }

    public boolean existeCiudad(int idciudad) {

        boolean existe = false;
        NodoCiudad aux = head;
        while (aux != null && !existe) {

            if (aux.valor.getCodigo() == idciudad) {
                existe = true;
            }

            //Actualizamos
            aux = aux.getSiguiente();
        }
        return existe;
    }
}
