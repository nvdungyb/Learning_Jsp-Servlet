package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet("/response")
public class ResponseHeader extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Refresh the web page.
        res.setIntHeader("Refresh", 5);

        // Set response status. This is HTTP status code.
//        res.setStatus(500);

        // Response's Text stream.
        PrintWriter pr = res.getWriter();
        pr.write("<h1> Auto refresh web page after 5 seconds" + new Date() + " </h1>");
    }
}
