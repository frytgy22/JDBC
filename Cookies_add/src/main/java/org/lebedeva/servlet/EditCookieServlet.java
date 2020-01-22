package org.lebedeva.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.lebedeva.Check.*;

@WebServlet("/edit")
public class EditCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (checkParameter(req.getParameter("name"))) {
            String name = req.getParameter("name").trim();

            Optional<Cookie> cookie = getCookie(name, req);

            if (cookie.isPresent()) {
                Cookie newCookie = new Cookie(name, cookie.get().getValue());

                if (checkParameter(req.getParameter("value"))) {
                    newCookie.setValue(req.getParameter("value"));
                }

                addTimeDomainSecure(req, newCookie);

                resp.addCookie(newCookie);
                resp.sendRedirect(req.getContextPath() + "/");
            } else {
                resp.getWriter().write("Nothing to edit");
            }
        } else {
            resp.getWriter().write("wrong data");
        }
    }
}
