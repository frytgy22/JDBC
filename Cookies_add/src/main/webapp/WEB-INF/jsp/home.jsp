<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%Cookie[] cookies = request.getCookies();%>

<html>
<head>
    <title>Cookie</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/home.css">
    <script src="<%=request.getContextPath()%>/static/js/home.js"></script>
    <script src="https://code.jquery.com/jquery-2.1.0.js"></script>
</head>
<body>

<% if (cookies != null) {%>
<ul id="ul"><h3>Cookies</h3>
    <% for (Cookie cookie : cookies) { %>
    <li><p><%=cookie.getName()%>
    </p>
        <span class="delete">delete</span>
        <span class="edit">edit</span></li>
    <% }
    } %>
</ul>


<form id="addForm" action="<%=request.getContextPath()%>/add" method="post">
    <h3>Add cookie</h3>
    <label><input class="width" required autofocus placeholder="Name" name="name" maxlength="20"></label>
    <jsp:include page="formTemplate.jsp"/>
    <input type="submit" value="add cookie">
</form>


<form id="editForm" action="<%=request.getContextPath()%>/edit" method="post">
    <h3 id="info"></h3>
    <input type="hidden" id="name" name="name">
    <jsp:include page="formTemplate.jsp"/>
    <input type="submit" value="edit cookie">
    <a href="<%=request.getContextPath()%>/"><p>cancel</p></a>
</form>


<form id="deleteForm" action="<%=request.getContextPath()%>/delete" method="post">
    <label><input id="key" name="key"></label>
</form>

</body>
</html>
