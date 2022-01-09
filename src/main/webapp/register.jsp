<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 03.01.22
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/styles12.css">
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

        <div class="errorMsg">${errorMsg}</div>

        <p>Already have an account?</p>
        <a href="login.jsp">Log in</a>
    </div>
</main>

</body>
</html>
