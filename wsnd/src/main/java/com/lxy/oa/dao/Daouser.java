package com.lxy.oa.dao;

import com.lxy.oa.entity.User;
import com.lxy.oa.utils.mybatisUtils;

public class Daouser {
    /*
    按照用户名查询用户表。。。。
     */
    public User selectByUsername(String username){
        User user=(User)mybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername",username));

        return user;
    }
}
