package com.qiangjiang.ironOldMan.reomteService.wmhtService.common;



import com.qiangjiang.ironOldMan.utils.MD5;
import com.qiangjiang.ironOldMan.utils.Util;
import com.qiangjiang.ironOldMan.utils.XMLParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class WmhtUtils {
    private static Logger logger = LoggerFactory.getLogger(WmhtUtils.class);

    /**
     * 唯美汇通生产签名
     * @param map
     * @param mchKey
     * @return
     */
    public static String getSign(Map<String,Object> map, String mchKey){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + mchKey;
        logger.info("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        return result;
    }


    /**
     * 唯美汇通对相应验签
     * @param responseString
     * @param mchKey
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static boolean checkIsSignValidFromResponseString(String responseString,String mchKey) throws ParserConfigurationException, IOException, SAXException {

        Map<String,Object> map = XMLParser.getMapFromXML(responseString);
        Util.log(map.toString());
        // return_code为SUCCESS时才会返回签名
        String returnCode = map.get("return_code").toString();
        if("SUCCESS".equals(returnCode)){
            String signFromAPIResponse = map.get("sign").toString();
            if(signFromAPIResponse == null || "".equals(signFromAPIResponse)){
                Util.log("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
                return false;
            }
            //Util.log("服务器回包里面的签名是:" + signFromAPIResponse);
            //清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
            map.put("sign","");
            //将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
            String signForAPIResponse = getSign(map,mchKey);
            if(!signForAPIResponse.equals(signFromAPIResponse)){
                //签名验不过，表示这个API返回的数据有可能已经被篡改了
                //Util.log("API返回的数据签名验证不通过，有可能被第三方篡改!!!");
                return false;
            }
            //Util.log("恭喜，API返回的数据签名验证通过!!!");
        }

        return true;
    }


//    public static String transForBody(String oldBody,String merchantStoreNo){
//        String shopName = getShopName(oldBody);
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("body",oldBody);
//        map.put("client_name",shopName);
//        map.put("client_id",merchantStoreNo);
//        map.put("device",merchantStoreNo);
//        String body = JSON.toJSONString(map);
//
////        String body ="{" +
////                "\"body\":\""+oldBody+"\"," +
////                "\"client_name\":\""+merchantStoreNo+"\"," +
////                "\"client_id\":\""+merchantStoreNo+"\"," +
////                "\"device\":\""+merchantStoreNo+"\"" +
////                "}";
//        return body;
//    }

    /**
     * 根据商品备注获取店铺名称
     * @param str
     * @return
     */
    public static String getShopName(String str){
        if(StringUtils.isEmpty(str)){
            return "";
        }
        int i = str.lastIndexOf("(");
        String shopName = null;
        if(str.contains("\n")){
            int n = str.lastIndexOf("\n");
            shopName = str.substring(n+1, i);
        }else{
            shopName = str.substring(0, i);
        }
        return shopName;
    }

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static  String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
