package utilidades;

import modelos.CantidadPlatillo;
import modelos.Menu;
import modelos.Platillo;

public class ImpresorTablas {

    public static String formatearPrecio(float precio) {
        return String.format("%.2f", precio) + "$";
    }
    public static String multiplicarString(String str, int n) {
        StringBuilder strMultiplicado = new StringBuilder();
        for (int i = 0; i < n; i++) {
            strMultiplicado.append(str);//
        }

        return strMultiplicado.toString();
    }

    private static String formatearCelda(String celda) {
        int longituldDeLaCelda = 20;

        if (celda.length() > longituldDeLaCelda) {
            celda = celda.substring(0, longituldDeLaCelda-4) + "... ";
            return celda;
        }

        return celda + multiplicarString(" ", longituldDeLaCelda - celda.length());
    }

    private static void imprimirSeparador(int tamano) {
        String separador = multiplicarString("- ", tamano);
        System.out.println(separador);
    }

    private static void imprimirTablaConCantidad(Menu menu) {
        imprimirSeparador(40);

        String filaPlatillo;
        for (CantidadPlatillo cantidadPlatillo: menu.cantidadPlatillos) {
            Platillo platillo = cantidadPlatillo.platillo;
            String precio = formatearPrecio(platillo.precio);

            filaPlatillo = formatearCelda(platillo.nombre) +
                    formatearCelda(precio) +
                    formatearCelda(platillo.tipo) +
                    formatearCelda("\t" + cantidadPlatillo.cantidad);
            System.out.println(filaPlatillo);
            imprimirSeparador(40);
        }
    }

    public static void imprimirTablaMenu(Menu menu) {
        String titulos = formatearCelda("| Nombre |") +
                        formatearCelda("| Precio |") +
                        formatearCelda("| Tipo |") +
                        formatearCelda("| Disponibles |");
        System.out.println(titulos);
        imprimirTablaConCantidad(menu);
    }

    public static void imprimirTablaMenuCantidad(Menu menu) {
        String titulos = formatearCelda("| Nombre |") +
                formatearCelda("| Precio |") +
                formatearCelda("| Tipo |") +
                formatearCelda("| Cantidad |");
        System.out.println(titulos);
        imprimirTablaConCantidad(menu);
    }

    public static void imprimirPlatillosBase(Platillo[] platillos) {
        String titulos = formatearCelda("| Nombre |") +
                formatearCelda("| Precio |") +
                formatearCelda("| Tipo |");
        System.out.println(titulos);
        imprimirSeparador(20);

        String filaPlatillo;
        for (Platillo platillo: platillos) {
            String precio = formatearPrecio(platillo.precio);

            filaPlatillo = formatearCelda(platillo.nombre) +
                    formatearCelda(precio) +
                    formatearCelda(platillo.tipo);
            System.out.println(filaPlatillo);
            imprimirSeparador(20);
        }
    }
}
