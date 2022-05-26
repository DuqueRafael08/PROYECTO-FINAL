package interfaz_usuario.pantallas.pantallas_comenzal;

import controladores.ControladorDeCliente;
import interfaz_usuario.InterfazDeUsuario;
import interfaz_usuario.Pantalla;
import modelos.CantidadPlatillo;
import modelos.Menu;
import utilidades.ImpresorTablas;
import utilidades.Instancias;

public class PantallaOrdenarPlatillo extends Pantalla {
    ControladorDeCliente controladorDeCliente = Instancias.obtenerControladorDeCliente();

    String platillo;
    float costoCubiertos = -1;
    float costoEnvoltura = -1;

    @Override
    public void imprimirPantalla() {
        Menu menu = controladorDeCliente.obtenerMenu();
        if (menu.cantidadPlatillos.length == 0) {
            System.out.println("Por ahora no hay menu, pidele a un empleado que lo prepare\n");
            System.out.println("Digita cualquier cosa para salir");
            return;
        }

        if (platillo == null) {
            ImpresorTablas.imprimirTablaMenu(menu);
        }

        if (platillo == null) {
            System.out.println("¿Que platillo quieres comprar?");
            return;
        }

        if (costoCubiertos == -1) {
            System.out.println("¿Quieres cubiertos $5? (si / no)");
            return;
        }


        System.out.println("¿Envoltura? \n1.plastico $5 \n(cualquier caracter).carton $5");
    }

    @Override
    public void ejecutarAccion() {
        CantidadPlatillo[] platillos = controladorDeCliente.obtenerMenu().cantidadPlatillos;
        if (platillos.length == 0) {
            escaner.nextLine();
            InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
            interfazDeUsuario.irALaPantalla(new PantallaComenzalMenu());

            return;
        }

        if (platillo == null) {
            platillo = escaner.nextLine();
            return;
        }

        if (costoCubiertos == -1) {
            String op = escaner.nextLine();
            if (op.equals("si")) {
                costoCubiertos = 5;
            }
            return;
        }

        String op = escaner.nextLine();
        if (op.equals("1")) {
            costoEnvoltura = 5;
        } else {
            costoEnvoltura = 5;
        }


        /**
         * Obtiene de la instancia de Interfaz de usuario
         */
        InterfazDeUsuario interfazDeUsuario = InterfazDeUsuario.obtenerInstancia();
        if (controladorDeCliente.ordenarPlatillo(platillo, costoCubiertos, costoEnvoltura)) {
            System.out.println("El platillo se agrego a tu carrito");//si ordena un platillo se agrega y se devuelve a la pantalla del menú
            interfazDeUsuario.irALaPantalla(new PantallaComenzalMenu());
            return;
        }

        System.out.println("\nEl platillo no esta disponible intenta de nuevo");
    }
}
