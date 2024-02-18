package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String userName = req.getParameter("UserName");

        ServletContext context = getServletContext();
        if (userName.equals("admin")) {
            context.setAttribute("userName", userName);
        } else {
            context.setAttribute("userName", null);
        }

        res.sendRedirect("wellcome.jsp");

        System.out.println("Login: " + userName);
    }
}
