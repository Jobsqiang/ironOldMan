package com.qiangjiang.ironOldMan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qiangjiang.ironOldMan.model.BpmData;
import com.qiangjiang.ironOldMan.model.BpmDatas;
import com.qiangjiang.ironOldMan.model.History;
import com.qiangjiang.ironOldMan.model.User;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.WmhtNewCommonHttpRequest;
import com.qiangjiang.ironOldMan.service.BpmServce;
import com.qiangjiang.ironOldMan.service.SendMessageService;
import com.qiangjiang.ironOldMan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Stream;

@RestController
@Api(description = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private WmhtNewCommonHttpRequest httpRequest;
    @Autowired
    private BpmServce bpmServce;

    public static Map<String,String> dbfieldTypeMap = new HashMap<>();

    static {
        dbfieldTypeMap.put("TEXT","VARCHAR");
        dbfieldTypeMap.put("DATE","DATE");
    }

//    @RequestMapping("/getExcel")
//    public String getExcel(){
//        String url = "http://bpmdev.gujing.cn/r/jd?sid=5d44481d-8475-4cb6-9a3b-29ac44aeae33X0lbYXdzLW5vZGUjMV1JXw&cmd=CONSOLE_M_BO_DESIGN_MAP_GET_MAP_LIST_JSON&boDefId=27d130f3-5105-4894-b22b-92b19a3ac08e&_=1602642753817";
//        String str = httpRequest.executeGetNew(url, null);
//        List<BpmData> bpmDatas = jsonToList(str, BpmData.class);
//
//        for (BpmData bpm :bpmDatas) {
//            bpm.setDb_field_type(dbfieldTypeMap.get(bpm.getField_type()));
//            bpmServce.add(bpm);
//        }
//
//        return "";
//    }


    @RequestMapping("/hello")
    public String test(){
        System.out.println("hello boot");
        User user = new User();
        user.setPassWord("12345");
        user.setToken(UUID.randomUUID().toString());
        user.setUserName("系统");
        User user1 = userService.add(user);
        sendMessageService.userMessage(user1);
        System.out.println("user:"+new Gson().toJson(user1));
        return new Gson().toJson(user1);

    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.POST)
    public void queryUser(){

        System.out.println("hello swagger!!!");
        query();
    }

    @RequestMapping("/insert")
    public void insert(User user){
        userService.add(user);
    }

    @RequestMapping("/query")
    public void query(){
//        History query = userService.query();
//        System.out.println("query:"+new Gson().toJson(query));
        System.out.println("11121321311312131");
    }


//    @ApiOperation(value = "用户注册",notes = "这是啥子notes")
//    @ApiImplicitParams（{
//        @ApiImplicitParam(name = "phone",value = "用户手机号码",required = true,dataType = "String",paramType = "query")}）
//    @RequestMapping(value = "insert")
//    public void insert(){
//
//    }


    @RequestMapping("/index")
    public ModelAndView index(){
        System.out.println("index-------------");
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/index2")
    public ModelAndView index2(){
        ModelAndView modelAndView = new ModelAndView("console/index");
        return modelAndView;
    }






    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }





}
