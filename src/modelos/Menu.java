/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author josed
 */

public class Menu {
    public CantidadPlatillo[] cantidadPlatillos;

    public Menu(CantidadPlatillo[] cantidadPlatillos) {
        this.cantidadPlatillos = cantidadPlatillos;
    }

    public String pasarACsv() {
        StringBuilder csvStr = new StringBuilder();

        for (int i=0; i<cantidadPlatillos.length; i++) {
            csvStr.append(cantidadPlatillos[i].pasarACsv());
            if (i < cantidadPlatillos.length - 1) {
                csvStr.append("\n");
            }
        }

        return csvStr.toString();
    }

    public float obtenerPrecioTotal() {
        float precioFinal = 0;
        for (CantidadPlatillo cantidadPlatillo: cantidadPlatillos) {
            precioFinal += cantidadPlatillo.platillo.precio * cantidadPlatillo.cantidad + cantidadPlatillo.costoCubiertos + cantidadPlatillo.costoEnvoltura;
        }

        return precioFinal;
    }

    public float obtenerPrecioCubiertos() {
        float precioFinal = 0;
        for (CantidadPlatillo cantidadPlatillo: cantidadPlatillos) {
            precioFinal += cantidadPlatillo.costoCubiertos * cantidadPlatillo.cantidad;
        }

        return precioFinal;
    }

    public float obtenerPrecioEnvolturas() {
        float precioFinal = 0;
        for (CantidadPlatillo cantidadPlatillo: cantidadPlatillos) {
            precioFinal += cantidadPlatillo.costoEnvoltura * cantidadPlatillo.cantidad;
        }

        return precioFinal;
    }
}
