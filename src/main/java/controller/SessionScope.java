package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class SessionScope extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter pr = res.getWriter();

        HttpSession httpSession = req.getSession();
        Object isVisited = httpSession.getAttribute("isVisited");
        if (isVisited == null) {
            httpSession.setAttribute("isVisited", true);
            pr.write("<h1> Welcome to my website </h1>");
        } else {
            pr.write("<h1> Welcome back </h1>");
        }
    }

}
