package utilidades;

/**
 * Clase instancia sirve para mantener un objeto unico de cada controlador
 * Solo tiene métodos estáticos
 */
import controladores.ControladorDeCliente;
import controladores.ControladorDeTrabajador;

public class Instancias {
    private static ControladorDeTrabajador controladorDeTrabajador;
    public static ControladorDeCliente controladorDeCliente;

    public static void setearInstancias(
            ControladorDeTrabajador nuevoControladorDeTrabajador,
            ControladorDeCliente nuevoControladorDeCliente
    ) {
        controladorDeTrabajador = nuevoControladorDeTrabajador;
        controladorDeCliente = nuevoControladorDeCliente;
    }

    public static ControladorDeTrabajador obtenerControladorDeTrabajador() {
        return controladorDeTrabajador;
    }
    public static ControladorDeCliente obtenerControladorDeCliente() {
        return controladorDeCliente;
    }
}
