<%@ page import="org.lebedeva.model.post.Post" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="template/head.jsp" %>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">My posts
                <small>today</small>
            </h1>

            <%
                List<Post> posts = (List<Post>) request.getAttribute("posts");
                if (posts != null && posts.size() > 0) {
                    for (Post post : posts) {
            %>

            <!-- Blog Post -->
            <div class="card mb-4">
                <img class="card-img-top" src="static/images/6.png" alt="Card image cap">
                <div class="card-body">
                    <h2 class="card-title"><%=post.getTitle()%>
                    </h2>
                    <p class="card-text"><%=post.getSubtitle()%>
                    </p>

                    <form style="display: inline-block" method="post" action="<%=request.getContextPath()%>/post">
                        <input type="submit" name="<%=post.getId()%>" class="btn btn-primary" value="Read More">
                    </form>

                </div>
                <div class="card-footer text-muted">
                    <%="category: " + post.getCategory().toString().replaceAll("_", " ").toLowerCase()%><br>
                    <%=post.getPublicationDate()%> by
                    <a href="#"><%=post.getAuthor().getLogin()%>
                    </a>
                </div>
            </div>
            <%
                }
            } else { %>

            <jsp:forward page="template/empty.jsp"/>

            <% }
            %>

            <!-- Pagination -->
            <ul class="pagination justify-content-center mb-4">
                <li class="page-item">
                    <a class="page-link" href="#">&larr; Older</a>
                </li>
                <li class="page-item disabled">
                    <a class="page-link" href="#">Newer &rarr;</a>
                </li>
            </ul>

        </div>


        <%@include file="template/sidebar.jsp" %>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<%@include file="template/footer.jsp" %>