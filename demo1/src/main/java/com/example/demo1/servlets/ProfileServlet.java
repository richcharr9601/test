package com.example.demo1.servlets;

import com.example.demo1.model.User;
import com.example.demo1.repository.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UserRepository userRepository;
    public ProfileServlet(){
        super();
    }

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userId") == null){
            resp.sendRedirect("login");
            return;
        }
        User user = userRepository.getUserById((Long) req.getSession().getAttribute("userId"));
        req.setAttribute("firstName",user.getFirstName());
        req.setAttribute("lastName",user.getLastName());
        req.setAttribute("email",user.getEmail());
        req.setAttribute("phone",user.getPhone());
        req.setAttribute("description",user.getDescription());
        if(req.getParameter("info")!= null && req.getParameter("info").equals("success")){
            req.setAttribute("info","Update successful!");
        }
        else if(req.getParameter("info")!= null && req.getParameter("info").equals("fail")){
            req.setAttribute("info","Update fail!");
        }
        else {
            req.setAttribute("info","");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/editProfile.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName  = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String description = req.getParameter("description");
        if(userRepository.checkUser(email) != null) {
            User user = new User();
            user.setId((Long) req.getSession().getAttribute("userId"));
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setDescription(description);
            userRepository.updateUser(user);
            resp.sendRedirect("profile?info=success");
        }
        else {
            resp.sendRedirect("profile?info=fail");
        }
    }
}
