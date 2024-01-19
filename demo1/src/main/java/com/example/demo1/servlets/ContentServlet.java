package com.example.demo1.servlets;

import com.example.demo1.model.Content;
import com.example.demo1.repository.ContentRepository;
import com.example.demo1.repository.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private ContentRepository contentRepository;
    private UserRepository userRepository;

    public ContentServlet(){
        super();
    }

    @Override
    public void init(){
        userRepository = new UserRepository();
        contentRepository = new ContentRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("userId") == null) {
            resp.sendRedirect("login");
            return;
        }
        HttpSession session = req.getSession();
        List<Content> contentList = contentRepository.getContentByUserId((Long) session.getAttribute("userId"));
        req.setAttribute("contents",contentList);
        req.setAttribute("username", session.getAttribute("username"));
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/view.jsp");
        requestDispatcher.forward(req,resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        String title = req.getParameter("title");
        String brief = req.getParameter("brief");
        String content = req.getParameter("content");
        HttpSession session = req.getSession();
        Content content1 = new Content();
        content1.setTitle(title);
        content1.setBrief(brief);
        content1.setContent(content);
        content1.setSort("sort");
        content1.setUser(userRepository.getUserById((Long) session.getAttribute("userId")));
        contentRepository.addContent(content1);
        doGet(req,resp);
    }
    
}
