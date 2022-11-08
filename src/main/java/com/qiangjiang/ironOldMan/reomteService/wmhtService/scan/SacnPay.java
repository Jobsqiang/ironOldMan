package com.qiangjiang.ironOldMan.reomteService.wmhtService.scan;

import com.qiangjiang.ironOldMan.reomteService.wmhtService.WmhtNewCommonHttpRequest;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.WmhtPayProps;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.common.WmhtUtils;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.pay_protocol.ScanPayReqData;
import com.qiangjiang.ironOldMan.utils.DateUtils;
import com.qiangjiang.ironOldMan.utils.MD5;
import com.qiangjiang.ironOldMan.utils.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Service
public class SacnPay {

    @Autowired
    private WmhtNewCommonHttpRequest httpRequest;

    @Autowired
    private WmhtPayProps payProps;

    public void scan(){

        String bankOrderNo = "op"+System.currentTimeMillis();
        int transAmount = new BigDecimal("1").intValue();  //以分为单位
        String notifyAddress=payProps.getNotifyAddress();
        String ip= SystemUtils.sysHostAddress();
        String timeExpire = DateUtils.getCurrentDateTime(payProps.getExpireTime()*60);
        String payCode = "136536564423314826";
        String body = "备注";

        ScanPayReqData reqData =new ScanPayReqData(payCode,body,null,bankOrderNo,transAmount,
                "",ip, DateUtils.getCurrentDateTime(), timeExpire,"");
        reqData.setAppid(payProps.getAppId());
        reqData.setMch_id(payProps.getMchId());
        reqData.setNonce_str(WmhtUtils.getRandomStringByLength(32));
        String sign = WmhtUtils.getSign(reqData.toMap(), payProps.getMchKey());
        reqData.setSign(sign);
        Optional<String> optional = httpRequest.postJSON(payProps.getScanAddress(), reqData, bankOrderNo);
        String s = optional.get();
        System.out.println("s:"+s);


    }



}
