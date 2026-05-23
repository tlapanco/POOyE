/*


 */
package sesion17;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 *
 * @author tl
 */
public class Sesion17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        
        AdministradorPersonajes ventanaPrincipal = new AdministradorPersonajes();
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }
    
}
