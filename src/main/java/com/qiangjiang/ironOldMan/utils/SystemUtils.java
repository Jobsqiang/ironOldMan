package com.qiangjiang.ironOldMan.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class SystemUtils {
    private static Map<String, String> systemMap = new HashMap();

    public SystemUtils() {
    }

    public static String sysHostname() {
        String hostname = (String)systemMap.get("hostname");
        if (hostname == null) {
            try {
                hostname = InetAddress.getLocalHost().getHostName();
            } catch (Exception var2) {
                hostname = "";
            }

            systemMap.put("hostname", hostname);
        }

        return hostname;
    }

    public static String sysHostAddress() {
        String hostaddress = (String)systemMap.get("hostaddress");
        if (hostaddress == null) {
            try {
                hostaddress = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception var2) {
                hostaddress = "";
            }

            systemMap.put("hostaddress", hostaddress);
        }

        return hostaddress;
    }


    public static JsonArray generateGoodDetailForWechat(String price) {
        JsonArray products = new JsonArray();
        JsonObject product = new JsonObject();
        product.addProperty("out_dish_no", "1691001");
        product.addProperty("name", "消费项目");
        product.addProperty("price", new BigDecimal(price).multiply(new BigDecimal(100)).intValue());
        product.addProperty("unit", "BY_SHARE");
        product.addProperty("count", (float) 1);
        products.add(product);
        return products;

    }
}
