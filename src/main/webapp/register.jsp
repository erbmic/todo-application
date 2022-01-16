<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 03.01.22
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/styles22.css">
</head>

<body>

<header>

</header>

<main>

    <div class="loginbox">
        <h1>
            ToDo App
        </h1>

        <form action="userManager" method="post">
            <label for="name"></label><input type="text" id="name" name="name" placeholder="Name" required>
            <label for="lastName"></label><input type="text" id="lastName" name="lastName" placeholder="Lastname" required>
            <label for="userName"></label><input type="text" id="userName" name="userName" placeholder="Username" required>
            <label for="password"></label><input type="password" id="password" name="password" placeholder="Password" required>
            <label for="passwordC"></label><input type="password" id="passwordC" name="passwordC" placeholder="Confirm Password" required>
            <button name="button" value="register">Register</button>
        </form>

        <div class="errorMsg"><c:if test="${not empty message}"><i class="fas fa-exclamation-circle"></i></c:if> ${message}</div>

        <p>Already have an account?</p>
        <a href="login.jsp">Log in</a>
    </div>
</main>

</body>
</html>
