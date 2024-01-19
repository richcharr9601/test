package com.example.demo1.servlets;

import com.example.demo1.repository.ContentRepository;
import com.example.demo1.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteContent")
public class DeleteContentServlet extends HttpServlet{
    private ContentRepository contentRepository;
    @Override
    public void init() throws ServletException {
        contentRepository = new ContentRepository();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("userId") == null){
            resp.sendRedirect("login");
            return;
        }
        Long id = Long.parseLong(req.getParameter("id"));
        contentRepository.deleteContent(id);
        resp.sendRedirect("content");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
