package dao;

import modelo.PaqueteTuristico;
import servicios.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaqueteDAO {

    public List<PaqueteTuristico> listarPaquetes() {

        List<PaqueteTuristico> lista = new ArrayList<>();

        String sql = """
            SELECT p.id, p.nombre, p.dias, p.precio,
                   g.nombre AS guia,
                   t.empresa AS transportista
            FROM paquete p
            JOIN guia g ON p.guia_id = g.id
            JOIN transportista t ON p.transportista_id = t.id
        """;

        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new PaqueteTuristico(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("dias"),
                        rs.getDouble("precio"),
                        rs.getString("guia"),
                        rs.getString("transportista")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}