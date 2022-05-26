package repositorios;

import java.io.*;
import java.util.Arrays;

public class Repositorio {
    public final String csvPath;

    private FileWriter w;
    public PrintWriter writer;

    final File dbFile;


    public Repositorio(String csvPath) {
        this.csvPath = csvPath;
        this.dbFile = new File(csvPath);
    }

    String[] leerFilasCsv() throws IOException {
        String [] results = {};
        File file = new File(csvPath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] lineRead;
        String delimiter = ",";
        while ((line = br.readLine()) != null) {
            results = Arrays.copyOf(results, results.length + 1);
            results[results.length - 1] = line;
        }
        br.close();

        return results;
    }

    public void abrirWriter(boolean appendMode) throws IOException {
        w = new FileWriter(dbFile, appendMode);
        writer = new PrintWriter(w);
    }

    public void cerrarWriter() throws IOException {
        w.close();
        writer.close();

        w = null;
        writer = null;
    }
}
