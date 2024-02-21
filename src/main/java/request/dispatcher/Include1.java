package request.dispatcher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Include1 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pr = res.getWriter();

        pr.write("<h1> Hello from Include1 </h1>");

        // Request scope.
        req.setAttribute("attr1", "value1");

        RequestDispatcher rd = req.getRequestDispatcher("include2");
        rd.include(req, res);
    }
}
