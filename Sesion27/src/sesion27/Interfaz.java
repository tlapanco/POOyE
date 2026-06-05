package sesion27;

interface Saludos {

    public void saludoIngles(String nombre);

    public void saludoAleman(String nombre);

    public void saludoFrances(String nombre);
}

class SaludoPersonalizado implements Saludos {

    @Override
    public void saludoIngles(String nombre) {
        System.out.println("Hi! " + nombre + ". How's it going?");
    }

    @Override
    public void saludoAleman(String nombre) {
        System.out.println("Hallo " + nombre + "! Wie geht's?");
    }

    @Override
    public void saludoFrances(String nombre) {
        System.out.println("Bonjour " + nombre + " ! Ça va ?");
    }
}

/**
 *
 * @author tl
 */
public class Interfaz {

    public static void main() {
        Saludos saludar = new SaludoPersonalizado();

        String miNombre = "Profe";

        saludar.saludoIngles(miNombre);
        saludar.saludoAleman(miNombre);
        saludar.saludoFrances(miNombre);
    }

}
