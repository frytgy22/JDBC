package org.lebedeva.servlet;

import org.lebedeva.check.Check;
import org.lebedeva.model.user.User;
import org.lebedeva.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/authentication/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/authentication/registration.jsp");
        userRepository = UserRepository.getInstance();

        if (userRepository != null && Check.checkParameter(req.getParameter("email")) &&
                Check.checkParameter(req.getParameter("password"))) {

            final String LOGIN = req.getParameter("email").trim();
            final String PASSWORD = req.getParameter("password").trim();

            List<User> users = userRepository.getUsers();
            boolean userInBase = false;

            if (users != null) {
                for (User user : users) {
                    if (user != null && LOGIN.equals(user.getLogin())) {
                        userInBase = true;
                        break;
                    }
                }
            }

            if (userInBase || users == null) {
                resp.getWriter().write("<p style=\"color:red ; top: 0; position: absolute\">User already exists.</p>");
                dispatcher.include(req, resp);
            } else {
                User user = User.builder()
                        .id(userRepository.setId())
                        .login(LOGIN)
                        .password(PASSWORD).build();

                userRepository.save(user);

                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                resp.sendRedirect(req.getContextPath() + "/main");
            }
        } else {
            resp.getWriter().write("<p style=\"color:red ; top: 0; position: absolute\">Wrong data: empty field.</p>");
            dispatcher.include(req, resp);
        }
    }
}
