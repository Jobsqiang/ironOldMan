package com.qiangjiang.ironOldMan.reomteService;

import com.google.gson.Gson;
import com.qiangjiang.ironOldMan.model.AttendanceModel;
import com.qiangjiang.ironOldMan.model.HttpRequest;
import com.qiangjiang.ironOldMan.model.YKTReqData;
import com.qiangjiang.ironOldMan.model.YKTResData;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;


@Service
public class TestService {



//    private static Logger logger = LoggerFactory.getLogger(YKTService.class);

    private static final String URL = "http://10.8.0.62:8001/v1/appinterface";
    private static final String CODE = "9030";

    public static AttendanceModel dk(String workNo){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
//        String workNo = attendanceModel.getWorkNo();
        YKTReqData reqData = new YKTReqData();
        reqData.setFuncode(CODE);
        reqData.setSessionid(UUID.randomUUID().toString());
        YKTReqData.DetailData data = new YKTReqData.DetailData();
        data.setEventtime(time);
        data.setWorkno(workNo);
        reqData.setData(data);
        Optional<YKTResData> optional = HttpRequest.postJSON(URL, new Gson().toJson(reqData), workNo, "UTF-8", YKTResData.class);
        if(optional.isPresent()){
            YKTResData resData = optional.get();
//            attendanceModel.setResult(new Gson().toJson(resData));
//            attendanceModel.setCode(resData.getResult());
//            attendanceModel.setMsg(resData.getMsg());
        }else{
//            attendanceModel.setResult("调用考勤系统失败");
//            attendanceModel.setCode("error");
//            attendanceModel.setMsg("调用考勤系统失败,请重试！");
        }
        return null;
    }
    public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");


}
