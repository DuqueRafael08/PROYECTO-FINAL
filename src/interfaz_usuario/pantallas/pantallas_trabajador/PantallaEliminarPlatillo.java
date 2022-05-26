package interfaz_usuario.pantallas.pantallas_trabajador;

import controladores.ControladorDeTrabajador;
import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import modelos.Menu;
import utilidades.ImpresorTablas;
import utilidades.Instancias;

public class PantallaEliminarPlatillo extends Pantalla {
    @Override
    public void imprimirPantalla() {
        ControladorDeTrabajador controladorDeTrabajador = Instancias.obtenerControladorDeTrabajador();
        Menu menu = controladorDeTrabajador.obtenerMenu();

        ImpresorTablas.imprimirTablaMenu(menu);
        System.out.println("¿Que platilo quieres eliminar?");
        System.out.println("(Puedes escribir TODO y vaciar el menu)");
    }

    @Override
    public void ejecutarAccion() {
        ControladorDeTrabajador controladorDeTrabajador = Instancias.obtenerControladorDeTrabajador();
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();

        String platillo = escaner.nextLine();
        if (platillo.equals("TODO")) {
            controladorDeTrabajador.eliminarTodoElMenu();
            System.out.println("Se elimino todo el menu");
        } else {
            boolean seElimino = controladorDeTrabajador.eliminarPlatilloDelMenu(platillo);
            if (seElimino) {
                System.out.println("Se elimino el platillo");
            }
        }

        interfazDeUsuario.irALaPantalla(new PantallaTrabajadorMenu());
    }
}
