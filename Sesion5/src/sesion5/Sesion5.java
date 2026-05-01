package sesion5;

import java.util.ArrayList;
import java.util.Scanner;

public class Sesion5 {

    public static void main(String[] args) {

        // Códigos de color ANSI
        final String PURPLE = "\u001B[35m";
        final String CYAN = "\u001B[36m";
        final String YELLOW = "\u001B[33m";
        final String GREEN = "\u001B[32m";
        final String RESET = "\u001B[0m";
        final String BOLD = "\u001B[1m";

        Scanner sc = new Scanner(System.in);
        ArrayList<String[]> libros = new ArrayList<>();
        int opcion;

        // Título
        System.out.println(PURPLE + "╔══════════════════════════════════════════╗" + RESET);
        System.out.println(PURPLE + "║" + RESET + " " + BOLD + YELLOW + "     Biblioteca de Libros Favoritos     " + RESET + " " + PURPLE + "║" + RESET);
        System.out.println(PURPLE + "╚══════════════════════════════════════════╝" + RESET);

        do {
            System.out.println("\n" + PURPLE + "╔═════════════════════════════╗" + RESET);
            System.out.println(PURPLE + "║" + RESET + "        " + BOLD + "MENÚ PRINCIPAL" + RESET + "       " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "╠═════════════════════════════╣" + RESET);

            System.out.println(PURPLE + "║" + RESET + "  1. Agregar libro           " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "║" + RESET + "  2. Ver libros favoritos    " + PURPLE + "║" + RESET);
            System.out.println(PURPLE + "║" + RESET + "  3. Salir                   " + PURPLE + "║" + RESET);

            System.out.println(PURPLE + "╚═════════════════════════════╝" + RESET);
            System.out.print("  " + PURPLE + "→" + RESET + " Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("");
                    System.out.println(GREEN + "🛈 " + RESET + "Ingrese datos del libro:");
                    System.out.print("  " + CYAN + "→" + RESET + " Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("  " + CYAN + "→" + RESET + " Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("  " + CYAN + "→" + RESET + " Año: ");
                    String año = sc.nextLine();

                    libros.add(new String[]{titulo, autor, año});
                    System.out.println("");
                    System.out.println("  " + GREEN + "✔ Libro agregado exitosamente" + RESET);
                    break;

                case 2:
                    if (libros.isEmpty()) {
                        System.out.println("");
                        System.out.println("  " + YELLOW + "📭 No hay libros aún." + RESET);
                    } else {
                        System.out.println("\n" + PURPLE + "╔══════════════════════════════════════════╗" + RESET);
                        System.out.println(PURPLE + "║" + RESET + "           " + BOLD + "TUS LIBROS FAVORITOS" + RESET + "           " + PURPLE + "║" + RESET);
                        System.out.println(PURPLE + "╠══════════════════════════════════════════╣" + RESET);

                        for (String[] libro : libros) {
                            System.out.printf(PURPLE + "║ " + RESET + "%-41s" + PURPLE + "║%n", "Titulo: " + libro[0]);
                            System.out.printf(PURPLE + "║ " + RESET + "%-41s" + PURPLE + "║%n", "Autor: " + libro[1]);
                            System.out.printf(PURPLE + "║ " + RESET + "%-41s" + PURPLE + "║%n", "Año: " + libro[2]);
                            System.out.println(PURPLE + "╠══════════════════════════════════════════╣" + RESET);
                        }

                        System.out.println(PURPLE + "╚══════════════════════════════════════════╝" + RESET);
                    }
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("  " + CYAN + "↫ ¡Hasta pronto!" + RESET);
                    System.out.println("8");
                    break;

                default:
                    System.out.println("");
                    System.out.println("  " + YELLOW + "⚠ Opción inválida" + RESET);
            }

        } while (opcion != 3);
    }
}
