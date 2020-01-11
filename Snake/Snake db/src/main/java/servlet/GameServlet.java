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

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) config.getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/game.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access is denied");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");

        try {
            if (user != null && userDao != null) {
                int coins = (req.getParameter("coins") == null || "".equals(req.getParameter("coins"))) ? 0
                        : Integer.parseInt(req.getParameter("coins"));

                if (coins > 0) {
                    userDao.update(user, coins + user.getCoins());
                    user.setCoins(user.getCoins() + coins);
                }

                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/game");
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "server error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
