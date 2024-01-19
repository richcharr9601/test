package com.example.demo1.servlets;

import com.example.demo1.model.Content;
import com.example.demo1.repository.ContentRepository;
import com.example.demo1.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editContent")
public class EditContent extends HttpServlet {
    private ContentRepository contentRepository;
    private UserRepository userRepository;
    @Override
    public void init() throws ServletException {
        contentRepository = new ContentRepository();
        userRepository = new UserRepository();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userId") == null){
            resp.sendRedirect("login");
            return;
        }
        Long id = Long.parseLong(req.getParameter("id"));
        Content content = contentRepository.getContentById(id);
        req.setAttribute("id",id);
        req.setAttribute("title",content.getTitle());
        req.setAttribute("brief",content.getBrief());
        req.setAttribute("content",content.getContent());
        req.getRequestDispatcher("/content.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String brief = req.getParameter("brief");
        String content = req.getParameter("content");
        Content content1 = contentRepository.getContentById(id);
        content1.setTitle(title);
        content1.setBrief(brief);
        content1.setContent(content);
        contentRepository.updateContent(content1);
        resp.sendRedirect("content");
    }

}
