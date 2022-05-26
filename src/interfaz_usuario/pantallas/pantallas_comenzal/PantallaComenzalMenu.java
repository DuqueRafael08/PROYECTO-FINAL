package interfaz_usuario.pantallas.pantallas_comenzal;

import controladores.ControladorDeCliente;
import controladores.Generador;
import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import modelos.CantidadPlatillo;
import modelos.Menu;
import utilidades.Instancias;
/**
 * Pantalla exclusiva del cliente (ya que se ingresa la opción 2)
 * @author josed
 */
public class PantallaComenzalMenu extends Pantalla {
    @Override
    public void imprimirPantalla() {
        System.out.println("Que desea hacer");
        System.out.println("1. Ordenar un platillo");
        System.out.println("2. Ver mi carrito");
        System.out.println("3. Realizar compra");
        System.out.println("4. Hacer pedido grande (aleatorio)");
        System.out.println("5. Salir");
    }

    @Override
    public void ejecutarAccion() {
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        String opcion = escaner.nextLine();
        switch (opcion) {
            case "1" -> interfazDeUsuario.irALaPantalla(new PantallaOrdenarPlatillo());
            case "2" -> interfazDeUsuario.irALaPantalla(new PantallaVerCarrito());
            case "3" -> {
                ControladorDeCliente controladorDeCliente = Instancias.obtenerControladorDeCliente();
                CantidadPlatillo[] carrito = controladorDeCliente.obtenerCarrito();
                interfazDeUsuario.irALaPantalla(new PantallaRealizarCompra(
                        new Menu(carrito),
                        true));
            }
            case "4" -> {
                System.out.println("¿Cuantos platillos quieres?");
                int pedidos = escaner.nextInt();
                Menu pedidoGrande = Generador.generarPedido(
                        pedidos,
                        Instancias.obtenerControladorDeTrabajador().obtenerPlatillosBase()
                );
                interfazDeUsuario.irALaPantalla(new PantallaRealizarCompra(
                        pedidoGrande,
                        false));
            }
            case "5" -> interfazDeUsuario.salir();
            default -> imprimirOpcionNoValida();
        }
    }
}
