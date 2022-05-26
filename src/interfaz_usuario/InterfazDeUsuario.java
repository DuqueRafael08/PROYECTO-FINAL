/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz_usuario;

import interfaz_usuario.pantallas.MainMenu;

/**
 *
 * @author josed
 */
public class InterfazDeUsuario {
    public static InterfazDeUsuario instancia;
    
    public static InterfazDeUsuario obtenerInstancia() {
        if (instancia == null) {
            instancia = new InterfazDeUsuario();
        }
        
        return instancia;
    }

    private InterfazDeUsuario() {
        this.pantallaActual = new MainMenu();
        this.estaCorriendo = true;
    }
    
    boolean estaCorriendo;
    Pantalla pantallaActual;
    
    public void irALaPantalla(Pantalla pantalla) {
        this.pantallaActual = pantalla;
    }
    
    public void salir() {
        this.estaCorriendo = false;
    }
    
    public void ejecutarInterfazDeUsuario() {
        while (estaCorriendo) {
            this.pantallaActual.imprimirPantalla();
            this.pantallaActual.ejecutarAccion();
        }
    }
}
