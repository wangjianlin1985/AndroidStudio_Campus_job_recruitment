package lewis.com.zhaopin.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/4/26.
 */

public class JianLiList implements Serializable{

    /**
     * code : 0
     * msg : success
     * count : 1
     * data : [{"id":1,"img":"sdas","name":"asda","sex":"男","age":12,"xueli":"萨达","school":"阿达","jingyan":"阿达","phone":"阿达","address":null,"position":null,"jingli":null,"moeny":null,"pingjia":null,"uid":2}]
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
         * img : sdas
         * name : asda
         * sex : 男
         * age : 12
         * xueli : 萨达
         * school : 阿达
         * jingyan : 阿达
         * phone : 阿达
         * address : null
         * position : null
         * jingli : null
         * moeny : null
         * pingjia : null
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
        public Object address;
        public Object position;
        public Object jingli;
        public Object moeny;
        public Object pingjia;
        public int uid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getXueli() {
            return xueli;
        }

        public void setXueli(String xueli) {
            this.xueli = xueli;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getJingyan() {
            return jingyan;
        }

        public void setJingyan(String jingyan) {
            this.jingyan = jingyan;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getPosition() {
            return position;
        }

        public void setPosition(Object position) {
            this.position = position;
        }

        public Object getJingli() {
            return jingli;
        }

        public void setJingli(Object jingli) {
            this.jingli = jingli;
        }

        public Object getMoeny() {
            return moeny;
        }

        public void setMoeny(Object moeny) {
            this.moeny = moeny;
        }

        public Object getPingjia() {
            return pingjia;
        }

        public void setPingjia(Object pingjia) {
            this.pingjia = pingjia;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
