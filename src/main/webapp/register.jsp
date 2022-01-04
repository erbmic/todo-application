<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 03.01.22
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/styles2.css">
</head>

<body>

<header>

</header>

<main>

    <div class="loginbox">
        <h1>
            <%= "ToDo App" %>
        </h1>
        <form action="userManager" method="post">
            <input type="text" id="name" name="name" placeholder="Name" required>
            <input type="text" id="lastName" name="lastName" placeholder="Lastname" required>
            <input type="text" id="userName" name="userName" placeholder="Email" required>
            <input type="password" id="password" name="password" placeholder="Password" required>

            <button name="button" value="login">Login</button>
            <button name="button" value="register">Register</button>
        </form>
    </div>
</main>

</body>
</html>
