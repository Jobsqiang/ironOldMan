package com.qiangjiang.ironOldMan.reomteService.chinaUms.refund;

import com.google.gson.Gson;
import com.qiangjiang.ironOldMan.reomteService.chinaUms.HttpRequest;
import com.qiangjiang.ironOldMan.reomteService.chinaUms.pay_protocol.QrcodeReqData;
import com.qiangjiang.ironOldMan.reomteService.chinaUms.pay_protocol.QrcodeResData;
import com.qiangjiang.ironOldMan.reomteService.chinaUms.utils.Util;
import com.qiangjiang.ironOldMan.reomteService.wmhtService.WmhtNewCommonHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Created by jq on 2020-08-31
 */
@Service
public class Refund {
    @Autowired
    private WmhtNewCommonHttpRequest wmhtNewCommonHttpRequest;
    @Autowired
    private HttpRequest httpRequest;


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

//    app支付接口测试环境参数示例
//    商户号(mid):898310148160568 （仅用于支付宝和云闪付）
//
//    仅测试分账功能时使用
//    主商户号：898201612345678
//    子商户号：988460101800201 988460101800202
//    终端号(tid)：00000001
//
//    机构商户号(instMid)：APPDEFAULT
//    消息来源(msgSrc)：WWW.TEST.COM
//    来源编号（msgSrcId）：3194
//    测试环境MD5密钥:fcAmtnx7MwismjWNhNKdHC44mNXtnEQeJkRrhKJwyrW2ysRR

//    private static String url = "https://qr-test2.chinaums.com/netpay-route-server/api/";
//    private static String mid = "898340149000005";
//    private static String tid = "88880001";
//    private static String instMid = "QRPAYDEFAULT";
//    private static String msgSrc = "WWW.TEST.COM";
//    private static String msgSrcId = "3194";
//    private static String key = "fcAmtnx7MwismjWNhNKdHC44mNXtnEQeJkRrhKJwyrW2ysRR";
//    private static String signType ="SHA256";


    private static String url = "https://qr.chinaums.com/netpay-route-server/api/";
    private static String mid = "898341659210007";
    private static String tid = "34161113";
    private static String instMid = "QRPAYDEFAULT";
    private static String msgSrc = "WWW.AHQBYXKJ.COM";
    private static String msgSrcId = "3194";
    private static String key = "WaNmZ4rG8RSxcykE7tTFwaFC3N5bQyt3fnJ5D6jyZsP6YYRX";
    private static String signType ="MD5";


    public void refund(){
        try {

            QrcodeReqData reqData = new QrcodeReqData();
            reqData.setMsgId(msgSrcId);
            reqData.setMsgSrc(msgSrc);
            reqData.setMsgType("bills.refund");
            reqData.setRequestTimestamp(sdf.format(System.currentTimeMillis()));
            reqData.setSrcReserve("测试获取收款码");
            reqData.setMid(mid);
            reqData.setTid(tid);
            reqData.setInstMid("QRPAYDEFAULT");
            reqData.setBillNo("3941GJ202009100816020868819558");
            reqData.setBillDesc("流程罚款");
            reqData.setBillDate(sdf1.format(new Date()));
            reqData.setRefundOrderId("3194TK"+System.currentTimeMillis());
            reqData.setRefundAmount(1);
            reqData.setSignType(signType);
            reqData.setNotifyUrl("https://bpmcs.gujing.cn/r/w?cmd=com.awspaas.user.apps.gujingpay.chinaUmsNotify");
            String sign = Util.makeSign(key, reqData.toMap(), signType);
            reqData.setSign(sign);
            System.out.println("reqDate:"+new Gson().toJson(reqData));
            Optional<QrcodeResData> postJSON = httpRequest.postJSON(url, new Gson().toJson(reqData), "","UTF-8", QrcodeResData.class);
//        Optional<String> postJSON = wmhtNewCommonHttpRequest.postJSON("https://qr-test2.chinaums.com/netpay-route-server/api/", reqData, "");
            System.out.println("postJSON:"+new Gson().toJson(postJSON.get()));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
