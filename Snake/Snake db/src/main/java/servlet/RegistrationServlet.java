package servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) config.getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); //удаляю предыдущую сессию
        if (!session.isNew()) {
            session.invalidate();
        }
        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String LOGIN = req.getParameter("login");
        final String PASSWORD = req.getParameter("password");

        User user = User.builder().login(LOGIN).password(PASSWORD).build();

        try {
            if (userDao != null) {
                boolean userInBase = userDao.findAll().stream()
                        .anyMatch(user1 -> LOGIN.equals(user1.getLogin()));

                if (!userInBase) {
                    userDao.save(user);

                    req.getRequestDispatcher("/WEB-INF/jsp/info/infoOK.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/WEB-INF/jsp/info/infoError.jsp").forward(req, resp);
                }
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "server error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
