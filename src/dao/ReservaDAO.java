package dao;

import modelo.Reserva;
import servicios.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class ReservaDAO {

    public void guardarReserva(Reserva r) {

        String sql = """
            INSERT INTO reserva (cliente_id, paquete_id, fecha, total)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, r.getCliente().getId());
            ps.setInt(2, r.getPaquete().getId());
            ps.setDouble(3, r.getTotal());

            // Conversión correcta de java.util.Date a java.sql.Date
            ps.setDate(3, new Date(r.getFecha().getTime()));

            ps.setDouble(4, r.getTotal());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
