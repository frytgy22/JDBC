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
import java.util.Date;
import java.util.List;

@WebServlet(value = "/add", name = "add")
public class AddPostServlet extends HttpServlet {

    PostRepository postRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/post/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postRepository = PostRepository.getInstance();
        User user = (User) req.getSession().getAttribute("user");

        if (Check.checkParameter(req.getParameter("title")) && user != null
                && Check.checkParameter(req.getParameter("subtitle")) && postRepository != null) {

            Category category = Check.getCategory(req.getParameter("category").trim());

            List<String> contents = new ArrayList<>();
            contents.add(Check.checkParameter(req.getParameter("content1")) ? req.getParameter("content1").trim() : "");
            contents.add(Check.checkParameter(req.getParameter("content2")) ? req.getParameter("content2").trim() : "");
            contents.add(Check.checkParameter(req.getParameter("content3")) ? req.getParameter("content3").trim() : "");
            contents.add(Check.checkParameter(req.getParameter("content4")) ? req.getParameter("content4").trim() : "");
            contents.add(Check.checkParameter(req.getParameter("content5")) ? req.getParameter("content5").trim() : "");

            postRepository.save(
                    Post.builder()
                            .id(postRepository.setId())
                            .title(req.getParameter("title").trim())
                            .author(user)
                            .subtitle(req.getParameter("subtitle").trim())
                            .publicationDate(new Date())
                            .comments(new ArrayList<>())
                            .category(category)
                            .contents(contents)
                            .build());

            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/post/add.jsp");
            resp.getWriter().write("<p style=\"margin-top: 100px;color: red\" >Wrong data: empty field.</p>");
            dispatcher.include(req, resp);
        }
    }
}
