package vista;

import dao.UsuarioDAO;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {

    // ===== VARIABLES DE CLASE =====
    private JTextField txtUsuario;
    private JPasswordField txtClave;

    public VentanaLogin() {

        setTitle("Login - MATIK TOUR");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        panel.add(txtUsuario);

        panel.add(new JLabel("Clave:"));
        txtClave = new JPasswordField();   // 👈 AQUÍ SE CREA
        panel.add(txtClave);

        JButton btnLogin = new JButton("Ingresar");
        panel.add(new JLabel());
        panel.add(btnLogin);

        add(panel, BorderLayout.CENTER);

        btnLogin.addActionListener(e -> login());
    }

    private void login() {

        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword()); // 👈 AQUÍ SE USA

        UsuarioDAO dao = new UsuarioDAO();

        if (dao.validarLogin(usuario, clave)) {
            this.dispose();
            new VentanaPrincipal().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Usuario o clave incorrectos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
