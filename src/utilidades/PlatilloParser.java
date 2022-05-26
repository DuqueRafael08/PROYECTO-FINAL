package utilidades;

import modelos.CantidadPlatillo;
import modelos.Platillo;
/**
 * Clase para separar el archivo csv
 * @author josed
 */
public class PlatilloParser {
    public static Platillo parsearPlatilloDesdeFila(String filaCsv) {
        String []filaArr = filaCsv.split(",");
        float precio = Float.parseFloat(filaArr[1]);
        Platillo platillo = new Platillo(filaArr[0], filaArr[2], precio);

        return platillo;
    }

    public static CantidadPlatillo parsearCantidadPlatilloDesdeFila(String filaCsv) {
        String []filaArr = filaCsv.split(",");
        float precio = Float.parseFloat(filaArr[1]);
        int cantidad = Integer.parseInt(filaArr[3]);
        Platillo platillo = new Platillo(filaArr[0], filaArr[2], precio);

        return new CantidadPlatillo(cantidad, platillo, 0, 0);
    }
}
