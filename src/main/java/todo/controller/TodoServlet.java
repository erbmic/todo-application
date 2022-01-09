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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String button = request.getParameter("button");
        String checkbox = request.getParameter("checkbox");
        String category = request.getParameter("category");

        switch (button) {
            case "create":
                    //user.getTodoList().getTodos().add();
                break;
        }

    }

    public void destroy() {
    }
}
