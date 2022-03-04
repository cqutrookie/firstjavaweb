package com.lxy.oa.controller;

import com.alibaba.fastjson.JSON;
import com.lxy.oa.dao.SearchreleaseDao;
import com.lxy.oa.entity.Release;
import com.lxy.oa.service.datetostring;
import com.lxy.oa.utils.mybatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "InfosquareServlet", urlPatterns = "/infosquare")
public class InfosquareServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        List<Release> list = new ArrayList<>();
        list = (List<Release>) mybatisUtils.executeQuery(sqlSession -> {
            SearchreleaseDao searchreleaseDao= sqlSession.getMapper(SearchreleaseDao.class);
            return searchreleaseDao.searchrelease();
        });
        Collections.reverse(list);
        for(int i=0;i<list.size();i++)
        {
            String str = datetostring.dateToString(list.get(i).getReleasetime());
            list.get(i).setReleasetime1(str);
        }
        request.setAttribute("release_list",list);
        request.getRequestDispatcher("/infosquare.ftl").forward(request,response);
        String str = JSON.toJSONString("success");
        response.getWriter().println(str);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
