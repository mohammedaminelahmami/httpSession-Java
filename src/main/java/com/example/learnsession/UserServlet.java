package com.example.learnsession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login","/dashboard", "/logout"})
public class UserServlet extends HttpServlet
{
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        Mapping(req, resp, session);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        Mapping(req, resp, session);
    }

    protected void Mapping(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException
    {
        String path = req.getServletPath();

        switch (path)
        {
            case "/login":
            {
                if(session.getAttribute("auth") != null)
                {
                    resp.sendRedirect("/dashboard");
                    return;
                }
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                break;
            }
            case "/dashboard":
            {
                if(session.getAttribute("auth") == null)
                {
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");
                    if(username != null && password != null && username.equals("ahmed") && password.equals("123"))
                    {
                        session.setAttribute("auth", username);
                        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                    }
                    resp.sendRedirect("/login");
                }else{
                    req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                }
                break;
            }
            case "/logout":
            {
                // session.removeAttribute("auth");
                session.invalidate();
                resp.sendRedirect("/login");
                break;
            }
        }
    }
}
