package todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import todo.model.Account;
import todo.model.Category;
import todo.model.ToDo;
import todo.model.User;

import java.io.IOException;

@WebServlet(name = "TodoListServlet", value = "/todoList")
public class TodoListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String id = request.getParameter("todoID");
        String button = request.getParameter("button");
        String checkbox = request.getParameter("checkbox");
        String category = request.getParameter("category");

        switch (button) {
            case "addTodoButton":
                //ToDo newTodo =new ToDo("");
                //request.setAttribute("Todo", newTodo);
                try {
                    request.getRequestDispatcher("todoEdit.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    public void destroy() {
    }
}
