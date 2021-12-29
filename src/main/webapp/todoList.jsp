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
    <link rel="stylesheet" href="css/css_style.css">
</head>
<body>

<div class="container">
    <nav>Navbar</nav>
    <div class="headbox">
        <h1>Listo of "${user.userName}"</h1>
    </div>
    <main>

        <div class="todolist">

            <div class="tableHeadings">
                <span class="heading">Title</span>
                <span class="heading">Category</span>
                <span class="heading">Date</span>
            </div>

                <table>
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th class="center">Category</th>
                        <th class="center">Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${user.toDos.todos}" var="todo">
                    <tr>
                        <td>${todo.title}</td>
                        <td class="center">${todo.done}</td>
                        <td class="center">${todo.important}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <%--            <c:out value="${todo.title}"/><p>--%>
                <%--            <c:out value="${todo.done}"/><p>--%>
                <%--            <c:out value="${todo.important}"/><p>--%>
        </div>

    </main>
    <footer>footer</footer>
</div>

</body>
</html>