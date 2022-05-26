/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz_usuario.pantallas.pantallas_trabajador;

import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import interfaz_usuario.pantallas.general.PantallaPlatillosDelDia;

/**
 *
 * @author Duque Rafael
 */
public class PantallaTrabajadorMenu extends Pantalla {

    @Override
    public void imprimirPantalla() {
        System.out.println("Sistema del Restaurante C.U");
        System.out.println("Elige la opción que deseas");
        System.out.println("1. Ver platillos del día");
        System.out.println("2. Preparar más platillos");  
        System.out.println("3. Eliminar un platillo agotado");
        System.out.println("4. Salir");
    }

    @Override
    public void ejecutarAccion() {
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        String opcion = escaner.nextLine();
        
        switch (opcion) {
            case "1":
                interfazDeUsuario.irALaPantalla(new PantallaPlatillosDelDia(this));
                break;
            case "2":
                interfazDeUsuario.irALaPantalla(new PantallaPrepararPlatillos());
                break;
            case "3":
                interfazDeUsuario.irALaPantalla(new PantallaEliminarPlatillo());
                break;
            case "4":
                 interfazDeUsuario.irALaPantalla(new PantallaSalirTrabajador());
                break;
            default:
                imprimirOpcionNoValida();
        }
    }
}
