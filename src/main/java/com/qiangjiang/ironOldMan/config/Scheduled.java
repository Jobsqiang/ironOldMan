package com.qiangjiang.ironOldMan.config;


import com.qiangjiang.ironOldMan.reomteService.wmhtService.WmhtNewCommonHttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jq on 2020-09-04
 */
@Slf4j
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class Scheduled {

    @Autowired
    private WmhtNewCommonHttpRequest httpRequest;

    @org.springframework.scheduling.annotation.Scheduled(cron = "0/5 * * * * ?")
    public void scheduled(){

        String url = "http://hq.sinajs.cn/list=sh601138";
//        String result = httpRequest.executeGetNew(url, null);
//        String[] split = result.split("=");
//        String name = split[0];
////        System.out.println(split[1]);
//        String[] params = split[1].split(",");
//        for (int i = 0 ;i  <= params.length-1 ; i ++){
//            System.out.println(params[i]);
//        }

//        log.info("{} {} {} {} {} {} {} {} {} {} {} {} {} ",params[0],params[1],params[2],params[3],params[0],params[0],params[0],params[0],params[0],params[0],params[0],params[0],params[0],);
    }

}
