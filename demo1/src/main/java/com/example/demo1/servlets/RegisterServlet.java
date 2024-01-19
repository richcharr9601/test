package com.example.demo1.servlets;

import com.example.demo1.model.User;
import com.example.demo1.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserRepository userRepository;

    public RegisterServlet() {
        super();
    }

    @Override
    public void init() {
        userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");
        if (userRepository.checkUser(email) == null && rePassword.equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            userRepository.addUser(user);
            resp.sendRedirect("login.jsp");
        }else {
            System.out.println("Register not successful!");
            resp.sendRedirect("register.jsp");
        }
    }
}
