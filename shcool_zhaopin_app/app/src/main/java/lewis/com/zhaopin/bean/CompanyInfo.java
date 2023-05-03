package lewis.com.zhaopin.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/4/26.
 */

public class CompanyInfo implements Serializable{

    /**
     * code : 0
     * msg : faile
     * count : 0
     * data : {"id":6,"name":"dassa","account":"dsasd","pwd":"asa","guimo":"ddsad","boss":"saddsaas","address":"dasdas","phone":"dasasd","img":"http://localhost:8080/1584408680482870.jpg","neturl":null}
     */

    public int code;
    public String msg;
    public int count;
    public DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * id : 6
         * name : dassa
         * account : dsasd
         * pwd : asa
         * guimo : ddsad
         * boss : saddsaas
         * address : dasdas
         * phone : dasasd
         * img : http://localhost:8080/1584408680482870.jpg
         * neturl : null
         */

        public int id;
        public String name;
        public String account;
        public String pwd;
        public String guimo;
        public String boss;
        public String address;
        public String phone;
        public String img;
        public String neturl;
        public String jianjie;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getGuimo() {
            return guimo;
        }

        public void setGuimo(String guimo) {
            this.guimo = guimo;
        }

        public String getBoss() {
            return boss;
        }

        public void setBoss(String boss) {
            this.boss = boss;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }


    }
}
