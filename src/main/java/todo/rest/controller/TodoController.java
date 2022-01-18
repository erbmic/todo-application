package todo.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.ToDo;
import todo.model.TodoProcessor;
import todo.model.User;
import todo.model.categoryException.InvalidCategoryException;
import todo.model.todoExceptions.AddTodoException;
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
        String requestPath = request.getPathInfo();
        String queryPath = request.getQueryString();
        String acceptedType = request.getHeader("Accept");


        if (!(acceptedType == null) && !acceptedType.equals("*/*") && !acceptedType.contains(JSON_MEDIA_TYPE)) {
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE); // 406 unsupported accept type
        } else if (category != null) {
            try {
                toDos = user.getTodoList().getTodosOfCat(TodoProcessor.processCategory(category));
                respondDataAndSetStatusCode(response, toDos);
            } catch (InvalidCategoryException e){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 bad request
            }
        } else if (queryPath == null && (requestPath == null || requestPath.equals("/"))) {
            toDos = user.getTodoList().getTodos();
            respondDataAndSetStatusCode(response, toDos);
        } else if (requestPath != null && requestPath.substring(1).matches("\\d+")) {
            try {
                toDos.add(user.getTodoList().getTodo(requestPath.substring(1)));
                respondDataAndSetStatusCode(response, toDos);
            } catch (NoSuchTodoIDException e) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 not found
            }
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405
        }
    }

    private void respondDataAndSetStatusCode(HttpServletResponse response, List<ToDo> toDos) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK); // 200
        response.setContentType(JSON_MEDIA_TYPE);
        objectMapper.writeValue(response.getWriter(), toDos);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getAttribute("user");
        String contentType = request.getContentType();
        String acceptedType = request.getHeader("Accept");

        try {
            ToDo desTodo = objectMapper.readValue(request.getReader(), ToDo.class);

            if (!(contentType == null) && !contentType.equals(JSON_MEDIA_TYPE)) {
                response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 415 unsupported accept type
            } else if (!(acceptedType == null) && !acceptedType.equals("*/*") && !acceptedType.contains(JSON_MEDIA_TYPE)) {
                response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 406 unsupported accept type
            } else {
                try {
                    ToDo todo = new ToDo(0,
                            TodoProcessor.processTitle(desTodo.getTitle()),
                            desTodo.getCompleted(),
                            desTodo.getImportant(),
                            TodoProcessor.processCategory(desTodo.getCategory()),
                            desTodo.getDueDate(),
                            TodoProcessor.processDescription(desTodo.getDescription()));

                    user.getTodoList().addTodo(todo);

                    response.setStatus(HttpServletResponse.SC_CREATED); // 201 created
                    response.setContentType(JSON_MEDIA_TYPE);
                    objectMapper.writeValue(response.getWriter(), todo);

                } catch (AddTodoException | InvalidTodoTitleException e) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 invalid data
                }
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 invalid data
        }
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getAttribute("user");
        String path = request.getPathInfo();
        String contentType = request.getContentType();

        try {
            ToDo desTodo = objectMapper.readValue(request.getReader(), ToDo.class);
            if (!(contentType == null) && !contentType.equals(JSON_MEDIA_TYPE)) {
                response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 415 unsupported accept type
            } else if (path.substring(1).matches("\\d+")) {
                try {
                    if (Long.parseLong(path.substring(1)) == desTodo.getId()) {
                        ToDo todo = new ToDo(
                                desTodo.getId(),
                                TodoProcessor.processTitle(desTodo.getTitle()),
                                desTodo.getCompleted(),
                                desTodo.getImportant(),
                                TodoProcessor.processCategory(desTodo.getCategory()),
                                desTodo.getDueDate(),
                                TodoProcessor.processDescription(desTodo.getDescription()));

                        user.getTodoList().editTodo(todo);
                        response.setStatus(HttpServletResponse.SC_OK); // 200
                        response.setContentType(JSON_MEDIA_TYPE);
                        objectMapper.writeValue(response.getWriter(), todo);
                    } else {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 invalid data
                    }
                } catch (NoSuchTodoIDException e) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 not found
                }
            } else {
                response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 invalid data
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getAttribute("user");
        String path = request.getPathInfo();

        if (path.substring(1).matches("\\d+")) {
            try {
                String id = path.substring(1);
                user.getTodoList().deleteTodo(id);
                response.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204
            } catch (NumberFormatException | NoSuchTodoIDException ex) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            }
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405
        }
    }
}
