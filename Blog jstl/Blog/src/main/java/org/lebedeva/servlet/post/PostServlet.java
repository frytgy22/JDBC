package org.lebedeva.servlet.post;

import org.lebedeva.check.Check;
import org.lebedeva.model.post.Post;
import org.lebedeva.repository.PostRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    PostRepository postRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        postRepository = PostRepository.getInstance();
        boolean getPost = false;

        if (Check.checkParameter(req.getParameter("id")) && postRepository != null) {
            try {
                int id = Integer.parseInt(req.getParameter("id").trim());
                List<Post> posts = postRepository.getPosts();

                if (posts != null) {
                    Post post = posts.stream()
                            .filter(p -> p != null && p.getId().compareTo(id) == 0)
                            .findFirst().orElse(null);

                    if (post != null) {
                        req.setAttribute("post", post);
                        getPost = true;
                        req.getRequestDispatcher("/WEB-INF/jsp/post/post.jsp").forward(req, resp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!getPost) {
            resp.sendRedirect(req.getContextPath() + "/main");
        }
    }
}
