<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!-- Sidebar Widgets Column -->
<div class="col-md-4">

    <!-- Search Widget -->
    <div class="card my-4">
        <h5 class="card-header">Search</h5>
        <div class="card-body">
            <form method="post" action="${pageContext.request.contextPath}/search">
                <div class="input-group">
                    <input type="text" name="search" required class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                <button class="btn btn-secondary" type="submit">Go!</button>
              </span>
                </div>
            </form>
        </div>
    </div>

    <!-- Categories Widget -->
    <div class="card my-4">
        <h5 class="card-header">Categories</h5>
        <div class="card-body">
            <div class="row">
                <form method="post" action="${pageContext.request.contextPath}/category">

                    <ul class="list-unstyled mb-0">

                        <c:if test="${!empty(applicationScope.categories)}">
                            <c:forEach items="${applicationScope.categories}" var="category">

                                <li class="li">
                                    <button class="but" type="submit" name="categories" value="${category.toString()}">
                                            ${fn:toLowerCase(category.toString().replaceAll('_',' '))}
                                    </button>
                                </li>

                            </c:forEach>
                        </c:if>
                    </ul>
                </form>
            </div>
        </div>
    </div>

    <!-- Side Widget -->
    <div class="card my-4">
        <h5 class="card-header">Blog info</h5>
        <div class="card-body">
            <img class="card-img-top" width="100" src="static/images/85.png" alt="logo">
        </div>
    </div>

</div>