package com.qiangjiang.ironOldMan.service;


import com.qiangjiang.ironOldMan.model.History;
import com.qiangjiang.ironOldMan.model.User;

public interface UserService {

    public User add (User user);

    public History query();
}
