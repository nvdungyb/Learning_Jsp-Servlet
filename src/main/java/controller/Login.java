package controller;

import get.UserGet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Login extends HttpServlet {
    private String adminName, adminPassword, adminEmail;
    private Connection connection = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        adminName = config.getInitParameter("adminName");
        adminPassword = config.getInitParameter("adminPassword");
        adminEmail = config.getInitParameter("adminEmail");

        // ServletListener.
        ServletContext context = config.getServletContext();
        connection = (Connection) context.getAttribute("connect-db-btl_web");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String userName = req.getParameter("UserName").trim();
        String pass = req.getParameter("UserPassword").trim();
        User user = null;
        try {
            user = new UserGet().login(connection, userName, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String submitButton = req.getParameter("submit");

        if (submitButton != null && submitButton.equals("Submit")) {
            req.getSession().setAttribute("user", user);

            HttpSession httpSession = req.getSession();
            if (httpSession.getAttribute("isLogined") == null) {
                httpSession.setAttribute("isLogined", true);
                httpSession.setAttribute("admin", true);
            }

            req.getRequestDispatcher("wellcome.jsp").forward(req, res);

        } else if (submitButton != null && submitButton.equals("Register")) {
            // Để đk thì user không tồn tại trong db.
            if (user == null) {
                if (!userName.isEmpty() && !pass.isEmpty()) {
                    boolean isInserted = new UserGet().insertUser(connection, new User(userName, pass));        // New user.
                    if (isInserted) {
                        System.out.println("User đã được đăng kí");
                    } else {
                        System.out.println("User đăng kí không thành công");
                    }
                }
            }

            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }
}
