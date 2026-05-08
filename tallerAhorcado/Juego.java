import java.util.ArrayList;

public class Juego {

    private String palabraSecreta;
    private char[] estado;
    private int errores;
    private boolean pistaUsada;
    private ArrayList<Character> letrasUsadas;

    public Juego(String palabra) {
        this.palabraSecreta = palabra.toLowerCase();
        this.errores = 0;
        this.pistaUsada = false;

        estado = new char[palabra.length()];
        letrasUsadas = new ArrayList<>();

        for (int i = 0; i < estado.length; i++) {
            estado[i] = '_';
        }
    }

    public void mostrarPalabra() {
        for (char c : estado) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public boolean validarLetra(char letra) {

        letra = Character.toLowerCase(letra);

        if (letrasUsadas.contains(letra)) {
            System.out.println("Ya usaste esa letra");
            return true;
        }

        letrasUsadas.add(letra);

        boolean acierto = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                estado[i] = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            errores++;
        }

        return acierto;
    }

    public boolean estaCompleta() {
        for (char c : estado) {
            if (c == '_')
                return false;
        }
        return true;
    }

    public void mostrarAhorcado() {

        String[] dibujos = {
                """
                          +---+
                          |   |
                              |
                              |
                              |
                         =========
                        """,
                """
                          +---+
                          |   |
                          O   |
                              |
                              |
                         =========
                        """,
                """
                          +---+
                          |   |
                          O   |
                          |   |
                              |
                         =========
                        """,
                """
                          +---+
                          |   |
                          O   |
                         /|   |
                              |
                         =========
                        """,
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                              |
                         =========
                        """,
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         /    |
                         =========
                        """,
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         / \\  |
                         =========
                        """
        };

        if (errores >= 0 && errores < dibujos.length) {
            System.out.println(dibujos[errores]);
        }
    }

    public void usarPista(String pista) {
        if (!pistaUsada) {
            System.out.println("Pista: " + pista);
            errores++;
            pistaUsada = true;
        } else {
            System.out.println("Ya usaste la pista");
        }
    }

    public void revelarPrimeraLetra() {
        char primera = palabraSecreta.charAt(0);

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == primera) {
                estado[i] = primera;
            }
        }
    }

    public int getErrores() {
        return errores;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}