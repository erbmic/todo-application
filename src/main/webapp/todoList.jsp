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
    <link rel="stylesheet" href="css/styles16.css">
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


            <div class="todoMenu">
                <div class="catDropdown">
                    <button id="categoryDropdownButton" class="categoryDropdown"><i class="fas fa-filter"></i>Category<i
                            class="fas fa-chevron-down"></i></button>
                    <form action="todoList" method="post">
                        <ul>
                            <li>
                                <button name="button" value="addTodoButton">Add todo</button>
                            </li>
                            <li>
                                <button name="button" value="addTodoButton">Add todo</button>
                            </li>
                            <li>
                                <button name="button" value="addTodoButton">Add todo</button>
                            </li>
                        </ul>
                    </form>
                </div>


                <form class="todoListMenuForm" action="todoList" method="post">
<%--                    <select class="categoryDropdown" name="category">--%>
<%--                        <option selected>Category</option>--%>
<%--                        <option>Work</option>--%>
<%--                        <c:forEach items="${user.todoList.todos}" var="categories">--%>
<%--                            <option value="${categories.title}">${categories.title}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>

<%--                    <label class="dropdown">--%>

<%--                        <div class="dd-button">--%>
<%--                            <i class="fas fa-filter"></i> Category--%>
<%--                        </div>--%>

<%--                        <input type="checkbox" class="dd-input" id="test">--%>

<%--                        <ul class="dd-menu">--%>
<%--                            <li>Action</li>--%>
<%--                            <li>Ano</li>--%>
<%--                            <li>Snge</li>--%>
<%--                            <li><i class="fas fa-briefcase"></i>Work</li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="addTodoButton">Add todo</button>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="addTodoButton">Add todo</button>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="addTodoButton">Add todo</button>--%>
<%--                            </li>--%>
<%--                        </ul>--%>

<%--                    </label>--%>

<%--                    <button name="button" value="addTodoButton">Add todo</button>--%>
                    <div class="button"><a href="todoEdit.jsp">Add todo</a></div>

                </form>
            </div>

            <form action="todoList" method="post">
                <div class="todolist">
                    <table>

                        <thead>
                        <tr>
                            <th class="center" id="th-check"></th>
                            <th id="th-title">Title</th>
                            <th class="center" id="th-category">Category</th>
                            <th class="center" id="th-important">Important</th>
                            <th id="th-date">Due Date</th>
                            <th class="center" id="th-edit"></th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${user.todoList.todos}" var="todo">
                            <tr>
                                <td class="center" id="td-check">
                                    <button class="checkTodoButton" name="button"
                                            value="${todo.title}"><c:if test="${todo.done}"><i
                                            class="fas fa-check"></i></c:if></button>
                                </td>

                                    <%--                                <td class="center" id="td-check"><input class="checkbox" type="checkbox" name="checkbox" value="${todo.done}"--%>
                                    <%--                                                                        <c:if test="${todo.done}">checked</c:if>/></td>--%>
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

                                        </c:otherwise>
                                    </c:choose>
                                </td>

                                <td class="center" id="td-important"><c:if test="${todo.important}"><i
                                        class="fas fa-exclamation-circle"></i></c:if></td>

                                <td id="td-date">${todo.dueDate}</td>

                                <td class="center" id="td-edit">
                                    <button id="editTodoButton" name="todoID" value="${todo.id}"><i class="fas fa-ellipsis-h"></i></button>
                                </td>

<%--                                <td class="center" id="td-edit"><a href="todoEdit.jsp">--%>
<%--                                    <i class="fas fa-ellipsis-h"></i></a>--%>
<%--                                </td>--%>
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