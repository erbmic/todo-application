package todo.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.Account;
import todo.model.User;
import todo.model.userExceptions.InvalidCredentialsException;
import todo.model.userExceptions.UserAlreadyExistsException;

import java.io.IOException;


@WebServlet("/api/users/*")
public class UserController extends HttpServlet {

    private final ObjectMapper objectMapper = ObjectMapperFactory.createObjectMapper();
    private static final String JSON_MEDIA_TYPE = "application/json";
    Account account = Account.getAccountInstance();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = objectMapper.readValue(request.getReader(), User.class);
        String contentType = request.getContentType();

        if (!(contentType == null) && !contentType.equals(JSON_MEDIA_TYPE)) {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); // 415 unsupported content type
        } else {
            try {
                account.registerUser(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), user.getPassword());
                response.setStatus(HttpServletResponse.SC_CREATED); // 201 created
            } catch (NullPointerException | InvalidCredentialsException ex) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 invalid data
            } catch (UserAlreadyExistsException e) {
                response.setStatus(HttpServletResponse.SC_CONFLICT); // 409 user already exists
            }
        }
    }
}

