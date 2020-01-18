<%@ page import="java.util.Arrays" %>

<%
    String id = Arrays.stream(request.getCookies())
            .filter(cookie -> "userId".equals(cookie.getName()))
            .map(Cookie::getValue)
            .findFirst().orElse("");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <p>ID: <%=id%></p>
</body>
</html>
