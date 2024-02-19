package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection connection(String driver, String schema, String host, String port, String databaseName) {
        String url = schema + host + ":" + port + "/" + databaseName;
        System.out.println(url);
        try {
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(url, "root", "Dung3032003_135709");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connect) {
        try {
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
