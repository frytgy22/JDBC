<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Blog Post</title>

    <!-- Bootstrap core CSS -->
    <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="static/css/blog-home.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/main">Home</a>
        <button type="button" onclick="window.location.href='<%=request.getContextPath()%>/add'"
                class="btn btn-primary btn-lg">Add new post
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <img width="40" src="static/images/2.png" alt="logo">
                </li>
                <li class="nav-item active">
                    <span class="nav-link">${sessionScope.user.login}
                    </span>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-outline-primary"
                            onclick="window.location.href='<%=request.getContextPath()%>/logout'">Logout
                    </button>
                </li>
            </ul>
        </div>
    </div>

</nav>
