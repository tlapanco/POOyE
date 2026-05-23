/*


 */
package sesion17;

/**
 *
 * @author tl
 */
public class Personaje {

    private String nombre;
    private Elemento elemento;
    private String avatar;
    private String apodo;
    private TipoPersonaje tipo;
    private int idCreador;

    public Personaje(String nombre, Elemento elemento, String avatar, String apodo, TipoPersonaje tipo, int idCreador) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.avatar = avatar;
        this.apodo = apodo;
        this.tipo = tipo;
        this.idCreador = idCreador;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public TipoPersonaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoPersonaje tipo) {
        this.tipo = tipo;
    }

}
