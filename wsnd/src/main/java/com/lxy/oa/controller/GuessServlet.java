package com.lxy.oa.controller;

import com.alibaba.fastjson.JSON;
import com.lxy.oa.dao.*;
import com.lxy.oa.entity.Guess;
import com.lxy.oa.entity.Odds;
import com.lxy.oa.entity.User;
import com.lxy.oa.utils.mybatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "GuessServlet", urlPatterns = "/Guess")
public class GuessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("login user");
        Guess guess = (Guess)mybatisUtils.executeQuery(sqlSession -> {
            GuessDao guessDao = sqlSession.getMapper(GuessDao.class);
            return guessDao.guess(user.getUserid());
        });
        String json = JSON.toJSONString(guess);
        System.out.println(json);
        response.getWriter().println(json);
        String housemoney1=request.getParameter("housemoney");
        String money1=request.getParameter("money");
        int fhousemoney = Integer.valueOf(housemoney1);
        int fmoney = Integer.valueOf(money1);
        if(fhousemoney+fmoney<=guess.getMoney()) {
            boolean hostteam=true;

            if(hostteam==true)
            {
                Odds odds = (Odds) mybatisUtils.executeQuery(sqlSession -> {
                    OddsDao oddsDao = sqlSession.getMapper(OddsDao.class);
                    return oddsDao.selectodds();
                });
               int housemoney=(int)(fhousemoney*odds.getHost());
               int money=0;
                Map<String,Integer> map=new HashMap<String,Integer>();
                map.put("hostmoney",housemoney);
                map.put("money",money);
                map.put("mark",100);
                map.put("fhostmoney",fhousemoney);
                map.put("fmoney",fmoney);
                map.put("guessid",guess.getGuessid());
                mybatisUtils.executeQueryUpdate(sqlSession -> {
                    hostmoneyDao hostmoneydao = sqlSession.getMapper(hostmoneyDao.class);
                    hostmoneydao.changemm(map);
                    return null;
                });
                mybatisUtils.executeQueryUpdate(sqlSession -> {
                    moneyDao moneyDao = sqlSession.getMapper(moneyDao.class);
                    moneyDao.changemm1(map);
                    return null;
                });
                mybatisUtils.executeQueryUpdate(sqlSession -> {
                    markDao markdao = sqlSession.getMapper(markDao.class);
                    markdao.changemm2(map);
                    return null;
                });

            }
            if(hostteam==false)
            {
                Odds odds = (Odds) mybatisUtils.executeQuery(sqlSession -> {
                    OddsDao oddsDao = sqlSession.getMapper(OddsDao.class);
                    return oddsDao.selectodds();
                });
                int money=(int)(fmoney*odds.getOther());
                int housemoney=0;
                Map<String,Integer> map=new HashMap<String,Integer>();
                map.put("hostmoney",housemoney);
                map.put("money",money);
                map.put("mark",100);
                map.put("fhostmoney",fhousemoney);
                map.put("fmoney",fmoney);
                map.put("guessid",guess.getGuessid());
                mybatisUtils.executeQueryUpdate(sqlSession -> {
                    hostmoneyDao hostmoneydao = sqlSession.getMapper(hostmoneyDao.class);
                    hostmoneydao.changemm(map);
                    return null;
                });
                mybatisUtils.executeQueryUpdate(sqlSession -> {
                    moneyDao moneyDao = sqlSession.getMapper(moneyDao.class);
                    moneyDao.changemm1(map);
                    return null;
                });
                mybatisUtils.executeQueryUpdate(sqlSession -> {
                    markDao markdao = sqlSession.getMapper(markDao.class);
                    markdao.changemm2(map);
                    return null;
                });

            }
        }
        }


    }
