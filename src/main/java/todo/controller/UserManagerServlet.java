package todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import todo.model.Account;
import todo.model.User;

import java.io.IOException;

@WebServlet(name = "userManagerServlet", value = "/userManager")
public class UserManagerServlet extends HttpServlet {

    Account account = Account.getAccountInstance();
    User user = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String button = request.getParameter("button");

        if (button.equals("register")) {
            user = account.registerUser(userName, password);
//                account.loginUser(user);
            response.sendRedirect("index.jsp");
        }
        else if (button.equals("login")) {
            if (account.loginUser(userName, password)) {
                System.out.println("yes");
            } else System.out.println("no");
            response.sendRedirect("index.jsp");
        }


//        switch (button) {
//            case "register":
//                user = account.registerUser(userName, password);
////                account.loginUser(user);
//                response.sendRedirect("index.jsp");
//            case "login":
//                if (account.loginUser(userName, password)) {
//                    System.out.println("yes");
//                } System.out.println("no");
//                response.sendRedirect("index.jsp");
//        }
    }

    public void destroy() {
    }
}