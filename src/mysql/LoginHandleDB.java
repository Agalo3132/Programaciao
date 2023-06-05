package mysql;

import model.Login;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoginHandleDB {

    private static Connection con = DatabaseConnection.getConnection();

    public List<Login> getLogins() throws SQLException {

        String sql = "SELECT * FROM login";
        try (Statement statement = con.createStatement()) {
            List<Login> lg = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Login login = new Login();
                login.setId(resultSet.getInt(1));
                login.setUsername(resultSet.getString("username"));
                login.setPassword(resultSet.getString("password"));
                login.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                lg.add(login);
            }

            return lg;
        }
    }

    public Login getLogin(String name, String password){
        try (Connection connection = DatabaseConnection.getConnection()){



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
