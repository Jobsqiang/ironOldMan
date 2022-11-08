package com.qiangjiang.ironOldMan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qiangjiang.ironOldMan.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @RequestMapping("sendEmail")
    public String sendEmail() throws JsonProcessingException {
        System.out.println("ERP问题追踪汇总");
        String[] toUsers = new String[]{"jiangqiang1@gujing.com.cn"};
        List<String> data = new ArrayList<>();
        data.add("aaaa");
        data.add("bbbb");
        data.add("aaaccca");
        data.add("sdafas");
        data.add("aawerqweraa");
        data.add("qwerq");
        data.add("qwerqwe");
        data.add("qwerqwer");
        data.add("qwerqwer");
        String content = create1();


//        boolean isSend = EmailUtils.sendEmail("这是一封测试邮件", toUsers, null, "<h3><a href='http://www.baidu.com'>百度一下，你就知道</a></h3>", null);
        boolean isSend = EmailUtils.sendEmail("ERP问题追踪汇总", toUsers, null, content, null);
        return "发送邮件:" + isSend;
    }

//    private static String createHTML(String originHtml, List<String> data, boolean headFlage, boolean endFlage) {
//        String html_msg="";
//        if(headFlage){
//            html_msg = "<table border=\"1\" width='80%' height='80'>";
//            html_msg = html_msg+"<tr bgcolor='#B6DDE6'>";
//            for(int column=0;column<data.size();column++){
//                html_msg = html_msg +"<td width='12%'>"+data.get(column)+"</td>";
//            }
//            html_msg = html_msg+"</tr>";
//        }else{
//            html_msg = html_msg+"<tr>";
//            for(int column=0;column<data.size();column++){
//                html_msg = html_msg +"<td>"+data.get(column)+"</td>";
//            }
//            html_msg = html_msg+"</tr>";
//        }
//        if(endFlage){
//            html_msg = html_msg + "</table>";
//        }
//        return originHtml+html_msg;
//    }


    private static String createHTML(){
        String html_msg = "<table border=\"1\" style={{margin:200}}>";
        html_msg = html_msg + "<tr align=\"center\" bgcolor='#B6DDE6'><th colspan=\"3\">2020/02/20</th><th align=\"center\" colspan=\"4\">问题优先级</th><th align=\"center\" colspan=\"4\">问题状态</th></tr>";
        html_msg = html_msg + "<tr><th rowspan=\"2\">项目小组</th><th rowspan=\"2\" colspan=\"2\">分类</th><th bgcolor='#B6DDE6' colspan=\"1\">汇总</th> <th bgcolor='#B6DDE6' colspan=\"1\">高</th> <th bgcolor='#B6DDE6' colspan=\"1\">中</th><th bgcolor='#B6DDE6' colspan=\"1\">低</th>";
        html_msg = html_msg + "<th colspan=\"1\">没开始</th>      <th colspan=\"1\">解决中</th>      <th colspan=\"1\">取消</th>      <th colspan=\"1\">已完成</th>    </tr>";
        html_msg = html_msg + "    <tr>\n" +
                "      <th colspan=\"1\">516</th>\n" +
                "      <th colspan=\"1\">55</th>\n" +
                "      <th colspan=\"1\">439</th>\n" +
                "\n" +
                "      <th colspan=\"1\">22</th>\n" +
                "      <th colspan=\"1\">0</th>\n" +
                "      <th colspan=\"1\">5</th>\n" +
                "      <th colspan=\"1\">1</th>\n" +
                "      <th colspan=\"1\">493</th>\n" +
                "    </tr>";
        html_msg = html_msg + "    <tr>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>";
        return html_msg;
    }

    private static String create1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String html_msg = "<table border=\"1\" style={{margin:200}}>\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <th colspan=\"3\">"+sdf.format(new Date()) +"</th>\n" +
                "      <th colspan=\"4\">问题优先级</th>\n" +
                "      <th colspan=\"4\">问题状态</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th rowspan=\"2\">项目小组</th>\n" +
                "      <th rowspan=\"2\" colspan=\"2\">分类</th>\n" +
                "      <th colspan=\"1\">汇总</th>\n" +
                "      <th colspan=\"1\">高</th>\n" +
                "      <th colspan=\"1\">中</th>\n" +
                "      <th colspan=\"1\">低</th>\n" +
                "      <th colspan=\"1\">没开始</th>\n" +
                "      <th colspan=\"1\">解决中</th>\n" +
                "      <th colspan=\"1\">取消</th>\n" +
                "      <th colspan=\"1\">已完成</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th colspan=\"1\">516</th>\n" +
                "      <th colspan=\"1\">55</th>\n" +
                "      <th colspan=\"1\">439</th>\n" +
                "\n" +
                "      <th colspan=\"1\">22</th>\n" +
                "      <th colspan=\"1\">0</th>\n" +
                "      <th colspan=\"1\">5</th>\n" +
                "      <th colspan=\"1\">1</th>\n" +
                "      <th colspan=\"1\">493</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th rowspan=\"7\">实施小组</th>\n" +
                "      <th rowspan=\"4\">ERP小组</th>\n" +
                "      <th>SD</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th>PP</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th>MM</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th>QM</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "     <tr>\n" +
                "      <th>BPC组</th>\n" +
                "      <th>BPC-P</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th>BPC组</th>\n" +
                "      <th>BPC-C</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th>Tech</th>\n" +
                "      <th>Tech</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th rowspan=\"2\">项目管理组</th>\n" +
                "      <th colspan=\"2\">项目管理</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th colspan=\"2\">其他</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "      <th>我是占位符</th>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>";

        return html_msg;
    }


}
