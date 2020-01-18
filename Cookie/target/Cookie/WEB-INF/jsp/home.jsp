<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/home.css">
    <script src="https://code.jquery.com/jquery-2.1.0.js"></script>
</head>
<body>
<div class="box effect5">
    <div id="wrap">
        <img id="up" src="<%=request.getContextPath()%>/static/images/1.png" alt="up">
        <form action="<%=request.getContextPath()%>/" method="post">
            <div id="container">
                <label>
                    <input required placeholder="Login" name="login" maxlength="20"
                           pattern="[^А-Яа-я\s]+" title="only latin letters, numbers, symbols">
                </label>
                <label>
                    <input required type="email" placeholder="email" name="email" maxlength="20">
                </label>
                <label>
                    <input required type="password" placeholder="password" name="password" maxlength="20"
                           pattern="[^А-Яа-я\s]+" title="only latin letters, numbers, symbols">
                </label>
            </div>
            <input class="button25" value="Sing up" type="submit">
        </form>
        <div id="infoERROR">
            <p>Registration failed. User already exists.</p>
        </div>
    </div>
</div>
</body>
</html>
