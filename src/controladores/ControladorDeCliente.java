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
import utilidades.ImpresorTablas;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author josed
 */
public class ControladorDeCliente {
    /**
     * Zona de atributos
     */
    ArrayList<CantidadPlatillo> miCarrito;
    final MenuRepositorio menuRepositorio;
    final PlatilloRepositorio platilloRepositorio;

    public ControladorDeCliente(MenuRepositorio menuRepositorio, PlatilloRepositorio platilloRepositorio) {
        this.platilloRepositorio = platilloRepositorio;
        this.miCarrito = new ArrayList<CantidadPlatillo>();
        this.menuRepositorio = menuRepositorio;
    }

    public boolean ordenarPlatillo(String nombrePlatillo,
                                   float costoCubiertos, float costoEnvoltura
                                   ) {
        boolean seConsumio = menuRepositorio.consumirPlatillo(nombrePlatillo);
        if (seConsumio) {
            Platillo platillo = platilloRepositorio.buscarPlatillo(nombrePlatillo);
            int idx = PlatilloUtilidades.obtenerIndiceDeCantidadPlatillo(obtenerCarrito(), platillo.nombre);
            if (idx == -1) {
                miCarrito.add(
                        new CantidadPlatillo(1, platillo, costoCubiertos, costoEnvoltura)
                );

                return true;
            }

            miCarrito.get(idx).cantidad += 1;
            return true;
        }

        return false;
    }
    /**
     * Método que regresa un arreglo de cantidad platillo
     * @return 
     */
    public CantidadPlatillo[] obtenerCarrito() {
        int length = miCarrito.toArray().length;
        CantidadPlatillo[] carritoArr = new CantidadPlatillo[length];
        for (int i=0; i < length; i++) {
            carritoArr[i] = miCarrito.get(i);
        }

        return carritoArr;
    }

    public Menu obtenerMenu() {
        return menuRepositorio.obtenerMenu();
    }

    public String obtenerPrecioCarrito() {
        AtomicReference<Float> precio = new AtomicReference<>((float) 0);
        miCarrito.forEach(cantidadPlatillo ->
                precio.updateAndGet(v -> (float) (v + cantidadPlatillo.platillo.precio * cantidadPlatillo.cantidad))
        );

        return ImpresorTablas.formatearPrecio(precio.get());
    }

    public void vaciarCarrito() {
        miCarrito = new ArrayList<CantidadPlatillo>();
    }
}
