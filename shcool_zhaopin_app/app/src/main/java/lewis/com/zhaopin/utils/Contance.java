package lewis.com.zhaopin.utils;

/**
 * Created by Administrator on 2019/5/15.
 */
//接口
public class Contance {
    //换成自己电脑ip
    public static  String BaseUrl="http://192.168.1.5:8080";
    public static String Login=BaseUrl+"/user/login";//登录
    public static String Reg=BaseUrl+"/user/register";//注册
    public static String companyLogin=BaseUrl+"/company/login";//登录
    public static String companyReg=BaseUrl+"/company/register";//注册
    public static String upCompany=BaseUrl+"/company/upCompany";//注册


    public static String getUserInfo=BaseUrl+"/user/getUserInfo";//用户信息
    public static String upUserInfo=BaseUrl+"/user/upUser";//修改用户
    public static String upPwd=BaseUrl+"/user/upPwd";//修改
    public static String UpLoadPic=BaseUrl+"/upload";//上传头像

    public static String getAllPositionApp=BaseUrl+"/position/getAllPositionApp";//所有
    public static String addPosition=BaseUrl+"/position/addPosition";//所有
    public static String upPosition=BaseUrl+"/position/upPosition";//所有
    public static String delPosition=BaseUrl+"/position/delPosition";//所有
    public static String getAllPositionByAppCid=BaseUrl+"/position/getAllPositionByAppCid";//所有
    public static String getAllPositionByKey=BaseUrl+"/position/getAllPositionByKey";//所有
    public static String getMyJianli=BaseUrl+"/jianli/getMyJianli";//所有
    public static String addJianli=BaseUrl+"/jianli/addJianli";//所有
    public static String getCompanyInfo=BaseUrl+"/company/getCompanyInfo";//所有
    public static String addToudi=BaseUrl+"/toudi/addToudi";//所有
    public static String getMyToudi=BaseUrl+"/toudi/getMyToudi";//所有
    public static String upStatus=BaseUrl+"/toudi/upStatus";//所有
    public static String getToudibyP=BaseUrl+"/toudi/getToudibyP";//所有
    public static String storeP=BaseUrl+"/position/storeP";//所有
    public static String getMyStore=BaseUrl+"/position/getMyStore";//所有


    public static String addLuntan=BaseUrl+"/luntan/addLuntan";
    public static String getAllLuntanApp=BaseUrl+"/luntan/getAllLuntanApp";
    public static String getMyChat=BaseUrl+"/chat/getMyChat";
    public static String addChat=BaseUrl+"/chat/addChat";
    public static String addSession=BaseUrl+"/chat/addSession";
    public static String getMySession=BaseUrl+"/chat/getMySession";
}
