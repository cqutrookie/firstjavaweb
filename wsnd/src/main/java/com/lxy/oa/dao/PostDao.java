package com.lxy.oa.dao;

import com.lxy.oa.entity.Release;

public interface PostDao {
    public Release selectbyreleaseid(Long release);
}
