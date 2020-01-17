package org.lebedeva.servlet;

import org.lebedeva.configuration.DbConfiguration;
import org.lebedeva.service.HtmlPrint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/task1")
public class Task1 extends HttpServlet {

    DbConfiguration db;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/task1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        db = (DbConfiguration) req.getServletContext().getAttribute("dbConfig");
        Connection connection = db.getConnection();

        try {
            int from = Integer.parseInt(req.getParameter("from"));
            int to = Integer.parseInt(req.getParameter("to"));

            PreparedStatement preparedStatement = connection.prepareStatement("{call sp_print_movies(?,?)}");

            preparedStatement.setInt(1, from);
            preparedStatement.setInt(2, to);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSet.beforeFirst();

                String[] createTable = {"Directors.FirstName", "Directors.LastName", "Movies.Title", "Movies.Rating",
                        "Actors.FirstName", "Actors.LastName"};

                HtmlPrint.printTable(resp.getWriter(), createTable, resultSet);
            }
            preparedStatement.close();
        } catch (NumberFormatException | SQLException | NullPointerException e) {
            resp.getWriter().write("<p>Wrong data</p>");
        }
    }
}
