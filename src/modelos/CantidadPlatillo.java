package modelos;
/**
 * 
 * @author Duque Rafael
 */
public class CantidadPlatillo {
    public int cantidad;
    public final Platillo platillo;
    public final float costoCubiertos;
    public final float costoEnvoltura;

    public CantidadPlatillo(int cantidad, Platillo platillo, float costoCubiertos, float costoEnvoltura) {
        this.cantidad = cantidad;
        this.platillo = platillo;
        this.costoCubiertos = costoCubiertos;
        this.costoEnvoltura = costoEnvoltura;
    }

    public String pasarACsv() {
        return platillo.nombre + "," + platillo.precio + "," +
                platillo.tipo + "," + cantidad + ",";
    }
}