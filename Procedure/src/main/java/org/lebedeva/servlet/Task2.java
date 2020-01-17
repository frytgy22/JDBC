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

@WebServlet("/task2")
public class Task2 extends HttpServlet {

    DbConfiguration db;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/task2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        db = (DbConfiguration) req.getServletContext().getAttribute("dbConfig");
        Connection connection = db.getConnection();

        try {
            String oldGenre = req.getParameter("old");
            String newGenre = req.getParameter("new");

            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("{call sp_update_genre(?,?)}");

            preparedStatement.setString(1, oldGenre);
            preparedStatement.setString(2, newGenre);
            preparedStatement.executeUpdate();

            connection.commit();
            preparedStatement.close();

            resp.getWriter().write("<p>Done</p>");
        } catch (SQLException | NullPointerException e) {
            try {
                connection.rollback();
                resp.getWriter().write("<p>Wrong data</p>");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
