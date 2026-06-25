package sesion43;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author tl
 */
public class Sesion43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String HOST = "localhost";
        String PUERTO = "3306";
        String USUARIO = "root";
        String PASSWORD = "";
        String BASE_DE_DATOS = "sesion_44";
        String URL = String.format("jdbc:mysql://%s:%s/%s", HOST, PUERTO, BASE_DE_DATOS);

        try {
            Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            JOptionPane.showMessageDialog(null, "✅ Conexión exitosa a MySQL", "Exito", JOptionPane.INFORMATION_MESSAGE);

            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de conexión:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
