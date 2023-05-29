<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <title>Login Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Login : </h1>
            <form method="post">
                Username : <input type="text" name="username">
                Password : <input type="text" name="password">
            <input type="submit">
            </form>
            <post> ${errorMessage}</post>
        </div>
    </body>
</html>