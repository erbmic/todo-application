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

        String button = request.getParameter("editTodoButton1");
        String button1 = request.getParameter("editTodoButton2");
        String button2 = request.getParameter("editTodoButton3");

//        System.out.println(button1);
//        System.out.println(button2);
//        System.out.println(button);
        response.sendRedirect("todoList.jsp");

    }

    public void destroy() {
    }
}
