package com.qiangjiang.ironOldMan.model;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Optional;

/**
 * Created by jq on 12/21/20
 */
public class HttpRequest {

    private static Logger logger = LoggerFactory.getLogger(HttpRequest.class);

    private static int connectTimeout = 15000;
    private static int socketTimeout = 15000;
    private String ENCODE = "UTF-8";



    public static Optional postJSON(String url, String param, String bankOrderNo, String charSet, Class resClass){
        logger.info("一卡通请求参数 url [ "+url+" ] bankOrderNo ["+bankOrderNo+"]  reqDdata ["+param+"]");
        long startTime = System.currentTimeMillis();
        HttpClient httpClient = null;
        HttpResponse response = null;
        HttpPost httpPost = new HttpPost(url);
        try{
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
            if (param != null && !"".equals(param)) {
                StringEntity reqEntity = new StringEntity(param, ContentType.create("text/plain", charSet));
                reqEntity.setContentType("application/json");
                reqEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                httpPost.setEntity(reqEntity);
            }
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
            httpPost.setConfig(requestConfig);
            httpClient = HttpClients.createDefault();
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                //  logger.info("url [ "+url+" ] bankOrderNo ["+bankOrderNo+" ] resDdata ["+result+"]");
                logger.info("一卡通响应参数"+result);
                Object object = new Gson().fromJson(result, resClass);
                return Optional.ofNullable(object);
            }
        }catch (ConnectionPoolTimeoutException e) {
            //  e.printStackTrace();
            logger.error("connectPool timeout" + httpPost.getRequestLine(),e);
        } catch (ConnectTimeoutException e) {
            //  e.printStackTrace();
            logger.error("connect timeout " + httpPost.getRequestLine(),e);
        } catch (SocketTimeoutException e) {
            //   e.printStackTrace();
            logger.error("socket timeout " + httpPost.getRequestLine(),e);
        } catch(UnknownHostException e){
            //   e.printStackTrace();
            logger.error("UnknownHostException " + httpPost.getRequestLine(),e);
        }catch (Exception e) {
            //    e.printStackTrace();
            logger.error("exception " + httpPost.getRequestLine(),e);
        }finally{
            if (logger.isInfoEnabled()) {
                logger.info("url [" + url + "] bankOrderNo [" + bankOrderNo + "] cost [" + (System.currentTimeMillis() - startTime)  + "]ms");
            }
            httpPost.abort();
        }
        return Optional.empty();
    }
}
