<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>ToDo App</title>
    <link rel="stylesheet" href="css/styles17.css">
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
            <label for="userName"></label><input type="text" id="userName" name="userName" placeholder="Username" required>
            <label for="password"></label><input type="password" id="password" name="password" placeholder="Password" required>
            <button name="button" value="login">Login</button>
        </form>
        <div class="errorMsg"><i class="fas fa-exclamation-circle"></i>${errorMsg}</div>

        <p>Don't have an account?</p>
        <a href="register.jsp">Sign up</a>
    </div>
</main>

</body>
</html>