package sesion17;

public class Creador {

    private static int contadorCreadores = 0;

    private int idCreador;
    private String nombre;
    private String apellidos;

    public Creador(String nombre, String apellidos) {
        this.idCreador = contadorCreadores++;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public static int getSiguienteId() {
        return contadorCreadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return idCreador + " - " + nombre + " " + apellidos;
    }

}
