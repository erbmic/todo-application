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
    <link rel="stylesheet" href="css/styles18.css">
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
                    <form action="todoManager" method="post">
                        <ul>
                            <c:forEach items="${user.todoList.todos}" var="todo">
                                <li>
                                    <button name="button" value="${todo.title}">${todo.title}</button>
                                </li>
                            </c:forEach>
<%--                            <li>--%>
<%--                                <button name="button" value="home">Home</button>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="important">Important</button>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="learning">Learning</button>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="people">People</button>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="school">School</button>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="shopping">Shopping</button>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <button name="button" value="work">Work</button>--%>
<%--                            </li>--%>
                        </ul>
                    </form>
                </div>


                <form class="todoListMenuForm" action="todoManager" method="post">
                    <div class="button"><a href="todoEdit.jsp">Add todo</a></div>
                </form>
            </div>

            <form action="todoManager" method="post">
                <div class="todolist">
                    <table>

                        <thead>
                        <tr>
                            <th class="center" id="th-check"></th>
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
                                            value="${todo.title}"><c:if test="${todo.done}"><i
                                            class="fas fa-check"></i></c:if></button>
                                </td>

                                    <%--                                <td class="center" id="td-check"><input class="checkbox" type="checkbox" name="checkbox" value="${todo.done}"--%>
                                    <%--                                                                        <c:if test="${todo.done}">checked</c:if>/></td>--%>
                                <td id="td-title">${todo.title}</td>

                                <td class="center" id="td-category">
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

                                <td id="td-date">${todo.important}</td>

                                <td class="center" id="td-delete">
                                    <button id="deleteTodoButton" name="todoID" value="${todo.id}"><i class="far fa-trash-alt"></i></button>
                                </td>

                                <td class="center" id="td-edit">
                                    <button id="editTodoButton" name="todoID" value="${todo.id}"><i class="fas fa-ellipsis-h"></i></button>
<%--                                    <button id="editTodoButton" name="todoID" value="${todo.id}"><i class="fas fa-pen"></i></button>--%>
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