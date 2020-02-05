package org.lebedeva.servlet;

import org.lebedeva.check.Check;
import org.lebedeva.model.user.User;
import org.lebedeva.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {

    UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/authentication/authorization.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/authentication/authorization.jsp");
        userRepository = UserRepository.getInstance();

        if (userRepository != null && Check.checkParameter(req.getParameter("email")) &&
                Check.checkParameter(req.getParameter("password"))) {

            final String LOGIN = req.getParameter("email").trim();
            final String PASSWORD = req.getParameter("password").trim();

            List<User> users = userRepository.getUsers();

            if (users != null) {
                for (User user : users) {
                    if (user != null && LOGIN.equals(user.getLogin()) && PASSWORD.equals(user.getPassword())) {

                        HttpSession session = req.getSession();
                        session.setAttribute("user", user);

                        resp.sendRedirect(req.getContextPath() + "/main");
                        break;
                    }
                }
            }
            resp.getWriter().write("<p style=\"color:red ; top: 0; position: absolute\">Wrong login or password.</p>");
        } else {
            resp.getWriter().write("<p style=\"color:red ; top: 0; position: absolute\">Wrong data: empty field.</p>");
        }
        dispatcher.include(req, resp);
    }
}
