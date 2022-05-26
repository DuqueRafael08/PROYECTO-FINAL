/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz_usuario.pantallas;

import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import interfaz_usuario.pantallas.pantallas_comenzal.PantallaComenzalMenu;
import interfaz_usuario.pantallas.pantallas_trabajador.PantallaInicioSesionTrabajador;

/**
 *
 * @author Duque Rafael
 */
public class MainMenu extends Pantalla {

    @Override
    public void imprimirPantalla() {
         System.out.println("Bienvenido al restaurante C.U");
         System.out.println("Si usted es un empleado ingrese 1. Si es un comenzal ingrese 2");
    }

    @Override
    public void ejecutarAccion() {
        String option;
        
        option = escaner.nextLine();
        System.out.println(option);
        
        /**
         * Trae la instancia global de la interfaz de usuario (cambio entre pantallas)
         */
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        switch (option) {
            case "1" -> interfazDeUsuario.irALaPantalla(new PantallaInicioSesionTrabajador());
            case "2" -> interfazDeUsuario.irALaPantalla(new PantallaComenzalMenu());
            default -> imprimirOpcionNoValida();
        }
    }
}
