<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <title>List of Students</title>
    </head>
    <body>
        <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1> ${username} this is the list of students : </h1>
            <hr>
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>StudyYear</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="students">
                    <tr>
                        <td>${students.name}</td>
                        <td>${students.studyYear}</td>
                        <td><a href="remove-student?id=${students.id}" class="btn btn-warning">Remove </td>
                        <td><a href="update-student?id=${students.id}" class="btn btn-success">Update </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
            <a href="add-student" class="btn btn-success">Add Student</a>
        </div>
        <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
    </body>
</html>