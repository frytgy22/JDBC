<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div class="form-group">
    <input autofocus name="title" required type="text" class="form-control" value="${requestScope.post.title}"
           placeholder="Title">
</div>

<div class="form-group">
    <label for="exampleFormControlTextarea1"></label>
    <textarea required name="subtitle" placeholder="Subtitle" class="form-control" id="exampleFormControlTextarea1"
              rows="3">${requestScope.post.subtitle}</textarea>
</div>

<c:if test="${!empty(requestScope.post.contents)}">
    <c:forEach begin="0" end="${requestScope.post.contents.size()-1}" var="i">
        <div class="form-group">
            <label for="exampleFormControlTextarea${i+1}"></label>
            <textarea placeholder="Content ${i+1}" name="content${i+1}" class="form-control"
                      id="exampleFormControlTextarea${i+1}" rows="3">${requestScope.post.contents.get(i)}</textarea>
        </div>
    </c:forEach>
</c:if>

<jsp:include page="template/optional.jsp"/>

<button id="button" type="submit" class="btn btn-primary">Submit</button>
