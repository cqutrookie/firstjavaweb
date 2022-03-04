package com.lxy.oa.controller;

import com.alibaba.fastjson.JSON;

import com.lxy.oa.entity.User;
import com.lxy.oa.service.Userservice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    Userservice userservice =new Userservice();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("login user");
            request.setAttribute("user",user);
            request.getRequestDispatcher("/index.ftl").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
