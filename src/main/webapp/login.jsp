<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>ToDo App</title>
    <link rel="stylesheet" href="css/styles2.css">
</head>

<body>

<header>

</header>

<main>
<%--    <h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</h5>--%>

    <div class="loginbox">
        <h1>
            <%= "ToDo App" %>
        </h1>

        <form action="userManager" method="post">
            <label for="userName"></label><input type="text" id="userName" name="userName" placeholder="Email" required>
            <label for="password"></label><input type="password" id="password" name="password" placeholder="Password" required>
            <button name="button" value="login">Login</button>
        </form>

        <p>Don't have an account?</p>
        <a href="register.jsp">Sign up</a>
    </div>
</main>

</body>
</html>