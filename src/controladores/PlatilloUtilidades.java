package controladores;

import modelos.CantidadPlatillo;
import modelos.Platillo;


public class PlatilloUtilidades {
    public static int obtenerIndiceDelPlatillo(final Platillo[] arr, final String nombre) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].nombre.equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static int obtenerIndiceDeCantidadPlatillo(final CantidadPlatillo[] arr, final String nombre) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].platillo.nombre.equals(nombre)) {
                return i;
            }
        }
        return -1;
    }
}
