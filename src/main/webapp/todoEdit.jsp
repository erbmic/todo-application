<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 06.01.22
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit view</title>
    <link rel="stylesheet" href="css/styles7.css">
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
                    <form class="editMenuForm" action="todoManager" method="post">
                        <a href="todoList.jsp">
                            <button id="saveButton" name="button" value="close"><i class="far fa-save"></i></button>
                        </a>
                        <a href="todoList.jsp">
                            <button id="closeButton" name="button" value="close"><i class="fas fa-times"></i></button>
                        </a>
                    </form>
                </div>

                <div class="editTodoForm">

                    <form action="todoManager" method="post">
                        <label for="editImportant"></label><input class="checkbox" type="checkbox" id="editImportant"
                                                                name="editImportant" value="editImportant"/>

                        <label for="editTitle">Title</label><input type="text" id="editTitle" name="editTitle"
                                                              placeholder="title" required>

                        <div class="oneLine">
                            <label for="editDueDate"></label><input type="date" id="editDueDate" name="editDueDate"
                                                                    value="2018-07-22"
                                                                    min="2018-01-01" max="2018-12-31"
                                                                    placeholder="due date">

                            <label for="editCategoryDropdown"></label><select class="categoryDropdown"
                                                                              id="editCategoryDropdown" name="category">
                            <option selected>Category</option>
                            <option>Work</option>
                            <c:forEach items="${user.todoList.todos}" var="categories">
                                <option value="${categories.title}">${categories.title}</option>
                            </c:forEach>
                             </select>
                        </div>


                        <label for="editDescription"></label><input type="text" id="editDescription"
                                                                    name="editDescription" placeholder="description"
                                                                    required>
                    </form>

                </div>

            </div>

        </div>

    </main>
    <footer></footer>
</div>


</body>
</html>
