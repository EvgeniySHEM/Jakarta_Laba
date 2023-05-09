package ru.sanctio.jakarta_laba;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AuthorizationServlet", value = "/Authorization-servlet")
public class AuthorizationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean check = new UserStore().checkUser(username, password);
        if(check) {
            getServletContext().getRequestDispatcher("/ViewListServlet").forward(request, response);
        } else {
            response.sendError(401, "В доступе отказано : логин или пароль не найдены");
        }
    }
}