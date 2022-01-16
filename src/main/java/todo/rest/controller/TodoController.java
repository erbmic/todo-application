package todo.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.Account;
import todo.model.ToDo;
import todo.model.User;
import todo.model.todoExceptions.NoSuchTodoIDException;
import todo.rest.service.TodoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/todo/*")
public class TodoController extends HttpServlet {

    private final ObjectMapper objectMapper = ObjectMapperFactory.createObjectMapper();


    private static final String JSON_MEDIA_TYPE = "application/json";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        User user = (User)request.getAttribute("user");
        List<ToDo> toDos = new ArrayList<>();

        if (keyword == null) {
            toDos = user.getTodoList().getTodos();
        } else {
            try {
                toDos.add(user.getTodoList().getTodo(keyword));
            } catch (NoSuchTodoIDException e) {
                e.printStackTrace();
            }
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(JSON_MEDIA_TYPE);
        objectMapper.writeValue(response.getWriter(), toDos);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {

    }

}
