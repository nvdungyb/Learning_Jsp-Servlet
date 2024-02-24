package servlet.listener;

import controller.Database;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;

@WebListener
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context is initialized");

        ServletContext context = sce.getServletContext();
        Connection connect = Database.connection("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/btl_web");
        context.setAttribute("connect-db-btl_web", connect);

        context.setAttribute("ATTR_DEFAULT_LANGUAGE", "vietnamese");
        System.out.println("Default language: " + context.getAttribute("ATTR_DEFAULT_LANGUAGE"));
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context is destroyed");
        Connection connect = (Connection) sce.getServletContext().getAttribute("connect-db-btl_web");
        Database.closeConnection(connect);
        sce.getServletContext().removeAttribute("ATTR_DEFAULT_LANGUAGE");
    }
}


