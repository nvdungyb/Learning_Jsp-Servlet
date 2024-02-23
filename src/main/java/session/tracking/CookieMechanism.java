package session.tracking;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

public class CookieMechanism extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            Cookie ckUserName = new Cookie("userName", user.getUserName());
            Cookie ckPassword = new Cookie("password", user.getPassword());
            res.addCookie(ckUserName);
            res.addCookie(ckPassword);
        }

        req.getRequestDispatcher("wellcome.jsp").forward(req, res);
    }
}