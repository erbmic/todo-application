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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
</head>
<body>

<div class="container">

    <nav>Navbar</nav>

    <div class="headbox">
        <h1>Listo of "${user.userName}"</h1>
        <div class="headtext">
            <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore
                et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea
                rebum.</p>
        </div>
    </div>

    <main>


        <div class="todolist">
            <table>
                <thead>
                <tr>
                    <th></th>
                    <th colspan="2">Title</th>
                    <th class="center">Category</th>
                    <th>Date</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user.toDos.todos}" var="todo">
                    <tr>
                        <td class="center"><input class="checkbox" type="checkbox"
                                                  <c:if test="${todo.done}">checked</c:if>/></td>
                        <td colspan="2">${todo.title}</td>
                        <td class="center">${todo.done}</td>
                        <td>${todo.important}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

    </main>
    <footer>footer</footer>
</div>

</body>
</html>