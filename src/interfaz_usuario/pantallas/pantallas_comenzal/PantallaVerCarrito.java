package interfaz_usuario.pantallas.pantallas_comenzal;

import controladores.ControladorDeCliente;
import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import modelos.CantidadPlatillo;
import modelos.Menu;
import utilidades.ImpresorTablas;
import utilidades.Instancias;

public class PantallaVerCarrito extends Pantalla {
    @Override
    public void imprimirPantalla() {
        System.out.println("\t\t| Tu carrito |");
        ControladorDeCliente controladorDeCliente = Instancias.obtenerControladorDeCliente();
        CantidadPlatillo[] carrito = controladorDeCliente.obtenerCarrito();
        ImpresorTablas.imprimirTablaMenuCantidad(new Menu(carrito));//Manda a llamar la función sin crear el objeto 
        System.out.println("Digita cualquier cosa para salir");
    }

    @Override
    public void ejecutarAccion() {
        InterfazDeUsuario.obtenerInstancia().irALaPantalla(new PantallaComenzalMenu());
    }
}
