package TAD;

import Dominio.Ciudad;

public class ListaCiudad {

    NodoCiudad head;
    int size;

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

    public ListaCiudad() {
        this.head = null;
        size = 0;
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

    public void agregarFinal(Ciudad ciudad) {
        // Define un nuevo nodo.
        NodoCiudad nuevo = new NodoCiudad(ciudad);
        // Agrega al valor al nodo.
        nuevo.getValor();
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            head = nuevo;
            // Caso contrario recorre la lista hasta llegar al ultimo nodo
            //y agrega el nuevo.
        } else {
            // Crea ua copia de la lista.
            NodoCiudad aux = head;
            // Recorre la lista hasta llegar al ultimo nodo.
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setSiguiente(nuevo);
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

        while (aux.getSiguiente() != null && !flag) {
            if (aux.valor.getCodigo() == id) {
                flag = true;
                c = aux.valor;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return c;
    }
    
    public Ciudad getCiudadNombre(String nombre) {

        NodoCiudad aux = head;
        Ciudad c = null;
        boolean flag = false;
        if (head==null) {
            return c;
        }else{
        while (aux != null && !flag) {
            if (aux.valor.getNombre().equals(nombre)) {
                flag = true;
                c = aux.valor;
            } else {
                aux = aux.getSiguiente();
            }
        }
        }
        return c;
    }
    
    public boolean existeCiudad(int idciudad){
 
        boolean existe=false;
        NodoCiudad aux=head;
 
        while(aux!=null && !existe){
 
            if(aux.valor.getCodigo()==idciudad){
                existe=true;
            }
             
            //Actualizamos
            aux=aux.getSiguiente();
        }
        return existe;
        }
}
