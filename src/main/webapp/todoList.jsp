<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 11.12.21
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ToDo list</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/styles22.css">
</head>
<body>

<div class="container">

    <!-- MENU NAV -->
    <nav>
        <div class="navBox">
            <div class="navBarLogo">
                <form id="navBarLogo" action="todoList" method="post">
                    <button id="homeButton" name="button" value="logout"><i class="fas fa-check"></i> isto</button>
                </form>
            </div>
            <div class="navBarMenuForm">
                <form id="navLogoutMenuForm" action="todoList" method="post">
                    <button id="logoutButton" name="button" value="logout">Sign out</button>
                </form>

            </div>
        </div>
    </nav>
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
            <div class="todoMenu">
                <div class="errorMsg"><c:if test="${not empty message}"><i class="fas fa-exclamation-circle"></i></c:if> ${message}</div>

                <div class="catDropdown">
                    <button id="categoryDropdownButton" class="categoryDropdown"><i class="fas fa-filter"></i>Category<i
                            class="fas fa-chevron-down"></i></button>
                    <form action="todoList" method="post">
                        <ul>
                            <li>
                                <button name="button" value="displayAll">reset filter</button>
                            </li>
                            <c:forEach items="${user.todoList.todos}" var="todo">
                                <li>
                                    <button name="button" value="${todo.category}">${todo.category}</button>
                                </li>
                            </c:forEach>
                        </ul>
                    </form>
                </div>
<%--                <div class="button"><a href="todoEdit.jsp">Add todo</a></div>--%>
                <div class="button"><a href="todoEdit.jsp"><i class="fas fa-plus"></i></a></div>
            </div>

            <form action="todoList" method="post">
                <div class="todolist">
                    <table>

                        <thead>
                        <tr>
                            <th class="center" id="th-check"></th>
                            <th id="th-id" class="unvisible"></th>
                            <th id="th-title">Title</th>
                            <th class="center" id="th-category">Category</th>
                            <th class="center" id="th-important">Important</th>
                            <th id="th-date">Due Date</th>
                            <th class="center" id="th-delete"></th>
                            <th class="center" id="th-edit"></th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${user.todoList.todos}" var="todo">

                            <tr class=<c:if test="${todo.done}">red</c:if>>
                                <td class="center" id="td-check">
                                    <button class="checkTodoButton" name="button"
                                            value="checkTodo"><c:if test="${todo.done}"><i
                                            class="fas fa-check"></i></c:if></button>
                                </td>

                                <td id="td-id" class="unvisible">
                                    <label>
                                        <input name="todoID" value="${todo.id}"/>
                                    </label>
                                </td>

                                <td id="td-title">${todo.title}</td>

                                <td class="center" id="td-category">
                                    <c:choose>
                                        <c:when test="${todo.category == 'Home'}">
                                            <i class="fas fa-home"></i>
                                        </c:when>
                                        <c:when test="${todo.category == 'People'}">
                                            <i class="fas fa-users"></i>
                                        </c:when>
                                        <c:when test="${todo.category == 'School'}">
                                            <i class="fas fa-graduation-cap"></i>
                                        </c:when>
                                        <c:when test="${todo.category == 'Shopping'}">
                                            <i class="fas fa-shopping-cart"></i>
                                        </c:when>
                                        <c:when test="${todo.category == 'work'}">
                                            <i class="fas fa-briefcase"></i>
                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>
                                    </c:choose>
                                </td>

                                <td class="center" id="td-important"><c:if test="${todo.important}"><i
                                        class="fas fa-exclamation-circle"></i></c:if></td>

                                <td id="td-date">${todo.dueDate}</td>

                                <td class="center" id="td-delete">
                                    <button id="deleteTodoButton" name="button" value="deleteTodo"><i
                                            class="far fa-trash-alt"></i></button>
                                </td>

                                <td class="center" id="td-edit">
                                    <button id="editTodoButton" name="button" value="editTodo"><i
                                            class="fas fa-ellipsis-h"></i></button>
                                        <%--                                    <button id="editTodoButton" name="todoID" value="${todo.id}"><i class="fas fa-pen"></i></button>--%>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </form>

        </div>

    </main>
    <footer></footer>
</div>

</body>
</html>