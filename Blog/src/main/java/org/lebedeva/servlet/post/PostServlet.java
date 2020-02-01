package org.lebedeva.servlet.post;

import org.lebedeva.model.post.Post;
import org.lebedeva.repository.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
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
        Enumeration<String> parameterNames = req.getParameterNames();
        postRepository = PostRepository.getInstance();

        if (parameterNames.hasMoreElements() && postRepository != null) {
            try {
                int id = Integer.parseInt(parameterNames.nextElement().trim());
                List<Post> posts = postRepository.getPosts();
                Post post = null;

                if (posts != null) {
                    for (Post p : posts) {
                        if (p != null && p.getId().compareTo(id) == 0) {
                            post = p;
                            break;
                        }
                    }
                }

                if (post != null) {
                    req.setAttribute("post", post);
                    req.getRequestDispatcher("/WEB-INF/jsp/post/post.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/main");
                }

            } catch (Exception e) {
                e.printStackTrace();
                resp.sendRedirect(req.getContextPath() + "/main");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/main");
        }
    }
}
