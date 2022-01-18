package todo.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.ToDo;
import todo.model.TodoProcessor;
import todo.model.User;
import todo.model.todoExceptions.AddTodoException;
import todo.model.todoExceptions.InvalidTodoDueDateException;
import todo.model.todoExceptions.InvalidTodoTitleException;
import todo.model.todoExceptions.NoSuchTodoIDException;

import java.io.IOException;
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

        String contentType = request.getContentType();

        if (!contentType.equals(JSON_MEDIA_TYPE)) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 415 unsupported content type
        }

        List<ToDo> toDos = new ArrayList<>();
        if (keyword != null) {
            try {
                toDos.add(user.getTodoList().getTodo(keyword));
                response.setStatus(HttpServletResponse.SC_CREATED); // 201 the added todo
            } catch (NoSuchTodoIDException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 invalid todo data
            }
        } else {
            toDos = user.getTodoList().getTodos();
        }
        response.setStatus(HttpServletResponse.SC_OK); // 200
        response.setContentType(JSON_MEDIA_TYPE);
        objectMapper.writeValue(response.getWriter(), toDos);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getAttribute("user");
        ToDo desTodo = objectMapper.readValue(request.getReader(), ToDo.class);

        try {
            ToDo todo = new ToDo(0,
                    TodoProcessor.processTitle(desTodo.getTitle()),
                    desTodo.getDone(),
                    desTodo.getImportant(),
                    TodoProcessor.processCategory(desTodo.getCategory()),
                    desTodo.getDueDate(),
                    TodoProcessor.processDescription(desTodo.getDescription()));

            user.getTodoList().addTodo(todo);
            response.setStatus(HttpServletResponse.SC_CREATED);

        } catch (InvalidTodoTitleException | AddTodoException e) {
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
