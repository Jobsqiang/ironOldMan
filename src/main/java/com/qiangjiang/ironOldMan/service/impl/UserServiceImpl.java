package com.qiangjiang.ironOldMan.service.impl;

import com.qiangjiang.ironOldMan.dao.UserDao;
import com.qiangjiang.ironOldMan.model.History;
import com.qiangjiang.ironOldMan.model.User;
import com.qiangjiang.ironOldMan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User add(User user) {
        userDao.add(user);
        return user;
    }

    @Override
    public History query() {
        return userDao.findByName("");
    }
}
