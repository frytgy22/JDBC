<%@ page import="org.lebedeva.model.post.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Sidebar Widgets Column -->
<div class="col-md-4">

    <!-- Search Widget -->
    <div class="card my-4">
        <h5 class="card-header">Search</h5>
        <div class="card-body">
            <form method="post" action="<%=request.getContextPath()%>/search">
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
                <form method="post" action="<%=request.getContextPath()%>/category">

                    <ul class="list-unstyled mb-0">
                        <%
                            Category[] categories = Category.values();
                            if (categories != null) {
                                for (Category category : categories) {
                        %>

                        <li class="li">
                            <button class="but" type="submit" name="categories"
                                    value="<%=category.toString()%>"><%=category.toString().replaceAll("_", " ").toLowerCase()%>
                            </button>
                        </li>

                        <% }
                        }
                        %>
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