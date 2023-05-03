package lewis.com.zhaopin.bean;

import java.io.Serializable;

/**
 * Created by Ad
 */
//用户实体
public class SessionInfo implements Serializable{




    public int code;
    public String msg;
    public int count;
    public DataBean data;



    public static class DataBean implements Serializable{


        public int id;
        public int uid;
        public int did;



    }
}
