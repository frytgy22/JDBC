<%@ page import="domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Snake</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/game.css">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/images/snake.png" type="image/png">
    <script src="<%=request.getContextPath()%>/static/js/game.js"></script>
</head>
<body>
<aside>
    <section id="logoSection">
        <img id="logoImg" src="<%=request.getContextPath()%>/static/images/logo.png" alt="logo">
        <span>${sessionScope.user.login}</span>
    </section>
    <section id="coinsSection">
        <span id="coins">${sessionScope.user.coins}</span>
        <img id="coinImg" src="<%=request.getContextPath()%>/static/images/coin.png" alt="coin">
    </section>
</aside>
<canvas id="game" width="608" height="608"></canvas>

<form action="<%=request.getContextPath()%>/game" method="post">
    <label><input name="coins" id="valueCoins" value="0"/></label>
    <input id="submit" type="submit" value="save coins"/>
</form>

<button id="hw" onclick="location.href='http://localhost:8080<%=request.getContextPath()%>/hw'"
        disabled="disabled">download hw
</button>

<input type="button" onclick="location.href='http://localhost:8080<%=request.getContextPath()%>'" value="logout"/>
</body>
</html>
