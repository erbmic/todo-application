package todo.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.Account;
import todo.model.ToDo;
import todo.model.User;
import todo.rest.service.TodoService;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/todo/*")
public class TodoController extends HttpServlet {

    Account account = Account.getAccountInstance();

    public static TodoService todoService = new TodoService();
    private final ObjectMapper objectMapper = ObjectMapperFactory.createObjectMapper();


    private static final String JSON_MEDIA_TYPE = "application/json";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String keyword = request.getParameter("keyword");
        List<ToDo> todos = todoService.getTodos();
        User user = (User)request.getAttribute("user");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(JSON_MEDIA_TYPE);
        objectMapper.writeValue(response.getWriter(), user);

//        response.setStatus(200);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {

    }

}
