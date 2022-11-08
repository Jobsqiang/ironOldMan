package com.qiangjiang.ironOldMan.test;


import com.qiangjiang.ironOldMan.model.AttendanceModel;
import com.qiangjiang.ironOldMan.service.YKTService;

/**
 * Created by jq on 1/25/21
 */
public class TestContorller {

    public static void main(String[] args) {
//        String userNo = "G12614";
        String userNo = "G81634";
        String dkTime = "2022-05-16 07:58:11";
        AttendanceModel model = new AttendanceModel();
        model.setWorkNo(userNo);
        model.setDkTime(dkTime);

        //2.传输到考勤系统
        model = YKTService.dk(model);
    }
}
