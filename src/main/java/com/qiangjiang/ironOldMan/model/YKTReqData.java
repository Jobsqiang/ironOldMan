package com.qiangjiang.ironOldMan.model;

import lombok.Data;

/**
 * Created by jq on 12/21/20
 */
@Data
public class YKTReqData {

    private String funcode;
    private String sessionid;
    private String datetime;
    private DetailData data;

    @Data
    public static class DetailData{
        private String workno;
        private String eventtime;
    }

}
