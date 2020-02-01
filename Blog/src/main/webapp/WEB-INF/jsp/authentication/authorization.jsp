<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="template/header.jsp" %>

<body>
<form class="form-signin" method="post" action="<%=request.getContextPath()%>/">
    <div class="form-group text-center">
        <img class="mb-4" src="static/images/tit.png" alt="logo">
        <h1 class="h3 mb-3 font-weight-normal">Sign in</h1>

        <jsp:include page="template/form.jsp"/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <div id="div" class="mt-5 mb-3 text-muted">
            <span>New to Blog? </span><a href="<%=request.getContextPath()%>/registration"
                                         class="mt-5 mb-3 text-muted">Create an account</a>
        </div>
    </div>
</form>

</body>
</html>