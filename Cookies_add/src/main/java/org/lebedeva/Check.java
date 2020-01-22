package org.lebedeva;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public interface Check {
    static boolean checkParameter(String data) {
        return data != null && data.length() > 0;
    }

    static Optional<Cookie> getCookie(String key, HttpServletRequest req) {
        return Arrays.stream(req.getCookies())
                .filter(cookie1 -> key.equals(cookie1.getName()))
                .findFirst();
    }

    static void addTimeDomainSecure(HttpServletRequest req, Cookie newCookie) {
        if (newCookie != null) {
            if (checkParameter(req.getParameter("time"))) {
                try {
                    int time = Integer.parseInt(req.getParameter("time"));
                    newCookie.setMaxAge(time);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            if (checkParameter(req.getParameter("domain"))) {
                newCookie.setDomain(req.getParameter("domain"));
            }

            if (checkParameter(req.getParameter("access"))) {
                newCookie.setHttpOnly("http".equals(req.getParameter("access").trim()));
                newCookie.setSecure("https".equals(req.getParameter("access").trim()));
            }
        }
    }
}

