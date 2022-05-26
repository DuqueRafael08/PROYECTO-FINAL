package interfaz_usuario.pantallas.general;

import controladores.ControladorDeTrabajador;
import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import modelos.Menu;
import utilidades.ImpresorTablas;
import utilidades.Instancias;

public class PantallaPlatillosDelDia extends Pantalla {
    final Pantalla pantallaAnterior;

    public PantallaPlatillosDelDia(Pantalla pantallaAnterior) {
        this.pantallaAnterior = pantallaAnterior;
    }


    @Override
    public void imprimirPantalla() {
        ControladorDeTrabajador controladorDeTrabajador = Instancias.obtenerControladorDeTrabajador();
        Menu menu = controladorDeTrabajador.obtenerMenu();
        if (menu.cantidadPlatillos.length == 0) {
            System.out.println("Por ahora no hay menu, pidele a un empleado que lo prepare\n");
        } else {
            System.out.println("\t\t| Menu del dia |");
            ImpresorTablas.imprimirTablaMenu(menu);
        }

        System.out.println("Digita cualquier cosa para salir");
    }

    @Override
    public void ejecutarAccion() {
        escaner.nextLine();
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        interfazDeUsuario.irALaPantalla(pantallaAnterior);
    }
}
