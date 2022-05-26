/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz_usuario;

import java.util.Scanner;

/**
 *Clase abstracta para reutilizar la lógica en la interfaz de usuario 
 * @author jos
 */
public abstract class Pantalla {
    /**
     * Scanner global para no crearlo en cada función
     */
    public static final Scanner escaner = new Scanner(System.in);
    /**
     * Métodos de tipo abstracto
     */
    public abstract void imprimirPantalla();
    public abstract void ejecutarAccion();
    
    /**
     * No es abstracto porque no se reescribe en las clases hijas
     */
    public void imprimirOpcionNoValida(){
        System.out.println("Opcion no valida. Intente de nuevo.");
    }
}
