package com.lewis.zhaopin.controller;

import com.lewis.zhaopin.entity.ComResult;
import com.lewis.zhaopin.entity.Jianli;
import com.lewis.zhaopin.mapper.JianliMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/jianli")
public class JianLiController {
    @Autowired
    JianliMapper jianliMapper;



    @RequestMapping(value = "/getMyJianli",method = RequestMethod.POST)
    public ComResult<List<Jianli>>  getMyJianli(Integer uid){
        List<Jianli> Jianlis1 = jianliMapper.selectAll();
        List<Jianli> list=new ArrayList<>();
        for (int i = 0; i <Jianlis1.size() ; i++) {
            Jianli jianli = Jianlis1.get(i);
            if (jianli.getUid()==uid){
                list.add(jianli);
            }
        }
        ComResult<List<Jianli>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(list.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }
  @RequestMapping(value = "/getJianLiInfo",method = RequestMethod.POST)
    public ComResult<Jianli>  getJianLiInfo(Integer id){
      Jianli jianli = jianliMapper.selectByPrimaryKey(id);
      ComResult<Jianli> result = new ComResult<>();
        result.setCode(0);

        result.setData(jianli);
        result.setMsg("success");
        return result;
    }


    //注册
  @RequestMapping(value = "/addJianli",method = RequestMethod.POST)
    public ComResult  register(Integer uid,String img,String name,String sex,
                               Integer age,String xueli,String school,String jingyan,
                               String phone,String address,String position,String jingli,String pingjia,
                               String money) throws Exception {

      Jianli Jianli = new Jianli();
      Jianli.setAddress(address);
      Jianli.setAge(age);
      Jianli.setImg(img);
      Jianli.setUid(uid);
      Jianli.setName(name);
      Jianli.setSex(sex);
      Jianli.setXueli(xueli);
      Jianli.setSchool(school);
      Jianli.setJingli(jingli);
      Jianli.setJingyan(jingyan);
      Jianli.setPhone(phone);
      Jianli.setPosition(position);
      Jianli.setPingjia(pingjia);
      Jianli.setMoeny(money);



          int i = jianliMapper.insert(Jianli);
      ComResult result = new ComResult<>();

          if (i==1){
              result.setMsg("添加成功");
          }else {
              result.setMsg("注册失败");
          }
          result.setCode(0);

          return result;



    }

    //
    @RequestMapping(value = "/delJianli",method = RequestMethod.POST)
    public ComResult  delJianli(Integer id){

         jianliMapper.deleteByPrimaryKey(id);
        ComResult<Jianli> result = new ComResult<>();

        result.setMsg("删除成功");

        result.setCode(0);

        return result;
    }

}
