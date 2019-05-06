package com.qiangjiang.ironOldMan.controller;

import com.google.gson.Gson;
import com.qiangjiang.ironOldMan.model.User;
import com.qiangjiang.ironOldMan.service.SendMessageService;
import com.qiangjiang.ironOldMan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SendMessageService sendMessageService;
    @RequestMapping("/hello")
    public void test(){
        System.out.println("hello boot");
        User user = new User();
        user.setPassWord("12345");
        user.setToken(UUID.randomUUID().toString());
        user.setUserName("系统");
        User user1 = userService.add(user);
        sendMessageService.userMessage(user1);
        System.out.println("user:"+new Gson().toJson(user1));

    }
}
