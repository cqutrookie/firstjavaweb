package com.lxy.oa.dao;

import com.lxy.oa.entity.User;

public interface HomepageDao {
    public User selectbyuserid(Long userid);
}
