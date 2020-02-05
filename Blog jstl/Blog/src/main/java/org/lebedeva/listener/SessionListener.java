package org.lebedeva.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class SessionListener implements HttpSessionListener {

    private static final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sessionCount.incrementAndGet();
        setSessionCount(httpSessionEvent);
        httpSessionEvent.getSession().setMaxInactiveInterval(15 * 60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionCount.decrementAndGet();
        setSessionCount(httpSessionEvent);
    }

    private static void setSessionCount(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().getServletContext().setAttribute("sessions", sessionCount.get());
    }
}
