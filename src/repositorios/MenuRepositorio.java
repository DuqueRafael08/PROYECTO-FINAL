package repositorios;

import controladores.PlatilloUtilidades;
import modelos.CantidadPlatillo;
import modelos.Menu;
import utilidades.ArregloUtlidades;
import utilidades.PlatilloParser;

import java.io.IOException;
import java.util.Arrays;
/**
 * 
 * @author Duque Rafael
 */

public class MenuRepositorio extends Repositorio {
    private Menu menu;

    public MenuRepositorio(String csvPath) {
        super(csvPath);
    }

    public void cargarMenuDesdeLaDB() throws IOException {
        CantidadPlatillo[] results = {};
        String[] filasCsv = leerFilasCsv();
        for (String filaCsv: filasCsv) {
            CantidadPlatillo platillo = PlatilloParser.parsearCantidadPlatilloDesdeFila(filaCsv);
            results = Arrays.copyOf(results, results.length + 1);
            results[results.length - 1] = platillo;
        }

        this.menu = new Menu(results);
    }

    public Menu obtenerMenu() {
        return menu;
    }

    public void guardarMenu(Menu menu) {
        this.menu = menu;

        try {
            abrirWriter(false);

            String document = menu.pasarACsv();

            writer.print(document);
            cerrarWriter();
        } catch (IOException e){
            System.out.println("Error: No se guardo el menu\n");
        };

    }

    public void insertarPlatillo(CantidadPlatillo cantidadPlatillo) {
        int idx = PlatilloUtilidades.obtenerIndiceDeCantidadPlatillo(
                menu.cantidadPlatillos,
                cantidadPlatillo.platillo.nombre
        );

        if (idx == -1) {
            menu.cantidadPlatillos = ArregloUtlidades.agregar(menu.cantidadPlatillos, cantidadPlatillo);
        } else {
            cantidadPlatillo.cantidad += menu.cantidadPlatillos[idx].cantidad;
            menu.cantidadPlatillos[idx] = cantidadPlatillo;
        }

        guardarMenu(menu);
    }

    public boolean eliminarPlatillo(String nombrePlatillo) {
        CantidadPlatillo[] platillosMenu = obtenerMenu().cantidadPlatillos;

        int idx = PlatilloUtilidades.obtenerIndiceDeCantidadPlatillo(platillosMenu, nombrePlatillo);
        if (idx == -1) {
            return false;
        }

        menu.cantidadPlatillos = ArregloUtlidades.eliminarElemto(platillosMenu, idx);

        guardarMenu(menu);
        return true;
    }

    public boolean consumirPlatillo(String nombrePlatillo) {
        CantidadPlatillo[] platillosMenu = obtenerMenu().cantidadPlatillos;

        int idx = PlatilloUtilidades.obtenerIndiceDeCantidadPlatillo(platillosMenu, nombrePlatillo);
        if (idx == -1) {
            return false;
        }

        CantidadPlatillo platilloBuscado = menu.cantidadPlatillos[idx];
        if(platilloBuscado.cantidad == 1) {
            menu.cantidadPlatillos = ArregloUtlidades.eliminarElemto(platillosMenu, idx);
        } else {
            platilloBuscado.cantidad -= 1;
        }

        guardarMenu(menu);
        return true;
    }

    public void eliminarMenu() {
        menu.cantidadPlatillos = new CantidadPlatillo[]{};
        guardarMenu(menu);
    }
}
