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

@WebServlet(name = "userManagerServlet", value = "/userManager")
public class UserManagerServlet extends HttpServlet {

    Account account = Account.getAccountInstance();
    User user = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session=request.getSession();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String button = request.getParameter("button");
        String checkbox = request.getParameter("checkbox");
        String category = request.getParameter("category");

        if (button.equals("register")) {
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
    }

    public void destroy() {
    }
}