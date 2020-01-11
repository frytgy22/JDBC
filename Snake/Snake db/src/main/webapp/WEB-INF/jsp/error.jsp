<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/images/404lit.png" type="image/png">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/error.css">
</head>
<body>
<main>
    <img id="error" src="<%=request.getContextPath()%>/static/images/error.png" alt="404">
</main>
<section>
    <a href="http://localhost:8080<%=request.getContextPath()%>"><p>Return to the homepage</p></a>
</section>
</body>
</html>