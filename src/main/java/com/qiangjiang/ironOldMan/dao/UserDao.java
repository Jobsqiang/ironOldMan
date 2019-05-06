package com.qiangjiang.ironOldMan.dao;

import com.qiangjiang.ironOldMan.mapper.UserMapper;
import com.qiangjiang.ironOldMan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public void add(User user){
        userMapper.insert(user);
    }
}
