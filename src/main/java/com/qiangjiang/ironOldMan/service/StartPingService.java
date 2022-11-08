package com.qiangjiang.ironOldMan.service;

import com.qiangjiang.ironOldMan.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jq on 9/24/21
 */

@Component
public class StartPingService implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(StartPingService.class);


    @Autowired
    private UserController userController;
    @Override
    public void run(String... args) throws Exception {
        userController.queryUser();
        logger.info("项目启动后执行");
    }
}
