import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/matik_tour",
                    "root",
                    "ciencianos1003"
            );
            System.out.println("✅ Conectado correctamente a MySQL");
        } catch (Exception e) {
            System.out.println("❌ Error de conexión");
            e.printStackTrace();
        }
    }
}
