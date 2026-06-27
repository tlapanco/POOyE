package sesion44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tl
 */
public class AlumnoCRUD {

    String HOST = "";
    String PUERTO = "";
    String USUARIO = "";
    String PASSWORD = "";
    String BASE_DE_DATOS = "sesion_44";
    String URL = String.format("jdbc:mysql://%s:%s/%s", HOST, PUERTO, BASE_DE_DATOS);

    Connection conexion;

    public AlumnoCRUD() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public boolean estaConectado() {
        try {
            return conexion.isValid(0);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean crearAlumno(String nombre, String apellido, int edad, String carrera, int credencial) {
        try {
            String sql = "INSERT INTO alumnos (nombre, apellido, edad, carrera, credencial) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, edad);
            ps.setString(4, carrera);
            ps.setInt(5, credencial);

            int filas = ps.executeUpdate();

            ps.close();

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarAlumno(int id, String nombre, String apellido, int edad, String carrera, int credencial) {
        try {
            String sql = "UPDATE alumnos SET nombre=?, apellido=?, edad=?, carrera=?, credencial=? WHERE id=?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, edad);
            ps.setString(4, carrera);
            ps.setInt(5, credencial);
            ps.setInt(6, id);

            int filas = ps.executeUpdate();

            ps.close();

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object[] obtenerAlumnoPorId(int id) {
        try {
            String sql = "SELECT * FROM alumnos WHERE id = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                Object[] fila = new Object[6];

                fila[0] = resultado.getInt("id");
                fila[1] = resultado.getString("nombre");
                fila[2] = resultado.getString("apellido");
                fila[3] = resultado.getInt("edad");
                fila[4] = resultado.getString("carrera");
                fila[5] = resultado.getInt("credencial");

                ps.close();
                resultado.close();

                return fila;
            }

            ps.close();
            resultado.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean eliminarAlumno(int id) {
        try {
            String sql = "DELETE FROM alumnos WHERE id=?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            ps.close();

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Object[]> obtenerAlumnos() {
        List<Object[]> alumnos = new ArrayList();

        try {
            String sentencia = "SELECT * FROM alumnos";
            PreparedStatement ps = conexion.prepareStatement(sentencia);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                Object[] fila = new Object[5];
                fila[0] = resultado.getString("id");
                fila[1] = resultado.getString("nombre") + " " + resultado.getString("apellido");
                fila[2] = resultado.getInt("edad");
                fila[3] = resultado.getString("carrera");
                fila[4] = resultado.getInt("credencial");

                alumnos.add(fila);
            }

            ps.close();
            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

}
