package org.lebedeva.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.lebedeva.Check.addTimeDomainSecure;
import static org.lebedeva.Check.checkParameter;

@WebServlet("/add")
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (checkParameter(req.getParameter("name"))) {
            String name = req.getParameter("name").trim();
            String value = "";

            if (checkParameter(req.getParameter("value"))) {
                value = req.getParameter("value");
            }
            Cookie cookie = new Cookie(name, value);

            addTimeDomainSecure(req, cookie);

            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            resp.getWriter().write("wrong data");
        }
    }
}
