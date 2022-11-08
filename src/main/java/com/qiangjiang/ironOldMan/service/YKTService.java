package com.qiangjiang.ironOldMan.service;



import com.google.gson.Gson;
import com.qiangjiang.ironOldMan.model.AttendanceModel;
import com.qiangjiang.ironOldMan.protocol.YKTReqData;
import com.qiangjiang.ironOldMan.protocol.YKTResData;
import com.qiangjiang.ironOldMan.utils.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by jq on 2020-11-04
 */
public class YKTService {

    private static Logger logger = LoggerFactory.getLogger(YKTService.class);


//    private static final String URL = "http://10.8.0.62:8001/v1/appinterface";
    private static final String URL = "http://10.150.19.20:8088//v1/appinterface";
    private static final String CODE = "9030";

    public static AttendanceModel dk(AttendanceModel attendanceModel){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        String workNo = attendanceModel.getWorkNo();
        YKTReqData reqData = new YKTReqData();
        reqData.setFuncode(CODE);
        reqData.setSessionid(UUID.randomUUID().toString());
        YKTReqData.DetailData data = new YKTReqData.DetailData();
        data.setEventtime(attendanceModel.getDkTime() == null ? time : attendanceModel.getDkTime());
        data.setWorkno(workNo);
        reqData.setData(data);
        Optional<YKTResData> optional = HttpRequest.postJSON(URL, new Gson().toJson(reqData), workNo, "UTF-8", YKTResData.class);
        if(optional.isPresent()){
            YKTResData resData = optional.get();
            attendanceModel.setResult(new Gson().toJson(resData));
            attendanceModel.setCode(resData.getResult());
            attendanceModel.setMsg(resData.getMsg());
            //如果调用接口失败 发系统通知管理员
            if(resData.getResult() == null || !"0000".equals(resData.getResult())){
//                SystemMessageService.sendMessage("【一卡通消息提醒】工号【"+workNo+"】打卡失败 ，失败原因【"+resData.getMsg()+"】");
            }
        }else{
            attendanceModel.setResult("调用考勤系统失败");
            attendanceModel.setCode("error");
            attendanceModel.setMsg("调用考勤系统失败,请重试！");

//            SystemMessageService.sendMessage("【一卡通消息提醒】 工号【"+workNo+"】打卡失败 ，失败原因【调用考勤系统失败】");
        }
        return attendanceModel;
    }




}
