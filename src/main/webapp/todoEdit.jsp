<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 06.01.22
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Edit view</title>
    <link rel="stylesheet" href="css/styles19.css">
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

            <div class="editBox">

                <div class="editMenu">
                    <form class="editMenuForm" action="todoEdit" method="post">
                        <c:if test="${not empty todo.id}">
                        <button id="deleteTodoButton" name="button" value="deleteTodo"><i
                                class="far fa-trash-alt"></i></c:if>
                            <%--                        <button id="deleteTodoButton" name="button" value="delete"><i class="far fa-trash-alt"></i>--%>
                        </button>
                        <button id="saveTodoButton" name="button" value="saveTodo"><i class="far fa-save"></i></button>
                        <button id="closeButton" name="button" value="closeTodo"><i class="fas fa-times"></i></button>
                        <%--                    </form>--%>
                </div>

                <div class="editTodoForm">
                    <div class="unvisible">
                        <label>
                            <input name="todoID" value="${todo.id}"/>
                        </label>
                    </div>
                    <%--                    <form action="todoManager" method="post">--%>
                    <div class="oneLine">
                        <input class="checkbox" type="checkbox"
                               id="editImportant"
                               name="editImportant"
                               value="editImportant"/><label for="editImportant">Important</label>

                        <c:if test="${not empty todo.id}">
                            <input class="checkbox" type="checkbox"
                                   id="editCompletion"
                                   name="editCompletion"
                                   value="editCompletion" <c:if test="${todo.done}">checked</c:if>/><label
                                for="editCompletion">Completion</label></c:if>
                    </div>
                    <%--value="${user.userName}"--%>
                    <label for="editTitle">Title*</label><input type="text" id="editTitle" name="title"
                                                                placeholder="title" value="${user.userName}"
                                                                maxlength="50">

                    <div class="oneLine">
                        <c:set var="today" value="<%=new java.util.Date()%>"/>
                        <div id="editDueDate">
                            <label for="editDueDate">Due Date</label><input type="date" id="editDueDateInput"
                                                                            name="dueDate"
                                                                            min=<fmt:formatDate
                                pattern="yyyy-MM-dd" value="<%=new java.util.Date()%>"/>>
                        </div>

                        <div id="editCategoryDropdown">
                            <label for="editCategoryDropdownSelect">Category</label><select class="categoryDropdown"
                                                                                            id="editCategoryDropdownSelect"
                                                                                            name="category">
                            <option>Category</option>
                            <option <c:if test="${todo.category == 'Home'}">selected</c:if>>Home</option>
                            <option <c:if test="${todo.category == 'Important'}">selected</c:if>>Important</option>
                            <option <c:if test="${todo.category == 'Learning'}">selected</c:if>>Learning</option>
                            <option <c:if test="${todo.category == 'People'}">selected</c:if>>People</option>
                            <option <c:if test="${todo.category == 'School'}">selected</c:if>>School</option>
                            <option <c:if test="${todo.category == 'Shopping'}">selected</c:if>>Shopping</option>
                            <option <c:if test="${todo.category == 'Work'}">selected</c:if>>Work</option>
                            <%--                            <c:forEach items="${user.todoList.todos}" var="categories">--%>
                            <%--                                <option value="${categories.title}">${categories.title}</option>--%>
                            <%--                            </c:forEach>--%>

                        </select>
                        </div>
                    </div>

                    <label for="editDescription">Description</label><input type="text" id="editDescription"
                                                                           name="editDescription"
                                                                           placeholder="description">
                    </form>

                </div>
            </div>
        </div>

    </main>

    <footer></footer>

</div>


</body>
</html>
