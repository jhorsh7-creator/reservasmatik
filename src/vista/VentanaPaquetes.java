package vista;

import dao.PaqueteDAO;
import modelo.PaqueteTuristico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentanaPaquetes extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaPaquetes() {

        setTitle("MATIK TOUR - Paquetes Turísticos");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Paquete");
        modelo.addColumn("Días");
        modelo.addColumn("Precio (S/)");

        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        JButton btnReservar = new JButton("Reservar");
        JButton btnSalir = new JButton("Salir");

        btnReservar.addActionListener(e -> reservarPaquete());
        btnSalir.addActionListener(e -> System.exit(0));

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnReservar);
        panelBotones.add(btnSalir);

        add(scroll, "Center");
        add(panelBotones, "South");

        cargarPaquetes();
    }

    private void cargarPaquetes() {
        modelo.setRowCount(0);

        PaqueteDAO dao = new PaqueteDAO();
        List<PaqueteTuristico> paquetes = dao.listarPaquetes();

        for (PaqueteTuristico p : paquetes) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getDias(),
                    p.getPrecio()
            });
        }
    }

    private void reservarPaquete() {
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un paquete");
            return;
        }

        int idPaquete = Integer.parseInt(tabla.getValueAt(fila, 0).toString());

        JOptionPane.showMessageDialog(this,
                "Paquete seleccionado ID: " + idPaquete +
                        "\n(En el siguiente paso se registra la reserva)");
    }
}
