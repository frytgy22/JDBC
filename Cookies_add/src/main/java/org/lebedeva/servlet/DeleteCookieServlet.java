package org.lebedeva.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.lebedeva.Check.checkParameter;
import static org.lebedeva.Check.getCookie;

@WebServlet("/delete")
public class DeleteCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (checkParameter(req.getParameter("key"))) {
            String key = req.getParameter("key").trim();

            Optional<Cookie> cookie = getCookie(key, req);

            if (cookie.isPresent()) {
                cookie.get().setMaxAge(0);
                resp.addCookie(cookie.get());
            }
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            resp.getWriter().write("wrong data");
        }
    }
}
