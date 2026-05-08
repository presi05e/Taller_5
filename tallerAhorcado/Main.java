import java.util.*;

public class Main {

    public static void mostrarMenu() {
       System.out.println("""
 /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\
//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\
\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//
//\\\\ \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/ //\\\\
\\\\//                                                        \\\\//
 \\/                                                          \\/
 /\\                    JUEGO DEL AHORCADO                    /\\
//\\\\                                                        //\\\\
\\\\//                                                        \\\\//
//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\
\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//
//\\\\                                                        //\\\\
\\\\//                      1. Jugar                          \\\\//
//\\\\                      2. Instrucciones                  //\\\\
\\\\//                      3. Salir                          \\\\//
//\\\\                                                        //\\\\
\\\\//                                                        \\\\//
 \\/                                                          \\/
 /\\                                                          /\\
//\\\\                                                        //\\\\
\\\\// /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\  /\\ \\\\//
//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\
\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//\\\\//
 \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/  \\/
""");
    }

    public static ArrayList<String> obtenerCategorias(ArrayList<Palabra> lista) {
        HashSet<String> set = new HashSet<>();
        for (Palabra p : lista) {
            set.add(p.getCategoria());
        }
        return new ArrayList<>(set);
    }

    public static ArrayList<Palabra> filtrarPorCategoria(ArrayList<Palabra> lista, String categoria) {
        ArrayList<Palabra> filtrada = new ArrayList<>();
        for (Palabra p : lista) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                filtrada.add(p);
            }
        }
        return filtrada;
    }

    public static boolean verificarEasterEgg(String nombre) {
        return nombre.equals("DIOS");
    }

    public static void jugar(ArrayList<Palabra> lista) {

        String nombre;

        do {

            nombre = ConsoleInput.leerString("Ingresa tu nombre: ").trim();

            if (nombre.isEmpty()) {
                System.out.println("⚠️ El nombre no puede estar vacío.");
            }

        } while (nombre.isEmpty());

        boolean modoDios = verificarEasterEgg(nombre);

        ArrayList<String> categorias = obtenerCategorias(lista);
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
            return;
        }

        if (!modoDios) {
            categorias.remove("SECRETOS");
        } else {
            System.out.println("""
                     MODO DIOS ACTIVADO
                    ██████╗ ██████╗ ██████╗
                    ██╔══██╗██╔══██╗██╔══██╗
                    ██████╔╝██████╔╝██████╔╝
                    ██╔═══╝ ██╔═══╝ ██╔═══╝
                    ██║     ██║     ██║
                    ╚═╝     ╚═╝     ╚═╝
                    """);
        }

        System.out.println("\nSelecciona una categoría:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i));
        }

        int opcion = ConsoleInput.leerInt("Opción: ");

        if (opcion < 1 || opcion > categorias.size()) {
            System.out.println("Opción inválida");
            return;
        }

        String categoriaElegida = categorias.get(opcion - 1);

        ArrayList<Palabra> filtradas = filtrarPorCategoria(lista, categoriaElegida);
        if (filtradas.isEmpty()) {
            System.out.println("No hay palabras en esta categoría.");
            return;
        }

        Random rand = new Random();
        Palabra seleccion = filtradas.get(rand.nextInt(filtradas.size()));

        Juego juego = new Juego(seleccion.getPalabra());

        if (modoDios) {
            juego.revelarPrimeraLetra();
        }

        while (juego.getErrores() < 6 && !juego.estaCompleta()) {

            juego.mostrarAhorcado();
            juego.mostrarPalabra();

            String input = ConsoleInput.leerString("Letra o 'pista': ").trim();

            if (input.isEmpty()) {
                System.out.println("Debes ingresar algo.");
                continue;
            }

            if (input.equalsIgnoreCase("pista")) {
                juego.usarPista(seleccion.getPista());
                continue;
            }

            if (input.length() > 1 && !input.equalsIgnoreCase("pista")) {
                System.out.println("Ingresa solo una letra.");
                continue;
            }
            char letra = input.charAt(0);
            if (!Character.isLetter(letra)) {
                System.out.println("Solo puedes ingresar letras.");
                continue;
            }

            if (juego.validarLetra(letra)) {
                System.out.println("Correcto");
            } else {
                System.out.println("Incorrecto");
            }
        }

        if (juego.estaCompleta()) {
            System.out.println("\u001B[32m GANASTE\u001B[0m");
        } else {
            System.out.println("\u001B[31m PERDISTE\u001B[0m");
            System.out.println("Palabra: " + seleccion.getPalabra());
        }
    }

    public static void main(String[] args) {

        ArrayList<Palabra> lista = CargadorCSV.cargarPalabras();
        System.out.println("Cantidad de palabras cargadas: " + lista.size());

        int opcion;

        do {
            mostrarMenu();
            opcion = ConsoleInput.leerInt("Opción: ");

            switch (opcion) {
                case 1 -> jugar(lista);
                case 2 -> System.out.println("Adivina la palabra antes de morir.");
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 3);
    }
}
