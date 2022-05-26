/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import controladores.ControladorDeCliente;
import controladores.ControladorDeTrabajador;
import interfaz_usuario.InterfazDeUsuario;
import repositorios.MenuRepositorio;
import repositorios.PlatilloRepositorio;
import utilidades.Instancias;

import java.io.IOException;

/**
 *Clase principal donde se importan y mandan a llamar los métodos y clases
 * @author Duque Rafael
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlatilloRepositorio platilloRepositorio = new PlatilloRepositorio("platillos.csv");
        MenuRepositorio menuRepositorio = new MenuRepositorio("menu.csv");
        try {
            platilloRepositorio.cargarPlatillosBase();
            menuRepositorio.cargarMenuDesdeLaDB();
        } catch (IOException e) {
            System.out.println("Error al leer la base de datos csv");
        }

        ControladorDeTrabajador controladorDeTrabajador = new ControladorDeTrabajador(menuRepositorio, platilloRepositorio);
        ControladorDeCliente controladorDeCliente = new ControladorDeCliente(menuRepositorio, platilloRepositorio);
        Instancias.setearInstancias(controladorDeTrabajador, controladorDeCliente);

        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        interfazDeUsuario.ejecutarInterfazDeUsuario();
    }
}
