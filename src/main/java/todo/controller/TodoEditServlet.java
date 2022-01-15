package todo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import todo.model.User;
import todo.model.todoExceptions.InvalidTodoDueDateException;
import todo.model.todoExceptions.InvalidTodoTitleException;
import todo.model.todoExceptions.NoSuchTodoIDException;

import java.io.IOException;

@WebServlet(name = "TodoEditServlet", value = "/todoEdit")
public class TodoEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String msg = "";

        String button = request.getParameter("button");
        String todoID = request.getParameter("todoID");
        String todoDone = request.getParameter("done");
        String todoTitle = request.getParameter("title");
        String todoImportant = request.getParameter("editImportant");
        String todoDueDate = request.getParameter("dueDate");
        String todoCategory = request.getParameter("category");
        String todoDescription = request.getParameter("description");

        switch (button) {
            case "save":
                if (todoID == null){
                    try {
                        user.getTodoList().addTodo(todoTitle, todoImportant, todoDueDate, todoCategory, todoDescription);
                        msg = "New Todo added.";
                    } catch (InvalidTodoTitleException | InvalidTodoDueDateException e) {
                        msg = e.getMessage();
                    }
                } else {
                    try{
                        long id = Integer.parseUnsignedInt(todoID);
                        user.getTodoList().editTodo(id,todoTitle, todoDone, todoImportant, todoDueDate, todoCategory, todoDescription);
                    } catch (NumberFormatException e) {
                        msg = "Invalid value for Todo ID.";
                    } catch (NoSuchTodoIDException | InvalidTodoTitleException | InvalidTodoDueDateException e) {
                        msg = e.getMessage();
                    }
                }
                request.setAttribute("message", msg);
                request.getRequestDispatcher("todoList.jsp").forward(request, response);
                break;

            case "delete":
                try{
                    long id = Integer.parseUnsignedInt(todoID);
                    user.getTodoList().deleteTodo(id);
                } catch (NumberFormatException e) {
                    msg = "Invalid value for Todo ID.";
                } catch (NoSuchTodoIDException e) {
                    msg = e.getMessage();
                }
                request.setAttribute("message", msg);
                request.getRequestDispatcher("todoList.jsp").forward(request, response);
                break;

            case "close":
                break;
        }

    }
}
