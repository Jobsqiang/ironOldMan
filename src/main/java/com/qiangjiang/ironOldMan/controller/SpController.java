//package com.qiangjiang.ironOldMan.controller;
//
//import com.qiangjiang.ironOldMan.reomteService.wmhtService.WmhtNewCommonHttpRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by jq on 1/6/21
// */
//@RestController
//public class SpController {
//
//    @Autowired
//    private WmhtNewCommonHttpRequest httpRequest;
//    public static List<String> list = new ArrayList<>();
//
//
////    static {
////        list.add("NGHSP2021-01-09-017");//50° 500ml幸福版*6
////        list.add("NGHSP2021-01-09-007");//50° 500ml古5*6
////
////    }
//
//
//    @RequestMapping("/go")
//    public void go(){
//        String sp_hb5 = "NGHSP2021-01-09-007";
//        String sp_hbxf = "NGHSP2021-01-09-017";
//        String sid = "d8d3907c-c2c4-4afd-bcf2-726d307f9bdf";//蒋勇
//        String sid1 = "d17116ac-cca0-4cfa-ba1b-9a3504ac367a";//蒋强
//        String sid2 = "65762953-4f8d-4df8-8043-ab3312d02635";//王习文
//        String sid3 = "79fe7528-c25b-4987-bb96-c1f87a0fd181";//武辉
//        String sid4 = "4a1980e8-ceb7-4d47-bb16-6372e956efbb";//王叶帧
//        String sid5 = "8cf0a8b1-0cae-4eef-9f92-8b298ebb3088";//石亚伦
//        String sid6 = "b7ad7f2a-4095-412e-a010-1bc715e93ca8";//叶子
//        String sid7 = "eae8034f-5236-41ed-9501-8e40163270f6";//杨东来
//        String sid8 = "3cbcc1dc-4e18-4a31-85ee-139c172a54cd";//周岳飞
//        while (true){
//            long start = System.currentTimeMillis();
//            String url ="https://www.gujing.cn/r/w?sid="+sid+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hb5+"";
//            String url1 ="https://www.gujing.cn/r/w?sid="+sid1+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hb5+"";
//            String url2 ="https://www.gujing.cn/r/w?sid="+sid2+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hb5+"";
//            String url3 ="https://www.gujing.cn/r/w?sid="+sid3+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hb5+"";
//            String url4 ="https://www.gujing.cn/r/w?sid="+sid4+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hb5+"";
//            String url5 ="https://www.gujing.cn/r/w?sid="+sid5+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hb5+"";
//            String url6 ="https://www.gujing.cn/r/w?sid="+sid6+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hb5+"";
//            String url7 ="https://www.gujing.cn/r/w?sid="+sid7+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url8 ="https://www.gujing.cn/r/w?sid="+sid8+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hb5+"";
//            String resData = httpRequest.executeGetNew(url, null);
//            String resData1 = httpRequest.executeGetNew(url1, null);
//            String resData2 = httpRequest.executeGetNew(url2, null);
//            String resData3 = httpRequest.executeGetNew(url3, null);
//            String resData4 = httpRequest.executeGetNew(url4, null);
//            String resData5 = httpRequest.executeGetNew(url5, null);
//            String resData6 = httpRequest.executeGetNew(url6, null);
//            String resData7 = httpRequest.executeGetNew(url7, null);
//            String resData8 = httpRequest.executeGetNew(url8, null);
//            System.out.println("url------->"+url+"返回："+resData);
//            System.out.println("url------->"+url1+"返回："+resData1);
//            System.out.println("url------->"+url2+"返回："+resData2);
//            System.out.println("url------->"+url3+"返回："+resData3);
//            System.out.println("url------->"+url4+"返回："+resData4);
//            System.out.println("url------->"+url5+"返回："+resData5);
//            System.out.println("url------->"+url6+"返回："+resData6);
//            System.out.println("url------->"+url7+"返回："+resData7);
//            System.out.println("url------->"+url8+"返回："+resData8);
//            System.out.println("花费："+(System.currentTimeMillis()-start));
//        }
//
//    }
//
//
//    @RequestMapping("/go1")
//    public void go1(){
////        String sp_hb5 = "NGHSP2021-01-09-007";
//        String sp_hbxf = "NGHSP2021-01-09-017";
//        String sid = "d8d3907c-c2c4-4afd-bcf2-726d307f9bdf";//蒋勇
//        String sid1 = "d17116ac-cca0-4cfa-ba1b-9a3504ac367a";//蒋强
//        String sid2 = "65762953-4f8d-4df8-8043-ab3312d02635";//王习文
//        String sid3 = "79fe7528-c25b-4987-bb96-c1f87a0fd181";//武辉
//        String sid4 = "4a1980e8-ceb7-4d47-bb16-6372e956efbb";//王叶帧
//        String sid5 = "8cf0a8b1-0cae-4eef-9f92-8b298ebb3088";//石亚伦
//        String sid6 = "b7ad7f2a-4095-412e-a010-1bc715e93ca8";//叶子
//        String sid7 = "eae8034f-5236-41ed-9501-8e40163270f6";//杨东来
//        String sid8 = "3cbcc1dc-4e18-4a31-85ee-139c172a54cd";//周岳飞
//        while (true){
//            long start = System.currentTimeMillis();
//            String url ="https://www.gujing.cn/r/w?sid="+sid+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url1 ="https://www.gujing.cn/r/w?sid="+sid1+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url2 ="https://www.gujing.cn/r/w?sid="+sid2+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url3 ="https://www.gujing.cn/r/w?sid="+sid3+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url4 ="https://www.gujing.cn/r/w?sid="+sid4+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url5 ="https://www.gujing.cn/r/w?sid="+sid5+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url6 ="https://www.gujing.cn/r/w?sid="+sid6+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url7 ="https://www.gujing.cn/r/w?sid="+sid7+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String url8 ="https://www.gujing.cn/r/w?sid="+sid8+"&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=5&sp_bh="+sp_hbxf+"";
//            String resData = httpRequest.executeGetNew(url, null);
//            String resData1 = httpRequest.executeGetNew(url1, null);
//            String resData2 = httpRequest.executeGetNew(url2, null);
//            String resData3 = httpRequest.executeGetNew(url3, null);
//            String resData4 = httpRequest.executeGetNew(url4, null);
//            String resData5 = httpRequest.executeGetNew(url5, null);
//            String resData6 = httpRequest.executeGetNew(url6, null);
//            String resData7 = httpRequest.executeGetNew(url7, null);
//            String resData8 = httpRequest.executeGetNew(url8, null);
//            System.out.println("url------->"+url+"返回："+resData);
//            System.out.println("url------->"+url1+"返回："+resData1);
//            System.out.println("url------->"+url2+"返回："+resData2);
//            System.out.println("url------->"+url3+"返回："+resData3);
//            System.out.println("url------->"+url4+"返回："+resData4);
//            System.out.println("url------->"+url5+"返回："+resData5);
//            System.out.println("url------->"+url6+"返回："+resData6);
//            System.out.println("url------->"+url7+"返回："+resData7);
//            System.out.println("url------->"+url8+"返回："+resData8);
//            System.out.println("花费："+(System.currentTimeMillis()-start));
//        }
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
////    @RequestMapping("/go11111")
////    public void go11111(){
////        while (true){
////            String urlbase ="https://www.gujing.cn/r/w?sid=a1577c7d-b8ce-4ea2-89b4-bd89badc0e23&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=1&sp_bh=";
////            String resData = null;
////            long start = System.currentTimeMillis();
////            for (String str:list) {
////                String urllll = urlbase+str;
////                System.out.println("url------->"+urllll);
////                resData = httpRequest.executeGetNew(urllll, null);
////                System.out.println("商品：【"+str+"】    返回------->"+resData);
////            }
////            System.out.println("花费："+(System.currentTimeMillis()-start));
////            System.out.println("1111111111");
////        }
////
////    }
////
////
////    @RequestMapping("/qiangjiang")
////    public void gan(){
////        while (true){
//////            String urlbase ="https://www.gujing.cn/r/w?sid=a1577c7d-b8ce-4ea2-89b4-bd89badc0e23&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=1&sp_bh=";
//////            String resData = null;
//////            long start = System.currentTimeMillis();
//////            for (String str:list) {
//////                String urllll = urlbase+str;
//////                System.out.println("url------->"+urllll);
//////                resData = httpRequest.executeGetNew(urllll, null);
//////                System.out.println("商品：【"+str+"】    返回------->"+resData);
//////            }
//////            System.out.println("花费："+(System.currentTimeMillis()-start));
////            System.out.println("1111111111");
////        }
////
////    }
////
////    @RequestMapping("/qiangjiang1")
////    public void gan1(){
////        while (true){
////            String urlbase ="https://www.gujing.cn/r/w?sid=a1577c7d-b8ce-4ea2-89b4-bd89badc0e23&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=1&sp_bh=";
////            String resData = null;
////            long start = System.currentTimeMillis();
////            for (String str:list) {
////                String urllll = urlbase+str;
////                System.out.println("url------->"+urllll);
////                resData = httpRequest.executeGetNew(urllll, null);
////                System.out.println("商品：【"+str+"】    返回111------->"+resData);
////            }
////            System.out.println("花费111："+(System.currentTimeMillis()-start));
////        }
////
////    }
////
////    @RequestMapping("/qiangjiang2")
////    public void gan2(){
////        while (true){
////            String urlbase ="https://www.gujing.cn/r/w?sid=a1577c7d-b8ce-4ea2-89b4-bd89badc0e23&cmd=com.awspaas.user.apps.neigouhui_createorder&sp_num=1&sp_bh=";
////            String resData = null;
////            long start = System.currentTimeMillis();
////            for (String str:list) {
////                String urllll = urlbase+str;
////                System.out.println("url------->"+urllll);
////                resData = httpRequest.executeGetNew(urllll, null);
////                System.out.println("商品：【"+str+"】    返回222------->"+resData);
////            }
////            System.out.println("花费222："+(System.currentTimeMillis()-start));
////        }
////
////    }
//
//}
