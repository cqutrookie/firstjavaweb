package com.lxy.oa.dao;

import com.lxy.oa.entity.Guess;
import com.lxy.oa.entity.User;

public interface GuessDao {
    public Guess guess(Long user_id);
}
