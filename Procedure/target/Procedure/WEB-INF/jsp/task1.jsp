<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/1.css">
</head>
<body>
<div class="parent">
    <div class="block">
        <form class="box" action="<%=request.getContextPath()%>/task1" method="post">
            <h2>Enter first and second movie ID:</h2>
            <hr>
            <aside>
                <label><input type="number" min="1" placeholder="Id from" name="from" autofocus required/></label>

                <label><input type="number" min="1" placeholder="Id to" name="to" required/></label>

                <label><input id="submit" class="box" type="submit" value="SUBMIT"/></label>
            </aside>
        </form>
    </div>
</div>
</body>
</html>