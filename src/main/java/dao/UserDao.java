package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {

    public static Connection connection(String driver, String schema, String host, String port, String databaseName) {
        Connection connect = null;
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
        Connection connect = null;
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, "root", "Dung3032003_135709");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return connect;
    }

    // Vì đã sử dụng kiến thức trước vào phương thức connection(drive, url); nên tôi tái sử dụng code chứ ko sửa.
    public static Connection getConnection() {
        return UserDao.connection("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/btl_web");
    }

    public static void closeConnection(Connection connect) {
        try {
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean saveUser(User user) {
        Connection connect = UserDao.getConnection();
        String sql = "INSERT INTO btl_web.user VALUES('" + user.getUserName() + "','" + user.getPassword() + "')";
        System.out.println(sql);
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate(sql);
            connect.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static User login(String name, String pass) throws SQLException {
        Connection connect = UserDao.getConnection();
        String sql = "SELECT * FROM btl_web.user Where userName  = '" + name + "' and passWord = '" + pass + "'";
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            String userName = rs.getString("userName");
            String passWord = rs.getString("passWord");
            User user = new User(userName, passWord);
            connect.close();
            return user;
        }

        connect.close();
        return null;
    }

    public static ArrayList<User> getAllUser() throws SQLException {
        Connection connect = UserDao.getConnection();
        String sql = "SELECT * FROM btl_web.user";
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        ArrayList<User> ls = new ArrayList<>();
        while (rs.next()) {
            String userName = rs.getString("userName");
            String passWord = rs.getString("passWord");
            User user = new User(userName, passWord);
            ls.add(user);
        }

        connect.close();
        return ls;
    }

    public static boolean updateUser(User user) {
        Connection connect = UserDao.getConnection();
        try {
            String sql = "UPDATE btl_web.user WHERE userName = '" + user.getUserName() + "' SET passWord = '" + user.getPassword() + "'";
            Statement statement = connect.createStatement();
            statement.executeUpdate(sql);
            connect.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteUser(String userName) {
        Connection connect = UserDao.getConnection();
        try {
            String sql = "DELETE FROM btl_web.user WHERE userName = '" + userName + "'";
            Statement statement = connect.createStatement();
            statement.executeUpdate(sql);
            connect.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // It call unit test.
    public static void main(String[] args) {
        Connection connect = UserDao.connection("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/btl_web");
        System.out.println(connect);
    }
}
