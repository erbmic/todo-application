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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet("/api/categories/*")
public class CategoryController extends HttpServlet {

    private final ObjectMapper objectMapper = ObjectMapperFactory.createObjectMapper();
    private static final String JSON_MEDIA_TYPE = "application/json";
    Account account = Account.getAccountInstance();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getAttribute("user");
        String path = request.getPathInfo();
        String acceptedType = request.getHeader("Accept");

        if (!(acceptedType == null) && !acceptedType.equals("*/*") && !acceptedType.contains(JSON_MEDIA_TYPE)) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 406 unsupported accept type
        } else if (path == null || path.equals("/")) {
            Set<String> categories = user.getTodoList().getCatList().getCatsFiltered();
            response.setStatus(HttpServletResponse.SC_OK); // 200
            response.setContentType(JSON_MEDIA_TYPE);
            objectMapper.writeValue(response.getWriter(), categories);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405
        }
    }
}