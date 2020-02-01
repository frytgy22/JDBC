package org.lebedeva.servlet.post;

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
import java.util.List;

@WebServlet("/delete")
public class DeletePostServlet extends HttpServlet {

    PostRepository postRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/post/post.jsp");
        postRepository = PostRepository.getInstance();

        if (postRepository != null && Check.checkParameter(req.getParameter("id"))) {
            try {
                int id = Integer.parseInt(req.getParameter("id").trim());
                List<Post> posts = postRepository.getPosts();

                if (posts != null) {
                    for (Post post : posts) {
                        if (post != null && post.getId().compareTo(id) == 0) {
                            postRepository.remove(post);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                resp.getWriter().write("<p style=\"color:red ; margin-top: 100px;\">Error.</p>");
                dispatcher.include(req, resp);
                e.printStackTrace();
            }
        } else {
            resp.getWriter().write("<p style=\"color:red ; margin-top: 100px;\">Error.</p>");
            dispatcher.include(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
