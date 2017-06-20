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
public class NodoChofer {
    Chofer valor;
    NodoChofer siguiente;
    
    public NodoChofer(Chofer valor)
    {
        this.valor=valor;
        this.siguiente=null;
    }
    
    public Chofer ObtenerValor()
    {
        return valor;
    }
    public void enlazarSiguiente(NodoChofer n)
    {
        siguiente = n;
    }
    public NodoChofer obtenerSiguiente()
    {
        return siguiente;
    }
    
    
}
