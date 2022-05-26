package interfaz_usuario.pantallas.pantallas_trabajador;

import controladores.ControladorDeTrabajador;
import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import utilidades.Instancias;

public class PantallaPrepararPlatillos extends Pantalla {
    @Override
    public void imprimirPantalla() {
        System.out.println("¿Que desea preparar?");
        System.out.println("1. Menu completo (aleatorio)");
        System.out.println("2. Platillo");
    }

    @Override
    public void ejecutarAccion() {
        String opcion = escaner.nextLine();
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        switch (opcion) {
            case "1":
                ControladorDeTrabajador controladorDeTrabajador = Instancias.obtenerControladorDeTrabajador();
                controladorDeTrabajador.generarMenuAleatorio();
                System.out.println("Se preparo el menu!!\n");
                interfazDeUsuario.irALaPantalla(new PantallaTrabajadorMenu());
                break;
            case "2":
                interfazDeUsuario.irALaPantalla(new PantallaPrepararPlatillo());
                break;
            default: imprimirOpcionNoValida();
        }
    }
}
