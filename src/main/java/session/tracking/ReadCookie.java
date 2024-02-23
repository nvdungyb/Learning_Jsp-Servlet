package session.tracking;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ReadCookie extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter pr = res.getWriter();

        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            pr.write("<h1> Cookie Name: " + cookies[i].getName() + "  Cookies value: " + cookies[i].getValue() + "</h1><br>");
        }
    }
}
