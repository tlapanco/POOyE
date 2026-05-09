package sesion9;

/**
 *
 * @author tl
 */
import com.formdev.flatlaf.FlatDarculaLaf;

public class Sesion9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        TarjetaDePerfil ventanaPrincipal = new TarjetaDePerfil();
        ventanaPrincipal.setVisible(true);

    }

}
