<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <title>Add Teacher Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Add teacher details</h1>
            <form:form method="post" modelAttribute="teacher">
            <div>
                Name  :    <form:input type="text" path="name" required="required"/>
                       <form:errors path="name" cssClass="text-warning"/>
            </div>
            <br>
            <div>
                Course : <form:input type="text" path="course" required="required"/>
                         <form:errors path="course" cssClass="text-warning"/>
            </div>
            <br>
                <input type="submit" class="btn btn-success">
            </form:form>
        </div>
        <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
    </body>
</html>