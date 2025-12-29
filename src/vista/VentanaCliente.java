package vista;

import dao.ClienteDAO;
import modelo.Cliente;

import javax.swing.*;

public class VentanaCliente extends JFrame {

    public VentanaCliente(VentanaPrincipal vp) {

        setTitle("Nuevo Cliente");
        setSize(320, 330);
        setLocationRelativeTo(null);
        setLayout(null);

        // ====== ETIQUETAS ======
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblDni = new JLabel("DNI:");
        JLabel lblTel = new JLabel("Teléfono:");
        JLabel lblEmail = new JLabel("Email:");

        lblNombre.setBounds(20, 10, 100, 20);
        lblDni.setBounds(20, 50, 100, 20);
        lblTel.setBounds(20, 90, 100, 20);
        lblEmail.setBounds(20, 130, 100, 20);

        add(lblNombre);
        add(lblDni);
        add(lblTel);
        add(lblEmail);

        // ====== CAMPOS DE TEXTO ======
        JTextField txtNombre = new JTextField();
        JTextField txtDni = new JTextField();
        JTextField txtTel = new JTextField();
        JTextField txtEmail = new JTextField();

        txtNombre.setBounds(20, 30, 260, 25);
        txtDni.setBounds(20, 70, 260, 25);
        txtTel.setBounds(20, 110, 260, 25);
        txtEmail.setBounds(20, 150, 260, 25);

        add(txtNombre);
        add(txtDni);
        add(txtTel);
        add(txtEmail);

        // ====== BOTÓN ======
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 210, 120, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            Cliente c = new Cliente(
                    0,
                    txtNombre.getText(),
                    txtDni.getText(),
                    txtTel.getText(),
                    txtEmail.getText()
            );

            new ClienteDAO().insertarCliente(c);
            vp.cargarClientes();
            dispose();
        });
    }
}

