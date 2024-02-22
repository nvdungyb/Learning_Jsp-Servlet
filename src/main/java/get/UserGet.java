package get;

import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserGet {
    public ArrayList<User> getUserList(Connection connection) throws SQLException {
        Connection connect = connection;
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

        return ls;
    }

    public User login(Connection connection, String name, String pass) throws SQLException {
        Connection connect = connection;
        String sql = "SELECT * FROM btl_web.user Where userName  = '" + name + "' and passWord = '" + pass + "'";
        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            String userName = rs.getString("userName");
            String passWord = rs.getString("passWord");
            User user = new User(userName, passWord);
            return user;
        }

        return null;
    }

    public boolean insertUser(Connection connection, User user) {
        Connection connec = connection;
        String sql = "INSERT INTO btl_web.user VALUES('" + user.getUserName() + "','" + user.getPassword() + "')";
        System.out.println(sql);
        try {
            Statement statement = connec.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}

/*
    Một vài lưu ý khi sử dụng JDBC:
    +) Statement.executeQuery() trả về một ResultSet object, chứa tất cả các kết quả của truy vấn.
    +) Statement.executeUpdate() trả về số lượng hàng bị ảnh hưởng bởi truy vấn.
    _ If you are executing a query that does't return a result set (e.g. an INSERT, UPDATE, or DELETE statement), use executeUpdate() instead of executeQuery().
 */