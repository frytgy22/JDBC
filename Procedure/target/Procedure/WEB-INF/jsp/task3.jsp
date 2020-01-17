<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/1.css">
</head>
<body>
<div class="parent">
    <div class="block">
        <form class="box" action="<%=request.getContextPath()%>/task3" method="post">
            <h2>Remove all producers from the Directors table, on
                which there are no links from the Movies table?</h2>
            <hr>
            <aside>
                <label><input id="submit" class="box" type="submit" value="SUBMIT"/></label>
            </aside>
        </form>
    </div>
</div>
</body>
</html>