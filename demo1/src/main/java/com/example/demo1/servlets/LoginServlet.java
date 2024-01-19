package com.example.demo1.servlets;

import com.example.demo1.model.User;
import com.example.demo1.repository.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserRepository userRepository;
    public LoginServlet(){
        super();
    }

    @Override
    public void init(){
        userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get the client's IPv6 address
        String clientIPv6 = getClientIPv6(req);

        // Output the IPv6 address to the response
        System.out.println("Client's IPv6 Address: " + clientIPv6);

        if(req.getSession().getAttribute("username") != null){
            resp.sendRedirect("content");
        }
        else {
            resp.sendRedirect("login.jsp");
            
        }
        
        
    }

    private String getClientIPv6(HttpServletRequest request){
        // Try to get the IPv6 address from the headers
        String ipv6Address = request.getHeader("X-Forwarded-For");

        // If the headers don't contain the IPv6 address, use the remote address
        if (ipv6Address == null || ipv6Address.isEmpty() || "unknown".equalsIgnoreCase(ipv6Address)) {
            ipv6Address = request.getRemoteAddr();
        }

        // If there are multiple IP addresses, use the first one
        if (ipv6Address != null && ipv6Address.contains(",")) {
            ipv6Address = ipv6Address.split(",")[0].trim();
        }

        return ipv6Address;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("username");
        String password = req.getParameter("password");
        User user;
        user = userRepository.validateUser(email,password);
        
        if(user != null){
            System.out.println("Login OK");
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("userId",user.getId());
            httpSession.setAttribute("username", user.getUsername());
            resp.sendRedirect("content");
        }else {
            System.out.println("Login not successful!");
            resp.sendRedirect("login.jsp");
        }
    }
}
