package sesion1;

import java.util.Arrays;

/**
 *
 * @author tl
 */
public class Sesion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Cadena a evaluar
        String textoOriginal = "Tres tristes tigres tragaban trigo en un trigal";
        System.out.println("Texto original: " + textoOriginal);

        // Obtener la longitud del texto
        int longitud = textoOriginal.length();
        System.out.println("El texto tiene una longitud de: " + longitud);

        // Convertir texto en mayúsculas
        String textoEnMayusculas = textoOriginal.toUpperCase();
        System.out.println("El texto en mayúsculas es: " + textoEnMayusculas);

        // Convertir texto en minúsculas
        String textoEnMinusculas = textoOriginal.toLowerCase();
        System.out.println("El texto en minúsculas es: " + textoEnMinusculas);

        // Verificar si el texto tiene espacios al inicio o final
        String textoSinEspacios = textoOriginal.trim();
        boolean tieneEspacios = !textoOriginal.equals(textoSinEspacios);
        System.out.println("El texto original tiene espacios: " + tieneEspacios);

        // Reemplazar una cadena en el texto
        String cadenaAReemplazar = "tigres";
        String cadenaDeReemplazo = "vacas";
        String textoConCadenaReemplazada = textoOriginal.replace(cadenaAReemplazar, cadenaDeReemplazo);
        System.out.println("El texto con cadena reemplazada es: " + textoConCadenaReemplazada);

        // Evaluar si el texto inicia con un prefijo dado
        String prefijo = "Tres";
        boolean iniciaConElPrefijo = textoOriginal.startsWith(prefijo);
        System.out.println("El texto inicia con el prefijo dado: " + iniciaConElPrefijo);

        //Evaluar si el texto termina con un sufijo dado
        String sufijo = "granero";
        boolean terminaConElSufijo = textoOriginal.endsWith(sufijo);
        System.out.println("El texto termina con el sufijo dado: " + terminaConElSufijo);

        // Dividir el texto a partir de un separador
        String separador = " ";
        String textoDividido = Arrays.toString(textoOriginal.split(separador));
        System.out.println("El texto divido por el separador dado es: " + textoDividido);
    }

}
