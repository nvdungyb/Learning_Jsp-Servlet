package get;

import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserGet {
    public ArrayList<User> getUserList() throws SQLException {
        Connection connec = controller.Database.connection("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/btl_web");
        String sql = "SELECT * FROM btl_web.user";
        Statement statement = connec.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        ArrayList<User> ls = new ArrayList<>();
        while(rs.next()){
            String userName = rs.getString("userName");
            String passWord = rs.getString("passWord");
            User user = new User(userName, passWord);
            ls.add(user);
            connec.close();
        }

        return ls;
    }

    public User login(String name, String pass) throws SQLException {
        Connection connec = controller.Database.connection("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/btl_web");
        String sql = "SELECT * FROM btl_web.user Where userName  = '" + name + "' and passWord = '" + pass + "'";
        Statement statement = connec.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()){
            String userName = rs.getString("userName");
            String passWord = rs.getString("passWord");
            User user = new User(userName, passWord);
            return user;
        }
        connec.close();

        return null;
    }
}