package org.lebedeva.servlet.post;

import org.lebedeva.repository.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    PostRepository postRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postRepository = PostRepository.getInstance();

        if (postRepository != null && postRepository.getPosts() != null) {
            req.setAttribute("posts", postRepository.getPosts());
        }
        req.getRequestDispatcher("/WEB-INF/jsp/post/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
