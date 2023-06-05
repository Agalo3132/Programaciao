import model.Login;
import mysql.LoginHandleDB;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        LoginHandleDB loginHandleDB = new LoginHandleDB();

        try {
            System.out.println(loginHandleDB.getLogins());



        } catch (SQLException e) {
            System.out.println("Hola");
        }
    }


}