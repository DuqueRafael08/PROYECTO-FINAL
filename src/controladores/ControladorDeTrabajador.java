/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.CantidadPlatillo;
import modelos.Menu;
import modelos.Platillo;
import repositorios.MenuRepositorio;
import repositorios.PlatilloRepositorio;

/**
 *Zona de atributos
 * No se pueden modificar
 */
public class ControladorDeTrabajador {
    final MenuRepositorio menuRepositorio;
    final PlatilloRepositorio platilloRepositorio;


    public ControladorDeTrabajador(MenuRepositorio menuRepositorio, PlatilloRepositorio platilloRepositorio) {
        this.menuRepositorio = menuRepositorio;
        this.platilloRepositorio = platilloRepositorio;
    }

    public void generarMenuAleatorio() {
        Platillo[] platillosBase = platilloRepositorio.platillosBase;
        Menu menu = Generador.generarMenuAleatorio(10, platillosBase);
        menuRepositorio.guardarMenu(menu);
    }

    public Platillo[] obtenerPlatillosBase() {
        return platilloRepositorio.platillosBase;
    }

    public Menu obtenerMenu() {
        return menuRepositorio.obtenerMenu();
    }

    public boolean prepararPlatillo(String nombrePlatillo, int cantidad) {
        Platillo[] platillosBase = obtenerPlatillosBase();
        int idx = PlatilloUtilidades.obtenerIndiceDelPlatillo(platillosBase, nombrePlatillo);
        if (idx == -1) {
            return false;
        }

        CantidadPlatillo platilloAInsertar = new CantidadPlatillo(cantidad, platillosBase[idx], 0, 0);
        menuRepositorio.insertarPlatillo(platilloAInsertar);
        return true;
    }

    public boolean eliminarPlatilloDelMenu(String nombrePlatillo) {
        return menuRepositorio.eliminarPlatillo(nombrePlatillo);
    }

    public void eliminarTodoElMenu() {
        menuRepositorio.eliminarMenu();
    }
}
