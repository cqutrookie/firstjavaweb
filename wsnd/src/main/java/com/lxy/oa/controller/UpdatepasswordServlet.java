package com.lxy.oa.controller;

import com.alibaba.fastjson.JSON;
import com.lxy.oa.dao.UpdatepasswordDao;
import com.lxy.oa.entity.User;
import com.lxy.oa.utils.mybatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UpdatepasswordServlet", urlPatterns = "/Updatepassword")
public class UpdatepasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String password = request.getParameter("password");
        String uppassword = request.getParameter("uppassword");
        String repassword = request.getParameter("repassword");
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("login user");
        if (password.equals(user.getPassword()) && uppassword.equals(repassword)) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("username", user.getUsername());
            map.put("uppassword",uppassword);
            mybatisUtils.executeQueryUpdate(sqlSession -> {
                UpdatepasswordDao updatepasswordDao = sqlSession.getMapper(UpdatepasswordDao.class);
                updatepasswordDao.Updatepassword(map);
                return null;
            });
            String json = JSON.toJSONString("修改密码成功，请重新登录");
            response.getWriter().println(json);
        }
        else if(!password.equals(user.getPassword()))
            {
                String json = JSON.toJSONString("密码输入错误");
                response.getWriter().println(json);
            }
        else if(!uppassword.equals(repassword))
        {
            String json = JSON.toJSONString("两次密码输入不一致");
            response.getWriter().println(json);
        }
    }
}
