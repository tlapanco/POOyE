package sesion3;

import java.util.Scanner;

/**
 *
 * @author tl
 */
public class Sesion3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Objeto scanner para leer desde consola
        Scanner escaner = new Scanner(System.in);

        System.out.println("\u001B[35m╔══════════════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[35m║\u001B[0m \u001B[1m\u001B[33m" + "         Good night world Store         " + "\u001B[0m \u001B[35m║\u001B[0m");
        System.out.println("\u001B[35m╚══════════════════════════════════════════╝\u001B[0m");

        // Leer nombre del cliente
        System.out.print("  \u001B[35m→\u001B[0m Ingrese su nombre: ");
        String nombreCliente = escaner.nextLine();
        System.out.println(""); // Salto de linea
        // Saludar cliente
        System.out.println("\u001B[32m🛈\u001B[0m Hola " + nombreCliente + " bienvenido a nuestra tienda");

        // Pedir información del articulo a adquirir
        System.out.print("  \u001B[36m→\u001B[0m Ingrese el nombre del articulo: ");
        String nombreArticulo = escaner.nextLine();
        System.out.print("  \u001B[36m→\u001B[0m Ingrese la cantidad de unidades a comprar: ");
        int unidadesAComprar = Integer.parseInt(escaner.nextLine());
        System.out.print("  \u001B[36m→\u001B[0m Ingrese el precio del articulo a comprar: ");
        double precioArticulo = Double.parseDouble(escaner.nextLine());

        // Validar si hay descuento en la compra
        System.out.println("");
        boolean tieneDescuento = unidadesAComprar > 10 ? true : false;
        if (tieneDescuento) {
            System.out.println("\u001B[32m🛈\u001B[0m Felicidades " + nombreCliente + " adquiriste más de 10 unidades.");
            System.out.println("   Tienes un total del 15% de descuento !!");
        } else {
            System.out.println("\u001B[31m✘\u001B[33m Lo sentimos " + nombreCliente + " :c Las unidades adquiridas no son suficientes para un descuento");
        }

        // Espera para mostrar detalles
        System.out.println("");
        System.out.println("\u001B[33m🛈\u001B[0m Imprimiendo ticket...");
        System.out.print("   Presiona Enter ↵ para continuar.");
        String x = escaner.nextLine();

        // Mostrar detalle de compra
        System.out.println("");
        double subtotal = precioArticulo * unidadesAComprar;
        double valorDelDescuento;
        if (tieneDescuento) {
            valorDelDescuento = subtotal * .15;
        } else {
            valorDelDescuento = 0;
        }
        double total = subtotal - valorDelDescuento;
        // Mostrar detalle de compra
        System.out.println("");
        System.out.println("\u001B[35m╔══════════════════════════════════════════╗\u001B[0m");
        System.out.println("\u001B[35m║\u001B[0m        \u001B[1m--- Detalle de compra ---\u001B[0m         \u001B[35m║\u001B[0m");
        System.out.println("\u001B[35m╠══════════════════════════════════════════╣\u001B[0m");
        System.out.printf("\u001B[36m║\u001B[0m %-19s %-20s \u001B[36m║\u001B[0m%n", "Articulo:", nombreArticulo);
        System.out.printf("\u001B[36m║\u001B[0m %-19s %-20d \u001B[36m║\u001B[0m%n", "Cantidad:", unidadesAComprar);
        System.out.printf("\u001B[36m║\u001B[0m %-19s $%-19.2f \u001B[36m║\u001B[0m%n", "Subtotal:", subtotal);
        System.out.printf("\u001B[33m║\u001B[0m %-19s $%-19.2f \u001B[33m║\u001B[0m%n", "Descuento:", valorDelDescuento);
        System.out.printf("\u001B[32m║\u001B[0m %-19s $%-19.2f \u001B[32m║\u001B[0m%n", "Total:", total);
        System.out.println("\u001B[35m╚══════════════════════════════════════════╝\u001B[0m");


    }

}
