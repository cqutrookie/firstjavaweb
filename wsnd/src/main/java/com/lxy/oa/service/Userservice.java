package com.lxy.oa.service;

import com.lxy.oa.dao.Daomessage;

import com.lxy.oa.dao.Daouser;
import com.lxy.oa.entity.User;
import com.lxy.oa.service.exeception.BussinessException;

import java.util.List;

public class Userservice {
    private Daouser daouser=new Daouser();
    private Daomessage daomessage=new Daomessage();
    public User checklogin(String username, String password){
        User user = daouser.selectByUsername(username);
        if(user==null){
                throw new BussinessException("001","用户不存在!!");
        }
        if(!password.equals(user.getPassword()))
        {
            throw new BussinessException("002","密码错误!!");
        }
        return user;
    }
    public List<User> SelectAll(){
        return daomessage.message();
    }
}
