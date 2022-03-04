package com.lxy.oa.controller;

import com.lxy.oa.dao.HomepageDao;
import com.lxy.oa.entity.User;
import com.lxy.oa.utils.mybatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomepageServlet", urlPatterns = "/Homepage")
public class HomepageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userid =Long.parseLong(request.getParameter("userid"));
        System.out.println(userid);
        User user =(User) mybatisUtils.executeQuery(sqlSession -> {
            HomepageDao homepageDao = sqlSession.getMapper(HomepageDao.class);
            return homepageDao.selectbyuserid(userid);
        });
        request.setAttribute("user",user);
        request.getRequestDispatcher("/homepage.ftl").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
