package vista;

import dao.ClienteDAO;
import dao.PaqueteDAO;
import dao.ReservaDAO;
import modelo.Cliente;
import modelo.PaqueteTuristico;
import modelo.Reserva;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class VentanaPrincipal extends JFrame {

    private JComboBox<Cliente> cbClientes;
    private JComboBox<PaqueteTuristico> cbPaquetes;
    private DefaultTableModel modeloTabla;

    public VentanaPrincipal() {

        setTitle("MATIK TOUR - Sistema de Reservas");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        modeloTabla = new DefaultTableModel(
                new String[]{"ID","Destino","Días","Precio"}, 0);

        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20,20,650,150);
        add(scroll);

        cbClientes = new JComboBox<>();
        cbClientes.setBounds(20,190,250,30);
        add(cbClientes);

        cbPaquetes = new JComboBox<>();
        cbPaquetes.setBounds(300,190,250,30);
        add(cbPaquetes);

        JButton btnNuevoCliente = new JButton("Nuevo Cliente");
        btnNuevoCliente.setBounds(20,240,150,30);
        add(btnNuevoCliente);

        btnNuevoCliente.addActionListener(e ->
                new VentanaCliente(this).setVisible(true)
        );

        JButton btnReservar = new JButton("Registrar Reserva");
        btnReservar.setBounds(250,240,200,40);
        add(btnReservar);

        btnReservar.addActionListener(e -> registrarReserva());

        cargarClientes();
        cargarPaquetes();
    }

    public void cargarClientes() {
        cbClientes.removeAllItems();
        ClienteDAO dao = new ClienteDAO();
        for (Cliente c : dao.listarClientes()) {
            cbClientes.addItem(c);
        }
    }

    private void cargarPaquetes() {
        PaqueteDAO dao = new PaqueteDAO();
        modeloTabla.setRowCount(0);
        cbPaquetes.removeAllItems();

        for (PaqueteTuristico p : dao.listarPaquetes()) {
            modeloTabla.addRow(new Object[]{
                    p.getId(), p.getNombre(), p.getDias(), p.getPrecio()
            });
            cbPaquetes.addItem(p);
        }
    }

    private void registrarReserva() {
        Cliente c = (Cliente) cbClientes.getSelectedItem();
        PaqueteTuristico p = (PaqueteTuristico) cbPaquetes.getSelectedItem();

        if (c == null || p == null) {
            JOptionPane.showMessageDialog(this,"Debe seleccionar cliente y paquete");
            return;
        }

        new ReservaDAO().guardarReserva(
                new Reserva(c,p,new Date(),p.getPrecio())
        );

        JOptionPane.showMessageDialog(this,"Reserva registrada");
    }
}
