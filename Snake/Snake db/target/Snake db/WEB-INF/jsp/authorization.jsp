<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/registration.css">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/images/snake.png" type="image/png">
    <script src="https://code.jquery.com/jquery-2.1.0.js"></script>
</head>

<body>
<div class="block">
    <img id="snake" src="<%=request.getContextPath()%>/static/images/3(1).png" alt="snake">
    <form action="<%=request.getContextPath()%>/authorization" method="post">
        <div>
            <label for="login">Login</label><br>
            <input class="box" name="login" id="login" maxlength="20" required autofocus/>
        </div>
        <div>
            <label for="password">Password</label><br>
            <input type="password" name="password" id="password" maxlength="20" required/>
        </div>
        <input type="submit" value="Sign in"/>
        <footer>
            <span>Don't have an account?</span>
            <a href="http://localhost:8080<%=request.getContextPath()%>">Sign up</a>
        </footer>
    </form>
    <div id="infoERROR">
        <p>Wrong login or password.</p>
    </div>
</div>
</body>

</html>
