package org.lebedeva.servlet.post.search;

import org.lebedeva.check.Check;
import org.lebedeva.model.post.Post;
import org.lebedeva.repository.PostRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    PostRepository postRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/post/index.jsp");
        postRepository = PostRepository.getInstance();

        if (Check.checkParameter(req.getParameter("search")) && postRepository != null) {
            String title = req.getParameter("search").trim();

            List<Post> posts = postRepository.getPosts();
            List<Post> postList = new ArrayList<>();

            if (posts != null) {
                for (Post post : posts) {
                    if (post != null && title.contains(post.getTitle())) {
                        postList.add(post);
                    }
                }
            }

            req.setAttribute("posts", postList);
            req.getRequestDispatcher("/WEB-INF/jsp/post/index.jsp").forward(req, resp);
        } else {
            resp.getWriter().write("<p style=\"color:red ; margin-top: 100px;\">Wrong data: empty field.</p>");
            dispatcher.include(req, resp);
        }
    }
}
