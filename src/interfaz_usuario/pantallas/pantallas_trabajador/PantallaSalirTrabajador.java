package interfaz_usuario.pantallas.pantallas_trabajador;

import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;

public class PantallaSalirTrabajador extends Pantalla {
    @Override
    public void imprimirPantalla() {
        System.out.println("Trabaja duro o dura en el trabajo ¡HASTA LUEGO!");
    }

    @Override
    public void ejecutarAccion() {
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        interfazDeUsuario.salir();
    }
}
