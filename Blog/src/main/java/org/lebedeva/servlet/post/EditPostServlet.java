package org.lebedeva.servlet.post;

import org.lebedeva.check.Check;
import org.lebedeva.model.post.Category;
import org.lebedeva.model.post.Post;
import org.lebedeva.model.user.User;
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

@WebServlet("/edit")
public class EditPostServlet extends HttpServlet {

    PostRepository postRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/post/post.jsp");
        postRepository = PostRepository.getInstance();
        User user = (User) req.getSession().getAttribute("user");

        if (Check.checkParameter(req.getParameter("title")) && user != null && Check.checkParameter(req.getParameter("id"))
                && Check.checkParameter(req.getParameter("subtitle")) && postRepository != null) {
            try {
                Category category = Check.getCategory(req.getParameter("category").trim());
                int id = Integer.parseInt(req.getParameter("id").trim());

                List<String> contents = new ArrayList<>();
                contents.add(Check.checkParameter(req.getParameter("content1")) ? req.getParameter("content1").trim() : "");
                contents.add(Check.checkParameter(req.getParameter("content2")) ? req.getParameter("content2").trim() : "");
                contents.add(Check.checkParameter(req.getParameter("content3")) ? req.getParameter("content3").trim() : "");
                contents.add(Check.checkParameter(req.getParameter("content4")) ? req.getParameter("content4").trim() : "");
                contents.add(Check.checkParameter(req.getParameter("content5")) ? req.getParameter("content5").trim() : "");

                List<Post> posts = postRepository.getPosts();

                if (posts != null) {
                    for (Post post : posts) {
                        if (post != null && post.getId().compareTo(id) == 0) {
                            post.setTitle(req.getParameter("title").trim());
                            post.setSubtitle(req.getParameter("subtitle").trim());
                            post.setCategory(category);
                            post.setContents(contents);
                            req.setAttribute("post", post);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                resp.getWriter().write("<p style=\"margin-top: 100px;color: red\" >Wrong data.</p>");
                e.printStackTrace();
            }
        } else {
            resp.getWriter().write("<p style=\"margin-top: 100px;color: red\" >Wrong data: empty field.</p>");
        }
        dispatcher.include(req, resp);
    }
}
