package todo.rest.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.Account;
import todo.model.ToDo;
import todo.model.TodoList;
import todo.model.User;
import todo.model.todoExceptions.InvalidTodoDueDateException;
import todo.model.todoExceptions.InvalidTodoTitleException;
import todo.model.todoExceptions.NoSuchTodoIDException;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/todos/*")
public class TodoController extends HttpServlet {

    private final ObjectMapper objectMapper = ObjectMapperFactory.createObjectMapper();
    private static final String JSON_MEDIA_TYPE = "application/json";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        User user = (User)request.getAttribute("user");

        List<ToDo> toDos = new ArrayList<>();
        if (keyword != null) {
            try {
                toDos.add(user.getTodoList().getTodo(keyword));
            } catch (NoSuchTodoIDException e) {
                e.printStackTrace();
            }
        } else {
            toDos = user.getTodoList().getTodos();
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(JSON_MEDIA_TYPE);
        objectMapper.writeValue(response.getWriter(), toDos);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getAttribute("user");
        ToDo toDo = objectMapper.readValue(request.getReader(), ToDo.class);

        try {
            user.getTodoList().addTodo(toDo.getTitle(), String.valueOf(toDo.getImportant()), String.valueOf(toDo.getDueDate()), toDo.getCategory(), toDo.getDescription());
            response.setStatus(HttpServletResponse.SC_CREATED);

        } catch (InvalidTodoTitleException | InvalidTodoDueDateException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        User user = (User)request.getAttribute("user");
        String path = request.getPathInfo();

        if (path == null || path.equals("/")) {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {
            try {
                String id = path.substring(1);
                user.getTodoList().deleteTodo(id);
                response.setStatus(HttpServletResponse.SC_OK);
//            } catch (NumberFormatException | NewsNotFoundException | NoSuchTodoIDException ex) {
            } catch (NumberFormatException | NoSuchTodoIDException ex) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

}
