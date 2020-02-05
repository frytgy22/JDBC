<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="template/header.jsp" %>

<body>
<form class="form-signin" method="post" action="${pageContext.request.contextPath}/registration">
    <div class="form-group text-center">
        <img class="mb-4" src="static/images/tit.png" alt="logo">
        <h1 class="h3 mb-3 font-weight-normal">Sign up</h1>

        <%@include file="template/form.jsp" %>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
        <div id="div" class="mt-5 mb-3 text-muted">
            <span>Already have an account? </span><a href="${pageContext.request.contextPath}/"
                                                     class="mt-5 mb-3 text-muted">Sign in</a>
        </div>
    </div>
</form>

</body>
</html>

