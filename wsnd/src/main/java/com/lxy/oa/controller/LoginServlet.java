package com.lxy.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.lxy.oa.entity.User;
import com.lxy.oa.service.Userservice;
import com.lxy.oa.service.exeception.BussinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.ws.ResponseWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet(name = "LoginServlet",urlPatterns = "/check_login")

    public class LoginServlet extends HttpServlet {
    Logger logger= LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private Userservice userservice=new Userservice();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            String username= request.getParameter("username");
            System.out.println(username);
            String password=request.getParameter("password");
            System.out.println(password);
            Map<String,Object> result =new HashMap<>();
            try{
            User user = userservice.checklogin(username,password);
            HttpSession session = request.getSession();
            session.setAttribute("login user",user);
            result.put("code","0");
            result.put("message","success");
            result.put("redirect_url","/index");
            result.put("user",user);
        }catch(BussinessException e){
            logger.error(e.getMessage(),e);
            System.out.println(e.getMessage());
            result.put("code",e.getCode());
            result.put("message",e.getMessage());
            }
         catch (Exception e) {
             logger.error(e.getMessage(),e);
             result.put("code",e.getClass().getSimpleName());
             result.put("message",e.getMessage());
         } finally {
                String json = JSON.toJSONString(result);
                System.out.println(json);
                response.getWriter().println(json);
            }

         }
}
