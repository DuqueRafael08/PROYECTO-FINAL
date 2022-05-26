/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz_usuario.pantallas.pantallas_trabajador;

import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;

/**
 *
 * @author Duque Rafael 
 */
public class PantallaInicioSesionTrabajador extends Pantalla {
    final String contrasena = "123";

    @Override
    public void imprimirPantalla() {
        System.out.println("Ingresa la contraseña de empleado"); //Se pide una contraseña para entrar como empleado
    }

    @Override
    public void ejecutarAccion() {
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        String loginPassword;
     
        loginPassword = escaner.nextLine();
       
        if (contrasena.equals(loginPassword)) {
            interfazDeUsuario.irALaPantalla(new PantallaTrabajadorMenu());
        }
    }
}
