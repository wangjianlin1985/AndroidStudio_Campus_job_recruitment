package lewis.com.zhaopin.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/3/23.
 */

public class TiziList implements Serializable{


    /**
     * code : 0
     * msg : success
     * count : 2
     * data : [{"id":1,"uid":0,"uimg":"http://localhost:8080/logo.jpg","uname":"官网认证","content":"sadasda","time":"2020-04-24 14:48","title":"sadasdas"},{"id":2,"uid":6,"uimg":"http://localhost:8080/1584408680482870.jpg","uname":"dassa","content":"dasdasdasd","time":"2020-04-24 15:42","title":"sdadas"}]
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
         * uid : 0
         * uimg : http://localhost:8080/logo.jpg
         * uname : 官网认证
         * content : sadasda
         * time : 2020-04-24 14:48
         * title : sadasdas
         */

        public int id;
        public int uid;
        public String uimg;
        public String uname;
        public String content;
        public String time;
        public String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUimg() {
            return uimg;
        }

        public void setUimg(String uimg) {
            this.uimg = uimg;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
