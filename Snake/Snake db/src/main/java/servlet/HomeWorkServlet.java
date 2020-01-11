package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/hw")
public class HomeWorkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/zip");
        resp.setHeader("Content-disposition", "attachment; filename=hw.zip");

        try (InputStream stream = getServletContext().getResourceAsStream("/WEB-INF/hw.zip");
             OutputStream out = resp.getOutputStream()) {
            byte[] buffer = new byte[1048];
            int numBytesRead;
            while ((numBytesRead = stream.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}