<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "ToDo Webapplication" %>
</h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--<form action="userManager" method="post">--%>
<%--    <label for="userName">First name:</label><br>--%>
<%--    <input type="text" id="userName" name="userName" value="John"><br>--%>
<%--    <label for="password">Last name:</label><br>--%>
<%--    <input type="text" id="password" name="password" value="Doe"><br><br>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>


<form action="userManager" method="post">
    <input type="text" id="userName" name="userName" placeholder="Username" required><br><br>
    <input type="text" id="password" name="password" placeholder="Password" required><br><br>

    <button name="button" value="login">Login</button>
    <button name="button" value="register">Register</button>
</form>

</body>
</html>