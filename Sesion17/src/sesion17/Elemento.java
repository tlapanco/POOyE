package sesion17;

/**
 *
 * @author tl
 */
public enum Elemento {

    SELECCIONAR("-- Selecciona un elemento --"),
    FUEGO("Fuego"),
    AGUA("Agua"),
    TIERRA("Tierra"),
    AIRE("Aire"),
    ELECTRO("Electro"),
    HIELO("Hielo"),
    LUZ("Luz"),
    OSCURIDAD("Oscuridad"),
    NATURALEZA("Naturaleza"),
    METAL("Metal"),
    VENENO("Veneno");

    private final String nombre;

    Elemento(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
