package servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) config.getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String LOGIN = req.getParameter("login");
        final String PASSWORD = req.getParameter("password");

        try {
            if (userDao != null) {    //проверяю, что пользователь есть в базе

                Optional<User> user = userDao.findAll().stream()
                        .filter(user1 -> LOGIN.equals(user1.getLogin()) && PASSWORD.equals(user1.getPassword()))
                        .findFirst();

                if (user.isPresent()) {
                    req.getSession().setAttribute("user", user.get());
                    resp.sendRedirect(req.getContextPath() + "/game");  //перенаправляю на сайт
                } else {
                    req.getRequestDispatcher("/WEB-INF/jsp/info/authorizationError.jsp").forward(req, resp);
                }
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "server error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
