package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class ServletContextParam extends HttpServlet {
    private ServletContext context;
    private String host, databaseName, schema, port, driver;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.context = config.getServletContext();
        driver = context.getInitParameter("driver");
        schema = context.getInitParameter("schema");
        host = context.getInitParameter("host");
        databaseName = context.getInitParameter("databaseName");
        port = context.getInitParameter("port");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Connection connect = Database.connection(driver, schema, host, port, databaseName);
        System.out.println(connect);

        PrintWriter pr = res.getWriter();
        pr.write("<h1> " + connect + "</h1>");
    }
}
