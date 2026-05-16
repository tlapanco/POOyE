/*


 */
package sesion13;

import com.formdev.flatlaf.FlatDarculaLaf;

/**
 *
 * @author tl
 */
public class Sesion13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FlatDarculaLaf.setup();
        Mago magoFuego = new Mago();
        
        magoFuego.setNombre("Ignus");
        magoFuego.setApodo("El Destructor");
        magoFuego.setTipo(TipoMago.FUEGO);
        magoFuego.setHabilidadBasica("Bola de Fuego");
        magoFuego.setDañoHabilidadBasica(25);
        magoFuego.setHabilidadEspecial("Lluvia Infernal");
        magoFuego.setDañoHabilidadEspecial(60);
        magoFuego.setTurnosRecargaEspecial(3);
        magoFuego.setRutaAvatar("avatars/mago_fuego.png");
        magoFuego.setPuntosDeVida(120);
        magoFuego.setVidaMaxima(120);
        
        Mago magoAgua = new Mago();
        
        magoAgua.setNombre("Aqualis");
        magoAgua.setApodo("La Guardiana del Océano");
        magoAgua.setTipo(TipoMago.AGUA);
        magoAgua.setHabilidadBasica("Chorro Marino");
        magoAgua.setDañoHabilidadBasica(20);
        magoAgua.setHabilidadEspecial("Tsunami Ancestral");
        magoAgua.setDañoHabilidadEspecial(55);
        magoAgua.setTurnosRecargaEspecial(2);
        magoAgua.setRutaAvatar("avatars/mago_agua.png");
        magoAgua.setPuntosDeVida(130);
        magoAgua.setVidaMaxima(130);
        
        BatallaMago ventanaPrincipal = new BatallaMago(magoAgua, magoFuego);
        ventanaPrincipal.setVisible(true);
    }
    
}
