package com.lewis.zhaopin.entity;

import java.io.Serializable;

public class Company implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.name
     *
     * @mbg.generated
     */
    private String name;
    private String account;
    private String pwd;

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

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.guimo
     *
     * @mbg.generated
     */
    private String guimo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.boss
     *
     * @mbg.generated
     */
    private String boss;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.img
     *
     * @mbg.generated
     */
    private String img;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.neturl
     *
     * @mbg.generated
     */
    private String neturl;
    private String jianjie;

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table company
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.id
     *
     * @return the value of company.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.id
     *
     * @param id the value for company.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.name
     *
     * @return the value of company.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.name
     *
     * @param name the value for company.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.guimo
     *
     * @return the value of company.guimo
     *
     * @mbg.generated
     */
    public String getGuimo() {
        return guimo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.guimo
     *
     * @param guimo the value for company.guimo
     *
     * @mbg.generated
     */
    public void setGuimo(String guimo) {
        this.guimo = guimo == null ? null : guimo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.boss
     *
     * @return the value of company.boss
     *
     * @mbg.generated
     */
    public String getBoss() {
        return boss;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.boss
     *
     * @param boss the value for company.boss
     *
     * @mbg.generated
     */
    public void setBoss(String boss) {
        this.boss = boss == null ? null : boss.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.address
     *
     * @return the value of company.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.address
     *
     * @param address the value for company.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.phone
     *
     * @return the value of company.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.phone
     *
     * @param phone the value for company.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.img
     *
     * @return the value of company.img
     *
     * @mbg.generated
     */
    public String getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.img
     *
     * @param img the value for company.img
     *
     * @mbg.generated
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.neturl
     *
     * @return the value of company.neturl
     *
     * @mbg.generated
     */
    public String getNeturl() {
        return neturl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.neturl
     *
     * @param neturl the value for company.neturl
     *
     * @mbg.generated
     */
    public void setNeturl(String neturl) {
        this.neturl = neturl == null ? null : neturl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", guimo=").append(guimo);
        sb.append(", boss=").append(boss);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", img=").append(img);
        sb.append(", neturl=").append(neturl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}