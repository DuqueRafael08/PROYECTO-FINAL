/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.CantidadPlatillo;
import modelos.Menu;
import modelos.Platillo;

import java.util.Arrays;
/**
 *Clase generador que
 * @author Duque Rafael
 */
public class Generador {
    /**
     * 
     * @param numeroDePlatillos
     * @param platillosBase
     * @return 
     */
    public static  Menu generarMenuAleatorio(int numeroDePlatillos, Platillo[] platillosBase) {
        int[] seleccionados = new int[numeroDePlatillos];
        CantidadPlatillo[] generados = new CantidadPlatillo[numeroDePlatillos];

        int platilloSeleccionadoIndex;
        int cantidad;
        for(int i=0; i<numeroDePlatillos; i++) {
            platilloSeleccionadoIndex = (int)(Math.random()*platillosBase.length);
            while (contains(seleccionados, platilloSeleccionadoIndex)) {
                platilloSeleccionadoIndex = (int)(Math.random()*platillosBase.length);
            }
            seleccionados[i] = platilloSeleccionadoIndex;
            cantidad = (int)(Math.random()*10 + 1);
            generados[i] = new CantidadPlatillo(cantidad, platillosBase[platilloSeleccionadoIndex], 0, 0);
        }

        return new Menu(generados);
    }
    /**
     * Método para generar pedidos aleatorios
     * @param numeroDePlatillos
     * @param platillosBase
     * @return 
     */
    public static  Menu generarPedido(int numeroDePlatillos, Platillo[] platillosBase) {
        CantidadPlatillo[] generados = new CantidadPlatillo[numeroDePlatillos];

        int platilloSeleccionadoIndex;
        int cantidad;

        for(int i=0; i<numeroDePlatillos; i++) {
            platilloSeleccionadoIndex = (int)(Math.random()*platillosBase.length);

            cantidad = (int)(Math.random()*10 + 1);
            generados[i] = new CantidadPlatillo(
                    cantidad, platillosBase[platilloSeleccionadoIndex],
                    generarCostoDeCubiertosAleatorio(),
                    generarCostoDeEnvolturaAleatorio());
        }

        return new Menu(generados);
    }

    private static float generarCostoDeCubiertosAleatorio() {
        double seed = Math.random();
        if (seed > 0.5) {
            return 5;
        }

        return 0;
    }

    private static float generarCostoDeEnvolturaAleatorio() {
        double seed = Math.random();
        if (seed > 0.5) {
            return 5;
        }

        return 5;
    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
}
