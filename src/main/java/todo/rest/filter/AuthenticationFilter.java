package todo.rest.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import todo.model.Account;
import todo.model.User;

import java.io.IOException;
import java.util.Base64;

import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

@WebFilter("/api/*")
public class AuthenticationFilter extends HttpFilter  {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "12345";


    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String ADMIN_USERNAME = "admin";
        HttpSession session = request.getSession();

        Account account = Account.getAccountInstance();


        if (request.getMethod().equals("GET")) {
            try {
                String[] credentials = getCredentials(request);
                User user = account.loginUser(credentials[0], credentials[1]);

                request.setAttribute("user", user);

//                validate(credentials);
            } catch (Exception ex) {
                response.setStatus(SC_UNAUTHORIZED);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private String[] getCredentials(HttpServletRequest request) throws Exception {
        String header = request.getHeader(AUTHORIZATION_HEADER);
        String[] tokens = header.split(" ");
        if (!tokens[0].equals(AUTHENTICATION_SCHEME)) throw new Exception();
        byte[] decoded = Base64.getDecoder().decode(tokens[1]);
        return new String(decoded).split(":");
    }

    private void validate(String[] credentials) throws Exception {
//        if (!credentials[0].equals(ADMIN_USERNAME) || !credentials[1].equals(ADMIN_PASSWORD))
//            throw new Exception();


    }
}
