package org.lebedeva.servlet;

import org.lebedeva.configuration.DbConfiguration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/task3")
public class Task3 extends HttpServlet {

    DbConfiguration db;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/task3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        db = (DbConfiguration) req.getServletContext().getAttribute("dbConfig");
        Connection connection = db.getConnection();

        try {
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement("{call sp_delete_directors}");
            statement.executeUpdate();

            connection.commit();
            statement.close();
            resp.getWriter().write("<p>Done</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
                resp.getWriter().write("<p>Wrong query</p>");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
