import java.util.Scanner;

public class ConsoleInput {

    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje) {

        System.out.print(mensaje);
        return sc.nextLine();
    }

    public static int leerInt(String mensaje) {

        int valor;

        while (true) {

            try {

                System.out.print(mensaje);
                valor = Integer.parseInt(sc.nextLine());

                return valor;

            } catch (NumberFormatException e) {

                System.out.println("Debes ingresar un número válido.");
            }
        }
    }

    public static char leerChar(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                String input = sc.nextLine();

                if (input.length() != 1) {

                    System.out.println("Ingresa solo un carácter.");
                    continue;
                }

                return input.charAt(0);

            } catch (Exception e) {

                System.out.println("Error al leer carácter.");
            }
        }
    }
}