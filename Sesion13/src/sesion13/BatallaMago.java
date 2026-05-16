/*


 */
package sesion13;

import java.awt.Dimension;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author tl
 */
public class BatallaMago extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BatallaMago.class.getName());
    private Mago mago1;
    private Mago mago2;

    private int turnosJ1 = 0;
    private int turnosJ2 = 0;

    /**
     * Creates new form PeleaMagos
     */
    public BatallaMago() {
        initComponents();
    }

    public BatallaMago(Mago mago1, Mago mago2) {
        setUndecorated(true);
        initComponents();
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30)); // Bordes redondeados
        setLocationRelativeTo(null);

        this.mago1 = mago1;
        this.mago2 = mago2;

        cargarInterfaz();
        eventos();
    }

    private void atacar(Mago atacante, Mago defensor, int jugador) {

        btnAtacarJ1.setEnabled(false);
        btnAtacarJ2.setEnabled(false);

        new Thread(() -> {

            try {

                String habilidad;
                int daño;

                // DETERMINAR ATAQUE
                if (jugador == 1) {

                    if (atacante.getUsaHabilidadEspecial(turnosJ1) && turnosJ1 > 0) {
                        habilidad = atacante.getHabilidadEspecial();
                        daño = atacante.getDañoHabilidadEspecial();
                    } else {
                        habilidad = atacante.getHabilidadBasica();
                        daño = atacante.getDañoHabilidadBasica();
                    }
                    turnosJ1++;

                } else {

                    if (atacante.getUsaHabilidadEspecial(turnosJ2) && turnosJ2 > 0) {
                        habilidad = atacante.getHabilidadEspecial();
                        daño = atacante.getDañoHabilidadEspecial();
                    } else {
                        habilidad = atacante.getHabilidadBasica();
                        daño = atacante.getDañoHabilidadBasica();
                    }
                    turnosJ2++;
                }

                // MOSTRAR MENSAJE
                String mensaje = atacante.getNombre() + " usa " + habilidad;

                javax.swing.SwingUtilities.invokeLater(() -> {

                    if (jugador == 1) {
                        lblHabilidadJ1.setText(mensaje);
                    } else {
                        lblHabilidadJ2.setText(mensaje);
                    }

                });

                // ESPERA ANTES DEL DAÑO
                Thread.sleep(500);

                // VIDA ANTES DEL ATAQUE
                int vidaAnterior = defensor.getPuntosDeVida();

                // NUEVA VIDA
                int nuevaVida = vidaAnterior - daño;

                if (nuevaVida < 0) {
                    nuevaVida = 0;
                }

                defensor.setPuntosDeVida(nuevaVida);

                // SELECCIONAR BARRA
                javax.swing.JProgressBar barraVida;

                if (jugador == 1) {
                    barraVida = pbVidaJ2;
                } else {
                    barraVida = pbVidaJ1;
                }

                // ANIMACIÓN DE VIDA
                for (int i = vidaAnterior; i >= nuevaVida; i--) {

                    int valor = i;

                    javax.swing.SwingUtilities.invokeLater(() -> {

                        barraVida.setValue(valor);
                        barraVida.setString(valor + " HP");

                    });

                    Thread.sleep(15);
                }

                // ESPERA FINAL
                Thread.sleep(600);

                // LIMPIAR TEXTO
                javax.swing.SwingUtilities.invokeLater(() -> {

                    lblHabilidadJ1.setText("");
                    lblHabilidadJ2.setText("");

                });

                // VALIDAR GANADOR
                if (nuevaVida <= 0) {

                    javax.swing.SwingUtilities.invokeLater(() -> {

                        javax.swing.JOptionPane.showMessageDialog(
                                this,
                                atacante.getNombre() + " gana la batalla"
                        );

                        System.exit(0); // Terminar juego

                    });

                } else {

                    // REACTIVAR BOTONES
                    javax.swing.SwingUtilities.invokeLater(() -> {

                        btnAtacarJ1.setEnabled(true);
                        btnAtacarJ2.setEnabled(true);

                    });
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }).start();
    }

    private void reiniciarBatalla() {

        // Reset vida
        mago1.setPuntosDeVida(mago1.getVidaMaxima());
        mago2.setPuntosDeVida(mago2.getVidaMaxima());

        // Reset turnos
        turnosJ1 = 0;
        turnosJ2 = 0;

        // Reset barras
        pbVidaJ1.setValue(mago1.getPuntosDeVida());
        pbVidaJ1.setString(mago1.getPuntosDeVida() + " HP");

        pbVidaJ2.setValue(mago2.getPuntosDeVida());
        pbVidaJ2.setString(mago2.getPuntosDeVida() + " HP");

        // Limpia mensajes
        lblHabilidadJ1.setText(" ");
        lblHabilidadJ2.setText(" ");

        // Reactivar botones
        btnAtacarJ1.setEnabled(true);
        btnAtacarJ2.setEnabled(true);

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Batalla reiniciada"
        );
    }

    private void eventos() {

        btnAtacarJ1.addActionListener(e -> atacar(mago1, mago2, 1));

        btnAtacarJ2.addActionListener(e -> atacar(mago2, mago1, 2));
    }

    private void cargarInterfaz() {

        lblAvatarJ1.setIcon(
                escalarImagen(
                        "/sesion13/" + mago1.getRutaAvatar(),
                        200,
                        250
                )
        );

        lblAvatarJ2.setIcon(
                escalarImagen(
                        "/sesion13/" + mago2.getRutaAvatar(),
                        200,
                        250
                )
        );

        pbVidaJ1.setMinimum(0);
        pbVidaJ2.setMinimum(0);

        pbVidaJ1.setMaximum(mago1.getPuntosDeVida());
        pbVidaJ2.setMaximum(mago2.getPuntosDeVida());

        pbVidaJ1.setValue(mago1.getPuntosDeVida());
        pbVidaJ2.setValue(mago2.getPuntosDeVida());

        pbVidaJ1.setString(mago1.getPuntosDeVida() + " HP");
        pbVidaJ2.setString(mago2.getPuntosDeVida() + " HP");

        pbVidaJ1.setStringPainted(true);
        pbVidaJ2.setStringPainted(true);

        aplicarTema(
                mago1,
                panelJugador1,
                btnAtacarJ1,
                pbVidaJ1,
                lblHabilidadJ1
        );

        aplicarTema(
                mago2,
                panelJugador2,
                btnAtacarJ2,
                pbVidaJ2,
                lblHabilidadJ2
        );

        panelJugador1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelJugador2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblAvatarJ1.setPreferredSize(new java.awt.Dimension(200, 250));
        lblAvatarJ2.setPreferredSize(new java.awt.Dimension(200, 250));

        lblAvatarJ1.setMinimumSize(new java.awt.Dimension(200, 250));
        lblAvatarJ2.setMinimumSize(new java.awt.Dimension(200, 250));

        lblAvatarJ1.setMaximumSize(new java.awt.Dimension(200, 250));
        lblAvatarJ2.setMaximumSize(new java.awt.Dimension(200, 250));

        Dimension tamañoHabilidad = new java.awt.Dimension(300, 40);

        lblHabilidadJ1.setPreferredSize(tamañoHabilidad);
        lblHabilidadJ1.setMinimumSize(tamañoHabilidad);
        lblHabilidadJ1.setMaximumSize(tamañoHabilidad);

        lblHabilidadJ2.setPreferredSize(tamañoHabilidad);
        lblHabilidadJ2.setMinimumSize(tamañoHabilidad);
        lblHabilidadJ2.setMaximumSize(tamañoHabilidad);

        lblHabilidadJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHabilidadJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblHabilidadJ1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        lblHabilidadJ2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        lblHabilidadJ1.setText(" ");
        lblHabilidadJ2.setText(" ");
    }

    private void aplicarTema(
            Mago mago,
            javax.swing.JPanel panel,
            javax.swing.JButton boton,
            javax.swing.JProgressBar barra,
            javax.swing.JLabel lblHabilidad
    ) {

        java.awt.Color colorPrincipal;
        java.awt.Color colorTexto = java.awt.Color.WHITE;

        switch (mago.getTipo()) {

            case TipoMago.FUEGO:

                colorPrincipal = new java.awt.Color(220, 60, 30);
                break;

            case TipoMago.AGUA:

                colorPrincipal = new java.awt.Color(30, 144, 255);
                break;

            case TipoMago.LUZ:

                colorPrincipal = new java.awt.Color(255, 215, 0);
                colorTexto = java.awt.Color.BLACK;
                break;

            case TipoMago.OSCURIDAD:

                colorPrincipal = new java.awt.Color(80, 0, 120);
                break;

            default:

                colorPrincipal = java.awt.Color.GRAY;
                break;
        }

        // PANEL
        panel.setBackground(colorPrincipal.darker());

        // BOTÓN
        boton.setBackground(colorPrincipal);
        boton.setForeground(colorTexto);
        boton.setFocusPainted(false);

        // BARRA DE VIDA
        barra.setForeground(colorPrincipal);
        barra.setBackground(java.awt.Color.DARK_GRAY);
        barra.setStringPainted(true);

        // LABEL HABILIDAD
        lblHabilidad.setForeground(colorPrincipal.brighter());
    }

    private javax.swing.ImageIcon escalarImagen(String ruta, int ancho, int alto) {

        java.net.URL url = getClass().getResource(ruta);

        if (url == null) {
            System.out.println("No se encontró la imagen: " + ruta);
            return null;
        }

        java.awt.Image img = new javax.swing.ImageIcon(url).getImage();

        java.awt.Image imgEscalada = img.getScaledInstance(
                ancho,
                alto,
                java.awt.Image.SCALE_SMOOTH
        );

        return new javax.swing.ImageIcon(imgEscalada);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJugador1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCerrar1 = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lblAvatarJ1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lblHabilidadJ1 = new javax.swing.JLabel();
        pbVidaJ1 = new javax.swing.JProgressBar();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btnAtacarJ1 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        panelJugador2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lblAvatarJ2 = new javax.swing.JLabel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lblHabilidadJ2 = new javax.swing.JLabel();
        pbVidaJ2 = new javax.swing.JProgressBar();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btnAtacarJ2 = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelJugador1.setLayout(new javax.swing.BoxLayout(panelJugador1, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setMaximumSize(new java.awt.Dimension(420, 39));
        jPanel3.setMinimumSize(new java.awt.Dimension(200, 39));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 39));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnCerrar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrar1.setText("Reiniciar");
        btnCerrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar1.addActionListener(this::btnCerrar1ActionPerformed);
        jPanel3.add(btnCerrar1);

        panelJugador1.add(jPanel3);
        panelJugador1.add(filler3);

        lblAvatarJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatarJ1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblAvatarJ1.setAlignmentX(0.5F);
        panelJugador1.add(lblAvatarJ1);
        panelJugador1.add(filler1);

        lblHabilidadJ1.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        lblHabilidadJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHabilidadJ1.setAlignmentX(0.5F);
        panelJugador1.add(lblHabilidadJ1);

        pbVidaJ1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        panelJugador1.add(pbVidaJ1);
        panelJugador1.add(filler4);

        btnAtacarJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAtacarJ1.setText("Atacar");
        btnAtacarJ1.setAlignmentX(0.5F);
        btnAtacarJ1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtacarJ1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelJugador1.add(btnAtacarJ1);
        panelJugador1.add(filler2);

        getContentPane().add(panelJugador1);

        panelJugador2.setLayout(new javax.swing.BoxLayout(panelJugador2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(420, 39));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 39));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 39));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrar.setText("X");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.addActionListener(this::btnCerrarActionPerformed);
        jPanel2.add(btnCerrar);

        panelJugador2.add(jPanel2);
        panelJugador2.add(filler5);

        lblAvatarJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvatarJ2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblAvatarJ2.setAlignmentX(0.5F);
        panelJugador2.add(lblAvatarJ2);
        panelJugador2.add(filler7);

        lblHabilidadJ2.setBackground(new java.awt.Color(255, 0, 102));
        lblHabilidadJ2.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        lblHabilidadJ2.setAlignmentX(0.5F);
        panelJugador2.add(lblHabilidadJ2);

        pbVidaJ2.setFont(new java.awt.Font("Sitka Text", 2, 18)); // NOI18N
        panelJugador2.add(pbVidaJ2);
        panelJugador2.add(filler8);

        btnAtacarJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAtacarJ2.setText("Atacar");
        btnAtacarJ2.setAlignmentX(0.5F);
        btnAtacarJ2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelJugador2.add(btnAtacarJ2);
        panelJugador2.add(filler6);

        getContentPane().add(panelJugador2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed
        // TODO add your handling code here:
        reiniciarBatalla();
    }//GEN-LAST:event_btnCerrar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new BatallaMago().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtacarJ1;
    private javax.swing.JButton btnAtacarJ2;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCerrar1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAvatarJ1;
    private javax.swing.JLabel lblAvatarJ2;
    private javax.swing.JLabel lblHabilidadJ1;
    private javax.swing.JLabel lblHabilidadJ2;
    private javax.swing.JPanel panelJugador1;
    private javax.swing.JPanel panelJugador2;
    private javax.swing.JProgressBar pbVidaJ1;
    private javax.swing.JProgressBar pbVidaJ2;
    // End of variables declaration//GEN-END:variables
}
