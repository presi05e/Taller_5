import java.util.Scanner;

public class ConsoleInput {

    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public static int leerInt(String mensaje) {
        System.out.print(mensaje);
        int valor = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        return valor;
    }

    public static char leerChar(String mensaje) {
        System.out.print(mensaje);
        return sc.next().charAt(0);
    }
}
