package configuration;

import dao.UserDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener("/")
public class DbConfiguration implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String user = servletContext.getInitParameter("db.username");
        String pass = servletContext.getInitParameter("db.password");
        String url = servletContext.getInitParameter("db.url");
        try {
            UserDao userDao = new UserDao(url, user, pass);
            servletContext.setAttribute("userDao", userDao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        UserDao userDao = (UserDao) servletContext.getAttribute("userDao");
        try {
            userDao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
