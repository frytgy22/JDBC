package org.lebedeva.servlet.post;

import org.lebedeva.check.Check;
import org.lebedeva.model.post.Comment;
import org.lebedeva.model.post.Post;
import org.lebedeva.model.user.User;
import org.lebedeva.repository.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/commit")
public class AddCommitServlet extends HttpServlet {

    PostRepository postRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        postRepository = PostRepository.getInstance();

        if (postRepository != null && Check.checkParameter(req.getParameter("commit")) && user != null
                && Check.checkParameter(req.getParameter("id"))) {
            try {
                int id = Integer.parseInt(req.getParameter("id").trim());
                List<Post> posts = postRepository.getPosts();

                if (posts != null) {
                    for (Post post : posts) {
                        if (post != null && post.getId().compareTo(id) == 0) {
                            if (post.getComments() != null) {
                                post.getComments().add(new Comment(user, req.getParameter("commit").trim()));
                                req.setAttribute("post", post);
                                break;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/post/post.jsp").forward(req, resp);
    }
}
