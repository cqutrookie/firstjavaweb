package com.lxy.oa.dao;

import com.lxy.oa.entity.User;
import com.lxy.oa.utils.mybatisUtils;

import java.util.List;

public class Daomessage {
    public List<User> message(){
        List<User> userList = (List<User>) mybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("messagemapper.selectAll"));
        return userList;
    }
}
