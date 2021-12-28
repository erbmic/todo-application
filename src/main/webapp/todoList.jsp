<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 11.12.21
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ToDo App</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<main>
    <div class="todolist">
        <h1>ToDo List</h1>
        <div>List of ${user.userName}</div>
        <div>List of ${user.password}</div>
        <c:forEach items = "${user.toDos.todos}" var="todo">
            <c:out value = "${todo.title}"/><p>
        </c:forEach>
    </div>
</main>

</body>
</html>