package todo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import todo.model.User;

import java.io.IOException;

@WebServlet(name = "TodoFilterServlet", value = "/todoFilter")
public class TodoFilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String button = request.getParameter("button");

        user.getTodoList().filterTodos(button);
        response.sendRedirect("todoList.jsp");

    }
}
