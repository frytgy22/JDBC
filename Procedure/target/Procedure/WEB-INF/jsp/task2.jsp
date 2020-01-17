<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/1.css">
</head>
<body>
<div class="parent">
    <div class="block">
        <form class="box" action="<%=request.getContextPath()%>/task2" method="post">
            <h2>Enter the old and new movie genres:</h2>
            <hr>
            <aside>
                <label><input placeholder="Old genre" name="old" autofocus required/></label>

                <label><input placeholder="New genre" name="new" required/></label>

                <label><input id="submit" class="box" type="submit" value="SUBMIT"/></label>
            </aside>
        </form>
    </div>
</div>
</body>
</html>