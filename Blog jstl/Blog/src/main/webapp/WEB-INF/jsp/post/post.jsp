<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/head.jsp" %>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <c:choose>
            <c:when test="${!empty(requestScope.post)}">

                <div id="editF" class="col-lg-8">
                    <form class="form" method="post" action="${pageContext.request.contextPath}/edit">
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
                        <a href="#">${requestScope.post.author.login}</a>
                    </p>

                    <hr>

                    <!-- Date/Time -->
                    <p>${requestScope.post.publicationDate}</p>

                    <hr>

                    <!-- Preview Image -->
                    <img class="img-fluid rounded" src="static/images/6.png" alt="icon">

                    <hr>

                    <!-- Post Content -->
                    <p class="lead">${requestScope.post.subtitle}</p>

                    <c:if test="${!empty(requestScope.post.contents)}">

                        <c:forEach items="${requestScope.post.contents}" var="content">
                            <p>${content}</p>
                        </c:forEach>

                    </c:if>
                    <hr>

                    <!-- Comments Form -->
                    <div class="card my-4">
                        <h5 class="card-header">Leave a Comment:</h5>
                        <div class="card-body">
                            <form method="post" action="${pageContext.request.contextPath}/commit">
                                <input type="hidden" name="id" value="${requestScope.post.id}">
                                <div class="form-group">
                                    <textarea name="commit" class="form-control" rows="3"></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                        </div>
                    </div>

                    <c:if test="${!empty(requestScope.post.comments)}">

                        <c:forEach items="${requestScope.post.comments}" var="comment">
                            <!-- Single Comment -->
                            <div class="media mb-4">
                                <img class="d-flex mr-3 rounded-circle" src="static/images/36.png" alt="user">
                                <div class="media-body">
                                    <h5 class="mt-0">${comment.user.login}</h5>
                                        ${comment.comment}
                                </div>
                            </div>
                        </c:forEach>

                    </c:if>

                </div>

                <form id="deleteF" method="post" action="${pageContext.request.contextPath}/delete">
                    <input type="hidden" name="id" value="${requestScope.post.id}">
                    <input type="hidden" value="${requestScope.post.title}">
                </form>

            </c:when>
            <c:otherwise>
                <jsp:forward page="index.jsp"/>
            </c:otherwise>
        </c:choose>

        <%@include file="template/sidebar.jsp" %>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<script src="https://code.jquery.com/jquery-2.1.0.js"></script>
<script src="static/js/post.js"></script>
<%@include file="template/footer.jsp" %>