package agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utilidad para gestionar la conexión a la base de datos MySQL
 */
public class DB {

    // --- Configuración para XAMPP ---
    // 2. Asegúrate de que el driver .jar de MySQL esté en las 'Libraries' de NetBeans.
    private static final String URL = "jdbc:mysql://localhost:3306/agenda_db?useSSL=false&serverTimezone=UTC"; 
    private static final String USER = "root";       // Usuario por defecto de XAMPP
    private static final String PASS = "";           // Contraseña vacía por defecto de XAMPP
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Driver de MySQL 

    public static Connection getConnection() throws SQLException {
        try {
            // Cargar el driver
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de MySQL.");
            // Esto falla si no agregaste el JAR a las 'Libraries'
            e.printStackTrace();
            throw new SQLException("Driver no encontrado", e);
        }
        
        // Establecer la conexión
        return DriverManager.getConnection(URL, USER, PASS);
    }


    public static void close(java.sql.ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
    }


    public static void close(java.sql.Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(java.sql.Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}