package read;

import controller.Database;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;

@WebServlet("/read-context")
public class ReadContextParam extends HttpServlet {
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

        Enumeration<String> params = context.getAttributeNames();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            pr.write("<h5> " + param + " : " + context.getAttribute(param) + "</h1>");
        }
    }
}
