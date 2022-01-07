package todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import todo.model.Account;
import todo.model.userExceptions.InvalidCredentialsException;
import todo.model.userExceptions.NoSuchUserException;
import todo.model.userExceptions.UserAlreadyExistsException;
import todo.model.userExceptions.WrongPasswordException;

import java.io.IOException;

@WebServlet(name = "userManagerServlet", value = "/userManager")
public class UserManagerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        String button = request.getParameter("button");
        String checkbox = request.getParameter("checkbox");
        String category = request.getParameter("category");

        switch (button) {
            case "register":
                String firstName = request.getParameter("name");
                String lastName = request.getParameter("lastName");
                String passwordC = request.getParameter("passwordC");
                try {
                    session.setAttribute("user", Account.getAccountInstance().registerUser(firstName, lastName, userName, password, passwordC));
                    response.sendRedirect("todoList.jsp");
                } catch (InvalidCredentialsException | UserAlreadyExistsException e) {
                    // stay on register site and inform user
                    try {
                        request.setAttribute("errorMsg", e.getMessage());
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    } catch (ServletException ex) {
                        ex.printStackTrace();
                    }
                }
                break;
            case "login":
                // if user not logged in call login method
                if (session.getAttribute("user") == null) {
                    try {
                        session.setAttribute("user", Account.getAccountInstance().loginUser(userName, password));
                        response.sendRedirect("todoList.jsp");
                    } catch (NoSuchUserException | WrongPasswordException e) {
                        // stay on login site and inform user about wrong userName or password
                        try {
                            request.setAttribute("errorMsg", e.getMessage());
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        } catch (ServletException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                break;
            case "logout":
                if (session != null) {
                    session.removeAttribute("user");
                    response.sendRedirect("login.jsp");
                }
                break;
            default:
                break;
        }
    }


        /*if (button.equals("register")) {
            user = account.registerUser(userName, password);
            session.setAttribute("user", user);
            response.sendRedirect("todoList.jsp");
//            response.sendRedirect("register.jsp");
        }
        else if (button.equals("login")) {
            user = account.loginUser(userName, password);

            if (!(user == null)) {
                session.setAttribute("user", user);
                response.sendRedirect("todoList.jsp");
            } else {
                response.sendRedirect("login.jsp");
                destroy();
                System.out.println("destroyed");
            }
        } // else if logout und destroy
    } */

}