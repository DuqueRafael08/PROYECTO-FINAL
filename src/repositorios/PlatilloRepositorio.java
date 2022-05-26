/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorios;

import modelos.Platillo;
import utilidades.PlatilloParser;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author josed
 */
public class PlatilloRepositorio extends Repositorio {
    public Platillo[] platillosBase;

    public PlatilloRepositorio(String csvPath) {
        super(csvPath);
    }

    public void cargarPlatillosBase() throws IOException {
        Platillo[] results = {};
        String[] filasCsv = leerFilasCsv();
        for (String filaCsv: filasCsv) {
            Platillo platillo = PlatilloParser.parsearPlatilloDesdeFila(filaCsv);
            results = Arrays.copyOf(results, results.length + 1);
            results[results.length - 1] = platillo;
        }

        this.platillosBase = results;
    }

    public Platillo buscarPlatillo(String nombre) {
        for(Platillo platillo: platillosBase) {
            if (platillo.nombre.equals(nombre)) {
                return platillo;
            }
        }

        return null;
    }
}
