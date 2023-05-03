package lewis.com.zhaopin.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/4/21.
 */

public class PositionList implements Serializable{


    /**
     * code : 0
     * msg : success
     * count : 1
     * data : [{"id":1,"cid":6,"name":"weqw","money":"WEQWQEQW","dec":"WSEQW","time":"2020-04-24 16:05"}]
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

    public static class DataBean implements Serializable{
        /**
         * id : 1
         * cid : 6
         * name : weqw
         * money : WEQWQEQW
         * dec : WSEQW
         * time : 2020-04-24 16:05
         */

        public int id;
        public int cid;
        public String name;
        public String money;
        public String dec;
        public String time;
        public String jianjie;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getDec() {
            return dec;
        }

        public void setDec(String dec) {
            this.dec = dec;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
