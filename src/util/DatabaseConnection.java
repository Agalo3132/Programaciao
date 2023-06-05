package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    private DatabaseConnection() {}

    static {
        String url = "jdbc:mysql://localhost/mydb";
        String user = "root";
        String password = "Berserk";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close() throws SQLException {
        connection.close();
    }
}
