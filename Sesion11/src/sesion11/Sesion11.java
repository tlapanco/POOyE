package sesion11;

/**
 *
 * @author tl
 */
public class Sesion11 {

    // Códigos de color ANSI
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mago objetoMago = new Mago();

        // Asignar valores a propiedades del objeto
        objetoMago.setNombre("Pedro Santos");
        objetoMago.setApodo("Pedri el mago");
        objetoMago.setTipo(TipoMago.AGUA);
        objetoMago.setHabilidadBasica("Cañon de agua");
        objetoMago.setDañoHabilidadBasica(10);
        objetoMago.setHabilidadEspecial("Maremoto");
        objetoMago.setDañoHabilidadEspecial(30);
        objetoMago.setRutaAvatar("pedri-el-mago.png");
        objetoMago.setPuntosDeVida(100);

        TarjetaMago ventanaTarjetaMago = new TarjetaMago(objetoMago);
        ventanaTarjetaMago.setVisible(true);

        System.out.println(PURPLE + "=== Objeto Mago ===\n");
        System.out.println(GREEN + "Nombre: " + RESET + objetoMago.getNombre());
        System.out.println(GREEN + "Apodo: " + RESET + objetoMago.getApodo());
        System.out.println(GREEN + "Tipo: " + RESET + objetoMago.getTipo());
        System.out.println(GREEN + "Habilidad básica: " + RESET + objetoMago.getHabilidadBasica());
        System.out.println(GREEN + "Daño (básica): " + RESET + objetoMago.getDañoHabilidadBasica() + " pts");
        System.out.println(GREEN + "Habilidad especial: " + RESET + objetoMago.getHabilidadEspecial());
        System.out.println(GREEN + "Daño (especial): " + RESET + objetoMago.getDañoHabilidadEspecial() + " pts");
        System.out.println(GREEN + "Avatar: " + RESET + objetoMago.getRutaAvatar());
    }

}
