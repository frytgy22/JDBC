<%@ page import="org.lebedeva.model.post.Comment" %>
<%@ page import="org.lebedeva.model.post.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="template/head.jsp" %>

<!-- Page Content -->
<div class="container">

    <div class="row">
        <%
            Post post = (Post) request.getAttribute("post");

            if (post != null) {
                response.addCookie(new Cookie("id", post.getId().toString()));%>

        <div id="editF" class="col-lg-8">
            <form class="form" method="post" action="<%=request.getContextPath()%>/edit">
                <h3>Edit post: ${requestScope.post.title}</h3>
                <input type="hidden" name="id" value="${requestScope.post.id}">
                <%@include file="template/form.jsp" %>
            </form>
        </div>

        <!-- Post Content Column -->
        <div class="col-lg-8" id="post">

            <!-- Title -->
            <h1 class="mt-4">${requestScope.post.title}
            </h1>
            <img class="float" id="delete" src="static/images/3.png" alt="logo">
            <img class="float" id="edit" src="static/images/4.png" alt="logo">
            <!-- Author -->
            <p class="lead">
                by
                <a href="#">${requestScope.post.author.login}
                </a>
            </p>

            <hr>

            <!-- Date/Time -->
            <p>${requestScope.post.publicationDate}
            </p>

            <hr>

            <!-- Preview Image -->
            <img class="img-fluid rounded" src="static/images/6.png" alt="icon">

            <hr>

            <!-- Post Content -->
            <p class="lead">${requestScope.post.subtitle}
            </p>

            <%
                if (post.getContents() != null) {
                    for (String content : post.getContents()) {
            %>
            <p><%=content%>
            </p>
            <%
                    }
                }
            %>

            <hr>

            <!-- Comments Form -->
            <div class="card my-4">
                <h5 class="card-header">Leave a Comment:</h5>
                <div class="card-body">
                    <form method="post" action="<%=request.getContextPath()%>/commit">
                        <input type="hidden" name="id" value="${requestScope.post.id}">
                        <div class="form-group">
                            <textarea name="commit" class="form-control" rows="3"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>

            <%
                if (post.getComments() != null) {
                    for (Comment comment : post.getComments()) {%>

            <!-- Single Comment -->
            <div class="media mb-4">
                <img class="d-flex mr-3 rounded-circle" src="static/images/36.png" alt="user">
                <div class="media-body">
                    <h5 class="mt-0"><%=comment.getUser().getLogin()%>
                    </h5>
                    <%=comment.getComment()%>
                </div>
            </div>
            <%
                    }
                }
            %>

        </div>

        <form id="deleteF" method="post" action="<%=request.getContextPath()%>/delete">
            <input type="hidden" name="id" value="${requestScope.post.id}">
            <input type="hidden" value="${requestScope.post.title}">
        </form>

        <%} else {%>
        <jsp:forward page="index.jsp"/>
        <% }%>

        <%@include file="template/sidebar.jsp" %>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<script src="https://code.jquery.com/jquery-2.1.0.js"></script>
<script src="<%=request.getContextPath()%>/static/js/post.js"></script>
<%@include file="template/footer.jsp" %>