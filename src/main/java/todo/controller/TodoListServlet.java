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
import todo.model.todoExceptions.InvalidTodoDueDateException;
import todo.model.todoExceptions.InvalidTodoTitleException;
import todo.model.todoExceptions.NoSuchTodoIDException;

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
        ToDo todo = null;
        String msg = "";

        String todoID = request.getParameter("todoID");
        String button = request.getParameter("button");
        String checkbox = request.getParameter("checkbox");
        String category = request.getParameter("category");

        switch (button) {

            case "checkTodo":
                break;
            case "deleteTodo":
                break;
            case "editTodo":
                try{
                    long id = Integer.parseUnsignedInt(todoID);
                    todo = user.getTodoList().getTodo(id);
                } catch (NumberFormatException e) {
                    msg = "Invalid value for Todo ID.";
                } catch (NoSuchTodoIDException e) {
                    msg = e.getMessage();
                }
                request.setAttribute("todo", todo);
                request.setAttribute("message", msg);
                try {
                    request.getRequestDispatcher("todoEdit.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;

        }

    }

    public void destroy() {
    }
}
