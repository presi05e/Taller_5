import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargadorCSV {

    public static ArrayList<Palabra> cargarPalabras() {

        ArrayList<Palabra> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("palabras.csv"));

            String linea;

            // Saltar encabezado
            br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(",");

                String categoria = partes[0];
                String palabra = partes[1];
                String pista = partes[2];

                lista.add(new Palabra(categoria, palabra, pista));
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV.");
        }

        return lista;
    }
}