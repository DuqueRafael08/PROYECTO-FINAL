package interfaz_usuario.pantallas.pantallas_comenzal;

import controladores.ControladorDeCliente;
import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import modelos.Menu;
import utilidades.ImpresorTablas;
import utilidades.Instancias;

public class PantallaRealizarCompra extends Pantalla {
    final Menu ticketInfo;
    final boolean vaciarCarrito;
    ControladorDeCliente controladorDeCliente = Instancias.obtenerControladorDeCliente();

    public PantallaRealizarCompra(Menu ticketInfo, boolean vaciarCarrito) {
        this.ticketInfo = ticketInfo;
        this.vaciarCarrito = vaciarCarrito;
    }

    @Override
    public void imprimirPantalla() {
        imprimirTicket();
    }

    @Override
    public void ejecutarAccion() {
        escaner.nextLine();
        InterfazDeUsuario.obtenerInstancia().irALaPantalla(new PantallaComenzalMenu());
        if (vaciarCarrito) {
            controladorDeCliente.vaciarCarrito();
        }
    }

    void imprimirTicket() {
        System.out.println("\t\t| Tu ticket |");

        ImpresorTablas.imprimirTablaMenuCantidad(ticketInfo);
        System.out.println("Precio Cubiertos: " + ImpresorTablas.formatearPrecio((float) ticketInfo.obtenerPrecioCubiertos()));
        System.out.println("Precio Envolturas: " + ImpresorTablas.formatearPrecio((float) ticketInfo.obtenerPrecioEnvolturas()));
        System.out.println("\n\tTotal: " + ImpresorTablas.formatearPrecio((float) ticketInfo.obtenerPrecioTotal()));
        System.out.println("Digita cualquier cosa para continuar");
    }
}
