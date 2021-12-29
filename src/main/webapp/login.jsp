<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>ToDo App</title>
    <link rel="stylesheet" href="css/css_style.css">
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
            <input type="text" id="userName" name="userName" placeholder="Email" required><br><br>
            <input type="password" id="password" name="password" placeholder="Password" required><br><br>

            <button name="button" value="login">Login</button>
            <button name="button" value="register">Register</button>
        </form>
    </div>
</main>

</body>
</html>