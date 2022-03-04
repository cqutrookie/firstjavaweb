package com.lxy.oa.controller;

import com.lxy.oa.dao.PostDao;
import com.lxy.oa.entity.Release;
import com.lxy.oa.service.datetostring;
import com.lxy.oa.utils.mybatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PostServlet", urlPatterns = "/Post")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Long releaseid = Long.parseLong(request.getParameter("post_id"));
            System.out.println(releaseid);
            Release release = (Release) mybatisUtils.executeQuery(sqlSession -> {
            PostDao postDao = sqlSession.getMapper(PostDao.class);
            return postDao.selectbyreleaseid(releaseid);
        });
            release.setReleasetime1(datetostring.dateToString(release.getReleasetime()));
            request.setAttribute("post",release);
            request.getRequestDispatcher("/post.ftl").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
