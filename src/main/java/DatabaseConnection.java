

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hibernatecrud";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        }
        return connection;
    }
}

