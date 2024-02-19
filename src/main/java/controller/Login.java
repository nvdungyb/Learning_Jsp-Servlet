package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Login extends HttpServlet {
    private String adminName;
    private String adminPassword;
    private String adminEmail;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        adminName = config.getInitParameter("adminName");
        adminPassword = config.getInitParameter("adminPassword");
        adminEmail = config.getInitParameter("adminEmail");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String userName = req.getParameter("UserName");
        String pass = req.getParameter("UserPassword");

//        getServletContext() is a method of ServletInterface and it returns the object of ServletContext.
        ServletContext context = getServletContext();
        if (userName.equals("admin") && pass.equals("admin")) {
            context.setAttribute("userName", adminName);
            context.setAttribute("adminEmail", adminEmail);
        } else {
            context.setAttribute("userName", null);
        }

        res.sendRedirect("wellcome.jsp");

        System.out.println("Login: " + userName + " + " + adminEmail);
    }
}
