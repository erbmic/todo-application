<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>ToDo App</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/styles24.css">
</head>

<body>

<header>
</header>

<!-- MAIN -->
<main>

    <!-- LOGINBOX -->
    <div class="loginbox">
        <h1>
            ToDo App
        </h1>

        <form action="userManager" method="post">
            <label for="userName"></label><input type="text" id="userName" name="userName" placeholder="Username" required>
            <label for="password"></label><input type="password" id="password" name="password" placeholder="Password" required>
            <button name="button" value="login">Login</button>
        </form>

        <div class="errorMsg"><c:if test="${not empty message}"><i class="fas fa-exclamation-triangle"></i></c:if> ${message}</div>

        <p>Don't have an account?</p>
        <a href="register.jsp">Sign up</a>
    </div>
    <!-- END LOGINBOX -->

</main>
<!-- END MAIN -->

</body>
</html>