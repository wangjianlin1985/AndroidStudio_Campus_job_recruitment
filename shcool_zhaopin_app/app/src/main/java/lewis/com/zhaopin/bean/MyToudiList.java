package lewis.com.zhaopin.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/4/26.
 */

public class MyToudiList {

    /**
     * code : 0
     * msg : sucess
     * count : 0
     * data : [{"pid":1,"uid":1,"tid":3,"jid":1,"name":"weqw","dec":"WSEQW","money":"WEQWQEQW","time":"2020-04-24 16:05","status":"待处理"}]
     */

    public int code;
    public String msg;
    public int count;
    public List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pid : 1
         * uid : 1
         * tid : 3
         * jid : 1
         * name : weqw
         * dec : WSEQW
         * money : WEQWQEQW
         * time : 2020-04-24 16:05
         * status : 待处理
         */

        public int pid;
        public int uid;
        public int tid;
        public int jid;
        public String name;
        public String dec;
        public String money;
        public String time;
        public String status;

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDec() {
            return dec;
        }

        public void setDec(String dec) {
            this.dec = dec;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
