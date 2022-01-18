package todo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import todo.model.ToDo;
import todo.model.TodoProcessor;
import todo.model.User;
import todo.model.todoExceptions.AddTodoException;
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
        String todoDone = request.getParameter("editCompletion");
        String todoTitle = request.getParameter("title");
        String todoImportant = request.getParameter("editImportant");
        String todoDueDate = request.getParameter("dueDate");
        String todoCategory = request.getParameter("category");
        String todoDescription = request.getParameter("description");

        switch (button) {
            case "saveTodo":
                if (todoID == null || todoID.equals("")){
                    try {
                        ToDo todo = new ToDo(0,
                                TodoProcessor.processTitle(todoTitle),
                                TodoProcessor.processDone(todoDone),
                                TodoProcessor.processImportant(todoImportant),
                                TodoProcessor.processCategory(todoCategory),
                                TodoProcessor.processDueDate(todoDueDate),
                                TodoProcessor.processDescription(todoDescription));

                        user.getTodoList().addTodo(todo);
                        msg = "New Todo added.";
                    } catch (InvalidTodoTitleException | InvalidTodoDueDateException | AddTodoException e) {
                        msg = e.getMessage();
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("todoEdit.jsp").forward(request, response);
                    }
                } else {
                    try{
                        ToDo todo = new ToDo(
                                Long.parseLong(todoID),
                                TodoProcessor.processTitle(todoTitle),
                                TodoProcessor.processDone(todoDone),
                                TodoProcessor.processImportant(todoImportant),
                                TodoProcessor.processCategory(todoCategory),
                                TodoProcessor.processDueDate(todoDueDate),
                                TodoProcessor.processDescription(todoDescription));

                        user.getTodoList().editTodo(todo);
                    } catch (NoSuchTodoIDException | InvalidTodoTitleException | InvalidTodoDueDateException | NumberFormatException e) {
                        msg = e.getMessage();
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("todoEdit.jsp").forward(request, response);
                    }
                }
                request.setAttribute("message", msg);
                request.getRequestDispatcher("todoList.jsp").forward(request, response);
                break;

            case "deleteTodo":
                try{
                    user.getTodoList().deleteTodo(todoID);
                } catch (NoSuchTodoIDException e) {
                    msg = e.getMessage();
                }
                request.setAttribute("message", msg);
                request.getRequestDispatcher("todoList.jsp").forward(request, response);
                break;
        }

    }
}
