package sesion27;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (edad < 18) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 18 años.");
        }

        if (salario <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor que cero.");
        }

        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre
                + "\nEdad: " + edad
                + "\nSalario: $" + salario;
    }
}

public class Excepcion extends JFrame {

    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtSalario;
    private JTextArea txtResultado;
    private JButton btnRegistrar;

    public Excepcion() {

        setTitle("Registro de Empleados");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panel.add(txtEdad);

        panel.add(new JLabel("Salario:"));
        txtSalario = new JTextField();
        panel.add(txtSalario);

        btnRegistrar = new JButton("Registrar Empleado");
        panel.add(btnRegistrar);

        JButton btnLimpiar = new JButton("Limpiar");
        panel.add(btnLimpiar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtNombre.setText("");
            txtEdad.setText("");
            txtSalario.setText("");
            txtResultado.setText("");
        });
    }

    private void registrarEmpleado() {

        try {

            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            double salario = Double.parseDouble(txtSalario.getText());

            Empleado emp = new Empleado(nombre, edad, salario);

            txtResultado.setText(
                    "Registro exitoso\n\n"
                    + emp.toString()
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Edad o salario deben ser numéricos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE
            );

        } finally {
            //Siempre se ejecuta independientemente si hubo una excepción o no
            System.out.println("Proceso de registro terminado.");
        }
    }

    public static void main() {

        SwingUtilities.invokeLater(() -> {
            //new Excepcion().setVisible(true);
        });
    }
}
