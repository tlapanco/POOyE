/*


 */
package sesion11;

/**
 *
 * @author tl
 */
public class Mago {

    // Propiedades
    private String nombre;
    private String apodo;
    private String tipo;
    private String habilidadBasica;
    private int dañoHabilidadBasica;
    private String habilidadEspecial;
    private int dañoHabilidadEspecial;
    private String rutaAvatar;
    private int puntosDeVida;

    // Constructor
    public Mago() {

    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setHabilidadBasica(String habilidadBasica) {
        this.habilidadBasica = habilidadBasica;
    }

    public void setDañoHabilidadBasica(int dañoHabilidadBasica) {
        this.dañoHabilidadBasica = dañoHabilidadBasica;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public void setDañoHabilidadEspecial(int dañoHabilidadEspecial) {
        this.dañoHabilidadEspecial = dañoHabilidadEspecial;
    }

    public void setRutaAvatar(String rutaAvatar) {
        this.rutaAvatar = rutaAvatar;
    }

    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getApodo() {
        return this.apodo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getHabilidadBasica() {
        return this.habilidadBasica;
    }

    public int getDañoHabilidadBasica() {
        return this.dañoHabilidadBasica;
    }

    public String getHabilidadEspecial() {
        return this.habilidadEspecial;
    }

    public int getDañoHabilidadEspecial() {
        return this.dañoHabilidadEspecial;
    }

    public String getRutaAvatar() {
        return this.rutaAvatar;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}
