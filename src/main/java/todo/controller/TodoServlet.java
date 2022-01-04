package todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import todo.model.Account;
import todo.model.User;

import java.io.IOException;

@WebServlet(name = "todoServlet", value = "/todoManager")
public class TodoServlet extends HttpServlet {

    Account account = Account.getAccountInstance();
    User user = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String button = request.getParameter("button");
//        String checkbox = request.getParameter("checkbox");
//        String category = request.getParameter("category");
//
//        if (button.equals("sdf")) {
//            System.out.println(category);
//        } // else if logout und destroy

        System.out.println("hello");
        response.sendRedirect("todoList.jsp");

    }

    public void destroy() {
    }
}
