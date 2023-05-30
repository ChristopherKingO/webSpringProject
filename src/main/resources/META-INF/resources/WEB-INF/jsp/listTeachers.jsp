<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <title>List of Teachers</title>
    </head>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1> ${username} this is the list of teachers : </h1>
            <hr>
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Course</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${teachers}" var="teachers">
                    <tr>
                        <td>${teachers.name}</td>
                        <td>${teachers.course}</td>
                        <td><a href="remove-teacher?id=${teachers.id}" class="btn btn-warning">Remove </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
            <a href="add-teacher" class="btn btn-success">Add Teacher</a>
        </div>
        <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
    </body>
</html>