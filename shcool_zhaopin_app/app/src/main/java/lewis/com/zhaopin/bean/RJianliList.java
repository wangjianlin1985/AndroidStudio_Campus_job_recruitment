package lewis.com.zhaopin.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2021/4/13.
 */

public class RJianliList implements Serializable{

    /**
     * code : 0
     * msg : sucess
     * count : 0
     * data : [{"toudi":{"id":3,"jid":1,"uid":1,"pid":1,"status":"待处理"},"jianli":{"id":1,"img":"http://192.168.1.6:8080/1587872872137762.jpg","name":"小王","sex":"男","age":18,"xueli":"本科","school":"郑大","jingyan":"3年","phone":"156797979797","address":"郑州东站","position":"ios工程师","jingli":"老婆破rosy在真肉在说切也","moeny":"8000","pingjia":"这破网人做说切转切转切也","uid":2}},{"toudi":{"id":4,"jid":2,"uid":3,"pid":1,"status":"已拒绝"},"jianli":{"id":2,"img":"http://192.168.1.6:8080/1587872872137762.jpg","name":"小王","sex":"男","age":18,"xueli":"本科","school":"郑大","jingyan":"2年","phone":"156797979797","address":"郑州东站","position":"java工程师","jingli":"老婆破rosy在真肉在说切也","moeny":"3456","pingjia":"这破网人做说切转切转切也","uid":2}},{"toudi":{"id":5,"jid":2,"uid":2,"pid":1,"status":"待处理"},"jianli":{"id":2,"img":"http://192.168.1.6:8080/1587872872137762.jpg","name":"小王","sex":"男","age":18,"xueli":"本科","school":"郑大","jingyan":"2年","phone":"156797979797","address":"郑州东站","position":"java工程师","jingli":"老婆破rosy在真肉在说切也","moeny":"3456","pingjia":"这破网人做说切转切转切也","uid":2}}]
     */

    public int code;
    public String msg;
    public int count;
    public List<DataBean> data;



    public static class DataBean implements Serializable{
        /**
         * toudi : {"id":3,"jid":1,"uid":1,"pid":1,"status":"待处理"}
         * jianli : {"id":1,"img":"http://192.168.1.6:8080/1587872872137762.jpg","name":"小王","sex":"男","age":18,"xueli":"本科","school":"郑大","jingyan":"3年","phone":"156797979797","address":"郑州东站","position":"ios工程师","jingli":"老婆破rosy在真肉在说切也","moeny":"8000","pingjia":"这破网人做说切转切转切也","uid":2}
         */

        public ToudiBean toudi;
        public JianliBean jianli;



        public static class ToudiBean implements Serializable{
            /**
             * id : 3
             * jid : 1
             * uid : 1
             * pid : 1
             * status : 待处理
             */

            public int id;
            public int jid;
            public int uid;
            public int pid;
            public String status;


        }

        public static class JianliBean implements Serializable{
            /**
             * id : 1
             * img : http://192.168.1.6:8080/1587872872137762.jpg
             * name : 小王
             * sex : 男
             * age : 18
             * xueli : 本科
             * school : 郑大
             * jingyan : 3年
             * phone : 156797979797
             * address : 郑州东站
             * position : ios工程师
             * jingli : 老婆破rosy在真肉在说切也
             * moeny : 8000
             * pingjia : 这破网人做说切转切转切也
             * uid : 2
             */

            public int id;
            public String img;
            public String name;
            public String sex;
            public int age;
            public String xueli;
            public String school;
            public String jingyan;
            public String phone;
            public String address;
            public String position;
            public String jingli;
            public String moeny;
            public String pingjia;
            public int uid;


        }
    }
}
