package org.lebedeva.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener("/")
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        String url = servletContext.getInitParameter("db:url");
        String user = servletContext.getInitParameter("db:user");
        String password = servletContext.getInitParameter("db:password");

        try {
            DbConfiguration db = new DbConfiguration(url, user, password);
            servletContext.setAttribute("dbConfig", db);
            System.out.println("init");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        DbConfiguration db = (DbConfiguration) servletContext.getAttribute("dbConfig");
        try {
            db.closeConnection();
            System.out.println("close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
