package com.qiangjiang.ironOldMan.service;

import com.google.gson.Gson;
import com.qiangjiang.ironOldMan.utils.HttpRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
/**
 * Created by jq on 8/27/21
 */
public class TestSeckillService {



    public static void secklii(){
        String url = "https://bpmcs.gujing.cn/r/w";
        Map<String,Object> reqMap =new HashMap<>();
        reqMap.put("sid","e0ade9ed-b816-4f77-bf83-55fd01ba6921");
        reqMap.put("cmd","com.awspaas.user.apps.gujingshop_createActivityOrder");
        reqMap.put("amount",1);
        reqMap.put("discountAmount",0);
        reqMap.put("pickDate","2021-08-27");
        reqMap.put("pickMethod","self");
        reqMap.put("pickAddrId","9519db48-12dd-45ac-bac1-af20410dba61");
        reqMap.put("totalAmount",1);
        reqMap.put("activityId","a92a94f7-dfd0-4c09-88ce-085566dfe48c");
        reqMap.put("orderList","");
        Optional<String> optional = HttpRequest.postJSON(url, new Gson().toJson(reqMap), null, "UTF-8", String.class);
        if(optional.isPresent()){
            String s = optional.get();
            System.out.println("------>"+s);
        }
    }

    public static void main(String[] args) {
        secklii();
    }
}
