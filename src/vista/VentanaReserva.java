package vista;

import dao.ClienteDAO;
import dao.PaqueteDAO;
import dao.ReservaDAO;
import modelo.Cliente;
import modelo.PaqueteTuristico;
import modelo.Reserva;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class VentanaReserva extends JFrame {

    private JComboBox<Cliente> cbClientes;
    private JComboBox<PaqueteTuristico> cbPaquetes;
    private JButton btnReservar;

    public VentanaReserva() {

        setTitle("MATIK TOUR - Registrar Reserva");
        setSize(450, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // ===== ETIQUETAS =====
        JLabel lblCliente = new JLabel("Cliente:");
        JLabel lblPaquete = new JLabel("Paquete Turístico:");

        lblCliente.setBounds(40, 40, 120, 25);
        lblPaquete.setBounds(40, 100, 120, 25);

        // ===== COMBOS =====
        cbClientes = new JComboBox<>();
        cbPaquetes = new JComboBox<>();

        cbClientes.setBounds(160, 40, 230, 30);
        cbPaquetes.setBounds(160, 100, 230, 30);

        // ===== BOTÓN =====
        btnReservar = new JButton("Registrar Reserva");
        btnReservar.setBounds(120, 170, 200, 40);

        // ===== EVENTO =====
        btnReservar.addActionListener(e -> registrarReserva());

        // ===== CARGAR DATOS =====
        cargarClientes();
        cargarPaquetes();

        // ===== AGREGAR COMPONENTES =====
        add(lblCliente);
        add(cbClientes);
        add(lblPaquete);
        add(cbPaquetes);
        add(btnReservar);
    }

    // =======================
    // CARGAR CLIENTES DESDE BD
    // =======================
    private void cargarClientes() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.listarClientes();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay clientes registrados");
        }
        for (Cliente c : lista) {
            cbClientes.addItem(c);
        }
    }

    // =======================
    // CARGAR PAQUETES DESDE BD
    // =======================
    private void cargarPaquetes() {
        PaqueteDAO dao = new PaqueteDAO();
        List<PaqueteTuristico> lista = dao.listarPaquetes();

        for (PaqueteTuristico p : lista) {
            cbPaquetes.addItem(p);
        }
    }

    // =======================
    // REGISTRAR RESERVA
    // =======================
    private void registrarReserva() {

        if (cbClientes.getSelectedItem() == null ||
                cbPaquetes.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar cliente y paquete",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = (Cliente) cbClientes.getSelectedItem();
        PaqueteTuristico paquete = (PaqueteTuristico) cbPaquetes.getSelectedItem();

        Reserva reserva = new Reserva(
                cliente,
                paquete,
                new Date(),
                paquete.getPrecio()
        );

        ReservaDAO dao = new ReservaDAO();
        dao.guardarReserva(reserva);

        JOptionPane.showMessageDialog(this,
                "✅ Reserva registrada correctamente\n\n" +
                        "Cliente: " + cliente.getNombre() + "\n" +
                        "Paquete: " + paquete.getNombre() + "\n" +
                        "Total: S/ " + paquete.getPrecio()
        );
    }
}
