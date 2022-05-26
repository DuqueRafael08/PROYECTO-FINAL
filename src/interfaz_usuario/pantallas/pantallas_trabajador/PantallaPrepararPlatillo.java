package interfaz_usuario.pantallas.pantallas_trabajador;

import controladores.ControladorDeTrabajador;
import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import modelos.Platillo;
import utilidades.ImpresorTablas;
import utilidades.Instancias;

public class PantallaPrepararPlatillo extends Pantalla {
    String platilloAPreparar;
    int cantidad;
    @Override
    public void imprimirPantalla() {
        ControladorDeTrabajador controladorDeTrabajador = Instancias.obtenerControladorDeTrabajador();
        Platillo[] base = controladorDeTrabajador.obtenerPlatillosBase();

        if (platilloAPreparar == null) {
            ImpresorTablas.imprimirPlatillosBase(base);
            System.out.println("¿Que platilo quieres preparar?");
            return;
        }
        System.out.println("¿Cuantos?");
    }

    @Override
    public void ejecutarAccion() {
        if (platilloAPreparar == null) {
            platilloAPreparar = escaner.nextLine();
            return;
        }
        cantidad = escaner.nextInt();

        ControladorDeTrabajador controladorDeTrabajador = Instancias.obtenerControladorDeTrabajador();
        boolean seCreo = controladorDeTrabajador.prepararPlatillo(platilloAPreparar, cantidad);
        if (seCreo) {
            System.out.println("Se creo el platillo!!");
            InterfazDeUsuario.obtenerInstancia().irALaPantalla(new PantallaTrabajadorMenu());
        } else {
            platilloAPreparar = null;
            System.out.println("No se encuentra el platillo, intente de nuevo");
        }
    }
}
