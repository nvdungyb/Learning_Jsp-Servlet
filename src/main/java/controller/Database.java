package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static Connection connect = null;

    public static Connection connection(String driver, String schema, String host, String port, String databaseName) {
        String url = schema + host + ":" + port + "/" + databaseName;
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, "root", "Dung3032003_135709");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return connect;
    }

    public static Connection connection(String driver, String url) {
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, "root", "Dung3032003_135709");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return connect;
    }

    public static void closeConnection(Connection connect) {
        try {
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // It call unit test.
    public static void main(String[] args) {
        connect = Database.connection("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/btl_web");
        System.out.println(connect);
    }
}
