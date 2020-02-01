<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="template/head.jsp" %>

<!-- Page Content -->
<div class="container">

    <div class="row">
        <!-- Blog Entries Column -->

        <div class="col-md-8">

            <form class="form" action="<%=request.getContextPath()%>/add" method="post">
                <h3>New post:</h3>
                <div class="form-group">
                    <input autofocus name="title" required type="text" class="form-control" placeholder="Title">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1"></label>
                    <textarea required name="subtitle" placeholder="Subtitle" class="form-control"
                              id="exampleFormControlTextarea1" rows="1"></textarea>
                </div>

                <%for (int i = 1; i < 6; i++) {%>
                <div class="form-group"><label for="exampleFormControlTextarea<%=i%>"></label><textarea rows="3"
                        placeholder="Content <%=i%>" name="content<%=i%>" class="form-control"
                              id="exampleFormControlTextarea<%=i%>"></textarea></div>
                        <%
                    }
                %>

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
