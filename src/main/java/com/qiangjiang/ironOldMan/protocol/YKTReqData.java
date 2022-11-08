package com.qiangjiang.ironOldMan.protocol;

/**
 * Created by jq on 2020-11-04
 */
public class YKTReqData {
    private String funcode;
    private String sessionid;
    private String datetime;

    private DetailData data;

    public static class DetailData{
        private String workno;
        private String eventtime;

        public String getWorkno() {
            return workno;
        }

        public void setWorkno(String workno) {
            this.workno = workno;
        }

        public String getEventtime() {
            return eventtime;
        }

        public void setEventtime(String eventtime) {
            this.eventtime = eventtime;
        }
    }

    public String getFuncode() {
        return funcode;
    }

    public void setFuncode(String funcode) {
        this.funcode = funcode;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public DetailData getData() {
        return data;
    }

    public void setData(DetailData data) {
        this.data = data;
    }
}
