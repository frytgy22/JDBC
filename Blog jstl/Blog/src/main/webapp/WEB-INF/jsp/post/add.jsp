<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/head.jsp" %>

<!-- Page Content -->
<div class="container">

    <div class="row">
        <!-- Blog Entries Column -->

        <div class="col-md-8">

            <form class="form" action="${pageContext.request.contextPath}/add" method="post">
                <h3>New post:</h3>
                <div class="form-group">
                    <input autofocus name="title" required type="text" class="form-control" placeholder="Title">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1"></label>
                    <textarea required name="subtitle" placeholder="Subtitle" class="form-control"
                              id="exampleFormControlTextarea1" rows="1"></textarea>
                </div>

               <c:forEach begin="1" end="5" var="j">
                <div class="form-group"><label for="exampleFormControlTextarea${j}"></label><textarea rows="3"
                        placeholder="Content ${j}" name="content${j}" class="form-control"
                              id="exampleFormControlTextarea${j}"></textarea></div>
               </c:forEach>

                   <jsp:include page="template/optional.jsp"/>

                    <button id="button" type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>

        <%@include file="template/sidebar.jsp" %>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<%@include file="template/footer.jsp" %>
