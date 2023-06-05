package mysql;

import model.Login;
import util.DatabaseConnection;

import java.sql.*;
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

        String query = "SELECT * FROM login WHERE username=" + name + " AND password=" + password;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                Login lg = new Login();
                lg.setId(rs.getInt(1));
                lg.setUsername(rs.getString("username"));
                lg.setPassword(rs.getString("password"));
                lg.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                return lg;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
