import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargadorCSV {

    public static ArrayList<Palabra> cargarPalabras() {

        ArrayList<Palabra> lista = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("tallerAhorcado/palabras.csv"));

            String linea;

            br.readLine();

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(",");

                if (partes.length < 3) {
                    System.out.println("Línea inválida: " + linea);
                    continue;
                }

                String categoria = partes[0].trim();
                String palabra = partes[1].trim();
                String pista = partes[2].trim();

                lista.add(new Palabra(categoria, palabra, pista));
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Error al leer el archivo CSV.");
        }

        return lista;
    }
}