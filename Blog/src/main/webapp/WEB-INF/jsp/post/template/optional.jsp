<%@ page import="org.lebedeva.model.post.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="form-group">
    <label for="exampleFormControlSelect1">Categories</label>
    <select name="category" class="form-control" id="exampleFormControlSelect1">
        <%
            Category[] categories = Category.values();
            if (categories != null) {
                for (Category category : categories) {
        %>
        <option><%=category.toString().replaceAll("_", " ")%>
        </option>
        <% }
        }
        %>
    </select>
</div>