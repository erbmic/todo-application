package todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.Account;
import todo.model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userManagerServlet", value = "/userManager")
public class UserManagerServlet extends HttpServlet {
    private String message;

    Account account = null;

    public void init() {
        message = "Hello Todo!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userName != null) {
            account.registerUser(userName, password);
        } else {
            System.out.println("lorem");
            response.sendRedirect("index.jsp");
        }

    }

    public void destroy() {
    }
}