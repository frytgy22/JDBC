<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div class="form-group">
    <label for="exampleFormControlSelect1">Categories</label>
    <select name="category" class="form-control" id="exampleFormControlSelect1">

        <c:if test="${!empty(applicationScope.categories)}">
            <c:forEach items="${applicationScope.categories}" var="category">
                <option><c:out value="${category.toString().replaceAll('_',' ')}"/></option>
            </c:forEach>
        </c:if>

    </select>
</div>