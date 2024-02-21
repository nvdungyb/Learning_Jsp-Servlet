package request.dispatcher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Forward2 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pr = res.getWriter();

        pr.write("<h1> Hello from Forward2 </h1><br>");
        pr.write("<h2> Forward1 has an attribute: " + req.getAttribute("attr1") + "</h2>");
    }
}
