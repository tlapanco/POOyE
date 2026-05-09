package sesion7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tl
 */
public class Sesion7 {

    // 🎨 Colores ANSI
    static final String RESET = "\u001B[0m";
    static final String ROJO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String AMARILLO = "\u001B[33m";
    static final String AZUL = "\u001B[34m";
    static final String CYAN = "\u001B[36m";

    private static ArrayList<String> playlist = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(CYAN + "\n? ===== MI PLAYLIST =====" + RESET);
            System.out.println(VERDE + "1. Agregar cancion");
            System.out.println("2. Mostrar playlist");
            System.out.println("3. Eliminar cancion");
            System.out.println("4. Buscar cancion");
            System.out.println(ROJO + "0. Salir" + RESET);

            System.out.print(AMARILLO + "Opcion: " + RESET);

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 ->
                    agregar(sc);
                case 2 ->
                    mostrar();
                case 3 ->
                    eliminar(sc);
                case 4 ->
                    buscar(sc);
                case 0 ->
                    System.out.println(ROJO + "Saliendo..." + RESET);
                default ->
                    System.out.println(ROJO + " Opcin inválida" + RESET);
            }

        } while (opcion != 0);

        sc.close();
    }

    static void agregar(Scanner sc) {
        System.out.print(AZUL + "Titulo: " + RESET);
        String titulo = sc.nextLine();

        System.out.print(AZUL + "Autor: " + RESET);
        String autor = sc.nextLine();

        playlist.add(titulo + "|" + autor);

        System.out.println(VERDE + " Cancion agregada" + RESET);
    }

    static void mostrar() {
        System.out.println(CYAN + "\n PLAYLIST:" + RESET);

        if (playlist.isEmpty()) {
            System.out.println(ROJO + "No hay canciones guardadas" + RESET);
            return;
        }

        for (int i = 0; i < playlist.size(); i++) {
            String[] datos = playlist.get(i).split("\\|");

            System.out.println(AMARILLO + (i + 1) + ". " + RESET
                    + datos[0] + " - " + datos[1]);
        }
    }

    static void eliminar(Scanner sc) {
        System.out.print(AZUL + "Buscar para eliminar: " + RESET);
        String texto = sc.nextLine().toLowerCase();

        boolean eliminado = playlist.removeIf(c
                -> c.toLowerCase().contains(texto)
        );

        if (eliminado) {
            System.out.println(VERDE + "Eliminado" + RESET);
        } else {
            System.out.println(ROJO + "No encontrado" + RESET);
        }
    }

    static void buscar(Scanner sc) {
        System.out.print(AZUL + "Buscar: " + RESET);
        String texto = sc.nextLine().toLowerCase();

        boolean encontrado = false;

        System.out.println(CYAN + "\n RESULTADOS:" + RESET);

        for (String c : playlist) {
            if (c.toLowerCase().contains(texto)) {
                String[] datos = c.split("\\|");

                System.out.println(VERDE + "? " + RESET
                        + datos[0] + " - " + datos[1]);

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(ROJO + "Sin coincidencias :c" + RESET);
        }
    }

}
