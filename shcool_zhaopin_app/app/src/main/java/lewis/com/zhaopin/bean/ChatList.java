package lewis.com.zhaopin.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/3/17.
 */

public class ChatList implements Serializable{

    /**
     * code : 0
     * msg : sucess
     * count : 0
     * data : [{"id":2,"name":"计算机","time":"18:00-19:00","zhou":"1-20周","type":"公选课","pId":1,"num":34}]
     */

    public int code;
    public String msg;
    public int count;
    public List<DataBean> data;


    public static class DataBean implements Serializable{


        public int id;
        public int sid;
        public int gid;

        public String time;
        public String sname;
        public String gname;
        public String simg;
        public String gimg;
        public String content;


    }
}
