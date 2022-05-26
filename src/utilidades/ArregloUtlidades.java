package utilidades;

import modelos.CantidadPlatillo;

import java.util.Arrays;

public class ArregloUtlidades {
    public static <T> T[] agregar(T[] arr, T element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

    public static CantidadPlatillo[] eliminarElemto(CantidadPlatillo[] arr, int index)
    {
        if (arr == null || index < 0
                || index >= arr.length) {
            return arr;
        }

        CantidadPlatillo[] arrayRes = new CantidadPlatillo[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }

            arrayRes[k++] = arr[i];
        }

        return arrayRes;
    }
}
