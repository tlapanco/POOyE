package sesion17;

/**
 *
 * @author tl
 */
public enum TipoPersonaje {

    SELECCIONAR("-- Selecciona un tipo --"),
    HEROE("Héroe"),
    VILLANO("Villano"),
    ANTIHEROE("Antihéroe"),
    MAGO("Mago"),
    GUERRERO("Guerrero"),
    ARQUERO("Arquero"),
    ASESINO("Asesino"),
    TANQUE("Tanque"),
    SOPORTE("Soporte"),
    CURANDERO("Curandero"),
    INVOCADOR("Invocador"),
    BESTIA("Bestia"),
    ROBOT("Robot"),
    HUMANO("Humano"),
    ELFO("Elfo"),
    ORCO("Orco"),
    NO_MUERTO("No muerto"),
    DRAGON("Dragón"),
    DEMONIO("Demonio"),
    ANGEL("Ángel");

    private final String nombre;

    TipoPersonaje(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
