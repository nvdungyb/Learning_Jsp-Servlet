package servlet.listener;

import controller.Database;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.Connection;

public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context is initialized");

        ServletContext context = sce.getServletContext();
        Connection connect = Database.connection("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/btl_web");
        context.setAttribute("connect-db-btl_web", connect);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context is destroyed");
        Connection connect = (Connection) sce.getServletContext().getAttribute("connect-db-user");
        Database.closeConnection(connect);
    }
}
