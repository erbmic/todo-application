package todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.Account;

import java.io.IOException;

@WebServlet(name = "userManagerServlet", value = "/userManager")
public class UserManagerServlet extends HttpServlet {

    Account account = Account.getAccountInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String button = request.getParameter("button");


        switch (button) {
            case "register":
                account.registerUser(userName, password);
                account.loginUser(userName, password);
            case "login":
                account.loginUser(userName, password);
        }
    }

    public void destroy() {
    }
}