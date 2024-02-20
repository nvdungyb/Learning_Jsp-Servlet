package controller;

import get.UserGet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Login extends HttpServlet {
    private String adminName, adminPassword, adminEmail;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        adminName = config.getInitParameter("adminName");
        adminPassword = config.getInitParameter("adminPassword");
        adminEmail = config.getInitParameter("adminEmail");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String userName = req.getParameter("UserName").trim();
        String pass = req.getParameter("UserPassword").trim();
        User user = null;
        try {
            user = new UserGet().login(userName, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String submitButton = req.getParameter("submit");

        if (submitButton != null && submitButton.equals("Submit")) {
            req.getSession().setAttribute("user", user);

            HttpSession httpSession = req.getSession();
            if (httpSession.getAttribute("isLogined") == null) {
                httpSession.setAttribute("isLogined", true);
            }

            req.getRequestDispatcher("wellcome.jsp").forward(req, res);

        } else if (submitButton != null && submitButton.equals("Register") && user == null) {       // Để đk thì user không tồn tại trong db.
            if (!userName.isEmpty() && !pass.isEmpty()) {
                PrintWriter pr = res.getWriter();
                pr.write("<h1>Register success</h1>");
            } else {
                req.getRequestDispatcher("index.jsp").forward(req, res);
            }
        }
    }
}
