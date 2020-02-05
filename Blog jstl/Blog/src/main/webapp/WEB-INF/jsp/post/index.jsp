<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/head.jsp" %>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">My posts
                <small>today</small>
            </h1>

            <c:choose>
                <c:when test="${!empty(requestScope.posts) and requestScope.posts.size() > 0}">

                    <c:forEach items="${requestScope.posts}" var="post">
                        <!-- Blog Post -->
                        <div class="card mb-4">
                            <img class="card-img-top" src="static/images/6.png" alt="Card image cap">
                            <div class="card-body">
                                <h2 class="card-title">${post.title}</h2>
                                <p class="card-text">${post.subtitle}</p>

                                <form style="display: inline-block" method="post"
                                      action="${pageContext.request.contextPath}/post">
                                    <button type="submit" name="id" class="btn btn-primary" value="${post.id}">Read More
                                    </button>
                                </form>

                            </div>
                            <div class="card-footer text-muted">
                                <p> category: ${post.category.toString().replaceAll("_", " ").toLowerCase()}</p>
                                <span>${post.publicationDate} by</span>
                                <a href="">${post.author.login}
                                </a>
                            </div>
                        </div>
                    </c:forEach>

                </c:when>
                <c:otherwise>
                    <jsp:forward page="template/empty.jsp"/>
                </c:otherwise>
            </c:choose>

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