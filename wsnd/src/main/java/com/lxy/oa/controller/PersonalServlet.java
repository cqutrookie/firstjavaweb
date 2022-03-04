package com.lxy.oa.controller;

import com.alibaba.fastjson.JSON;
import com.lxy.oa.dao.GuessDao;
import com.lxy.oa.entity.Guess;
import com.lxy.oa.entity.Personal;
import com.lxy.oa.entity.User;
import com.lxy.oa.utils.mybatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PersonalServlet", urlPatterns = "/Personal")
public class PersonalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("login user");
        Guess guess = (Guess) mybatisUtils.executeQuery(sqlSession -> {
            GuessDao guessDao = sqlSession.getMapper(GuessDao.class);
            return guessDao.guess(user.getUserid());
        });
        Personal personal = new Personal();
        personal.setAvatar(user.getAvatar());
        personal.setGameid(user.getGameid());
        personal.setLevel(user.getLevel());
        personal.setMark(guess.getMark());
        personal.setUsername(user.getUsername());
        personal.setMoney(guess.getMoney());
        String json = JSON.toJSONString(personal);
        response.getWriter().println(json);
    }
}
