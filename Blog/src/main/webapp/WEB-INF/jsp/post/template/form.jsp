<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="form-group">
    <input autofocus name="title" required type="text" class="form-control" value="${requestScope.post.title}"
           placeholder="Title">
</div>

<div class="form-group">
    <label for="exampleFormControlTextarea1"></label>
    <textarea required name="subtitle" placeholder="Subtitle" class="form-control" id="exampleFormControlTextarea1"
              rows="3">${requestScope.post.subtitle}</textarea>
</div>

<%
    if (post.getContents() != null) {
        for (int i = 0; i < post.getContents().size(); i++) {
%>

<div class="form-group">
    <label for="exampleFormControlTextarea<%=i+1%>"></label>
    <textarea placeholder="Content <%=i+1%>" name="content<%=i+1%>" class="form-control"
              id="exampleFormControlTextarea<%=i+1%>" rows="3"><%=post.getContents().get(i)%></textarea>
</div>

<%
        }
    }
%>
<jsp:include page="template/optional.jsp"/>

<button id="button" type="submit" class="btn btn-primary">Submit</button>
