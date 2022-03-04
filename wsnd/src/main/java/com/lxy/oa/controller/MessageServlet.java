package com.lxy.oa.controller;

import com.alibaba.fastjson.JSON;
import com.lxy.oa.entity.User;
import com.lxy.oa.service.Userservice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MessageServlet", urlPatterns= "/Message")
public class MessageServlet extends HttpServlet {
    Userservice userservice = new Userservice();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
            List<User> userList = userservice.SelectAll();
            for(int i=0;i<userList.size();i++) {
                response.getWriter().println("<h1 style='color:white'>" + userList.get(i).getGameid() + userList.get(i).getLevel() + "</h1>");
            }
    }
}
