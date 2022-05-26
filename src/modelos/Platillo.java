/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *Clase platillo que muestra la información
 * que tiene un platillo 
 * @author Duque Rafael
 */
public class Platillo {
    public final String nombre;
    public final String tipo;
    public final float precio;
    /**
     * Constructor inicializado
     * @param nombre
     * @param tipo
     * @param precio 
     */
    public Platillo(String nombre, String tipo, float precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }
}
