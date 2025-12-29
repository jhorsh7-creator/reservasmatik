package servicios;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/matik_tour?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USUARIO = "root";   // 👈 USUARIO DE MYSQL
    private static final String CLAVE = "ciencianos1003";         // 👈 tu contraseña real de MySQL

    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

