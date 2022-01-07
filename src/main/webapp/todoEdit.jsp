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
    <link rel="stylesheet" href="css/styles6.css">
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
                <form class="editMenuForm" action="todoManager" method="post">
                    <a href="todoList.jsp">
                        <button id="saveButton" name="button" value="close"><i class="far fa-save"></i></button>
                    </a>
                    <a href="todoList.jsp">
                        <button id="closeButton" name="button" value="close"><i class="fas fa-times"></i></button>
                    </a>
                </form>
            </div>

            <div class="createTodoForm">

                <form action="todoManager" method="post">
                    <label for="cf-name"></label><input type="text" id="cf-name" name="name" placeholder="Name" required>
                    <label for="cf-password"></label><input type="password" id="cf-password" name="password" placeholder="Password" required>
<%--                    <label for="cf-password"></label><input type="password" id="cf-password" name="password" placeholder="Password" required>--%>
                </form>

            </div>

        </div>

    </main>
    <footer></footer>
</div>


</body>
</html>
