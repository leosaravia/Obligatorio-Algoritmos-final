/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsPackage;

import mainPackage.Isistema;
import mainPackage.SistemaAmbulancia;

/**
 *
 * @author alumnoFI
 */
public class Inicializar {

    //Inicializa ciudades y ambulancias
    public static Isistema inicializador1() {
        SistemaAmbulancia s = new SistemaAmbulancia();
        s.crearSistemaDeEmergencias(100);
        
        //Ciudades
        s.agregarCiudad("Montevideo");
        s.agregarCiudad("Maldonado");
        s.agregarCiudad("Canelones");
        s.agregarCiudad("Artigas");
        s.agregarCiudad("Cerro Largo");
        s.agregarCiudad("Flores");
        
        //Ambulancias
        s.registrarAmbulancia("ABC123", 1);
        s.registrarAmbulancia("STD456", 2);
        s.registrarAmbulancia("ZFB895", 3);
        s.registrarAmbulancia("YTF258", 4);
        s.registrarAmbulancia("ZFB654", 5);
        
        return s;

    }

    //Inicializa Solo Ciudades
    public static Isistema inicializadorCiudades() {
        SistemaAmbulancia s = new SistemaAmbulancia();
        s.crearSistemaDeEmergencias(100);
        
        //Ciudades
        s.agregarCiudad("Montevideo");
        s.agregarCiudad("Maldonado");
        s.agregarCiudad("Canelones");
        s.agregarCiudad("Artigas");
        s.agregarCiudad("Cerro Largo");
        s.agregarCiudad("Flores");
        
        return s;
    }

    //Inicializa Solo Ambulancias
    public static Isistema inicializadorAmbulancias(){
        SistemaAmbulancia s = new SistemaAmbulancia();
        s.crearSistemaDeEmergencias(100);
        
        //Ambulancias
        s.registrarAmbulancia("ABC123", 1);
        s.registrarAmbulancia("STD456", 2);
        s.registrarAmbulancia("ZFB895", 3);
        s.registrarAmbulancia("YTF258", 4);
        s.registrarAmbulancia("ZFB654", 5);
        
        return s;
    }
}
