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
    <link rel="stylesheet" href="css/styles3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
</head>
<body>

<div class="container">

    <!-- MENU NAV -->
    <nav></nav>
    <!-- END MENU NAV -->

    <!-- HEADBOX -->
    <div class="headbox">
        <h1>Listo of "${user.userName}"</h1>
        <div class="headtext">
            <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore
                et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea
                rebum.</p>
        </div>
    </div>
    <!-- END HEADBOX -->

    <main>

        <div class="todolistBox">

            <div class="editMenu">
                <form action="XXXXXXXX" method="post">
                    <select class="categories" name="category">
                        <option selected>Category</option>
<%--                        <option>House</option>--%>
<%--                        <option>Work</option>--%>
                        <c:forEach items="${user.toDos.todos}" var="categories">
                            <option value="${categories.title}">${categories.title}</option>
                        </c:forEach>
                    </select>
                    <button name="button" value="register">Create</button>
                </form>
            </div>

            <div class="todolist">
                <table>

                    <thead>
                    <tr>
                        <th id="th-check"></th>
                        <th id="th-title">Title</th>
                        <th class="center" id="th-category">Category</th>
                        <th id="th-date">Date</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${user.toDos.todos}" var="todo">
                        <tr>
                            <td class="center" id="td-check"><input class="checkbox" type="checkbox"
                                                                    <c:if test="${todo.done}">checked</c:if>/></td>
                            <td id="td-title">${todo.title}</td>


                            <td class="center" id="td-done">
                                <c:choose>

                                    <c:when test="${todo.title == 'house'}">
                                        <i class="fas fa-home"></i>
                                    </c:when>

                                    <c:when test="${todo.title == 'work'}">
                                        <i class="fas fa-briefcase"></i>
                                    </c:when>

                                    <c:otherwise>
                                        No comment sir...
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <td id="td-important">${todo.important}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>

    </main>
    <footer></footer>
</div>

</body>
</html>