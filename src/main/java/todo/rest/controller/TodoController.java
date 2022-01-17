package todo.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.ToDo;
import todo.model.User;
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
        String category = request.getParameter("category");
        User user = (User) request.getAttribute("user");
        List<ToDo> toDos = new ArrayList<>();
        String path = request.getPathInfo();
        String acceptedType = request.getHeader("Accept");

//        if ((request.getHeader("Accept") == null) || !request.getHeader("Accept").equals(JSON_MEDIA_TYPE)) {
//            if (path == null || path.equals("/")) {
//                toDos = user.getTodoList().getTodos();
//            } else if (category != null) {
//                try {
//                    toDos.add(user.getTodoList().getTodo(category));
//                } catch (NoSuchTodoIDException e) {
//                    response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE); // ------------------ todo
//                }
//            } else {
//                try {
//                    String id = path.substring(1);
//                    toDos.add(user.getTodoList().getTodo(id));
//                } catch (NoSuchTodoIDException e) {
//                    response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 not found
//                }
//            }
//
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 406 unsupported accept type
//        }

        if (!acceptedType.equals(JSON_MEDIA_TYPE)) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 406 unsupported accept type
        } else if (path == null || path.equals("/")) {
            toDos = user.getTodoList().getTodos();
        } else if (category != null) {
            try {
                toDos.add(user.getTodoList().getTodo(category));
            } catch (NoSuchTodoIDException e) {
                response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE); // ------------------ todo
            }
        } else {
            try {
                String id = path.substring(1);
                toDos.add(user.getTodoList().getTodo(id));
            } catch (NoSuchTodoIDException e) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 not found
            }
        }
        response.setStatus(HttpServletResponse.SC_OK); // 200
        response.setContentType(JSON_MEDIA_TYPE);
        objectMapper.writeValue(response.getWriter(), toDos);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getAttribute("user");
        ToDo toDo = objectMapper.readValue(request.getReader(), ToDo.class);
        String contentType = request.getContentType();

        if (!contentType.equals(JSON_MEDIA_TYPE)) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 415 unsupported accept type
//        } else if (!acceptedType.equals(JSON_MEDIA_TYPE)) {
//            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 406 unsupported accept type
        } else {
            try {
                user.getTodoList().addTodo(toDo.getTitle(), String.valueOf(toDo.getImportant()), String.valueOf(toDo.getDueDate()), toDo.getCategory(), toDo.getDescription());
                response.setStatus(HttpServletResponse.SC_CREATED); // 201 created
            } catch (InvalidTodoTitleException | InvalidTodoDueDateException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 invalid data
            }
        }
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getAttribute("user");
        ToDo toDo = objectMapper.readValue(request.getReader(), ToDo.class);
        String path = request.getPathInfo();
        String contentType = request.getContentType();

        if (!contentType.equals(JSON_MEDIA_TYPE)) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 415 unsupported accept type
        } else {
            try {
                String id = path.substring(1);
                user.getTodoList().editTodo(id, toDo.getTitle(), String.valueOf(toDo.getDone()), String.valueOf(toDo.getImportant()), String.valueOf(toDo.getDueDate()), toDo.getCategory(), toDo.getDescription());
                response.setStatus(HttpServletResponse.SC_OK); // 200
            } catch (NoSuchTodoIDException e) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 not found
            } catch (InvalidTodoTitleException | InvalidTodoDueDateException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 invalid data
            }
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getAttribute("user");
        String path = request.getPathInfo();

        if (path == null || path.equals("/")) {
//            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405
        } else {
            try {
                String id = path.substring(1);
                user.getTodoList().deleteTodo(id);
                response.setStatus(HttpServletResponse.SC_OK); // 200
            } catch (NumberFormatException | NoSuchTodoIDException ex) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            }
        }
    }

}
