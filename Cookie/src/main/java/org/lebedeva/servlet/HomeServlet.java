package org.lebedeva.servlet;

import org.lebedeva.configuration.DbConfiguration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    DbConfiguration db;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        db = (DbConfiguration) req.getServletContext().getAttribute("dbConfig");
        Connection connection = db.getConnection();

        try {
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            connection.setAutoCommit(false);

            CallableStatement callableStatement = connection.prepareCall("{call sp_add_user(?,?,?,?)}");

            callableStatement.setString(1, login);
            callableStatement.setString(2, email);
            callableStatement.setString(3, password);
            callableStatement.registerOutParameter(4, Types.VARCHAR);
            callableStatement.execute();

            connection.commit();

            String id = callableStatement.getString(4);

            if (Integer.parseInt(id) > 0) {
                resp.addCookie(new Cookie("userId", id));
                resp.sendRedirect(getServletContext().getContextPath() + "/main");
            } else {
                req.getRequestDispatcher("/WEB-INF/jsp/wrong.jsp").forward(req, resp);
            }
        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
            resp.getWriter().write("<p>Wrong data</p>");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
