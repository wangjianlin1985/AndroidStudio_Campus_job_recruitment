package com.lewis.zhaopin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lewis.zhaopin.entity.ComResult;
import com.lewis.zhaopin.entity.Luntan;
import com.lewis.zhaopin.mapper.LuntanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/luntan")
public class LunTanController {
    @Autowired
    LuntanMapper luntanMapper;

    //所有的用户
    @RequestMapping(value = "/getAllLuntan",method = RequestMethod.POST)
    public ComResult<List<Luntan>>  getAllLuntan(@RequestParam(value = "page",defaultValue="1") int page, @RequestParam(value = "limit",defaultValue="10") int limit){
        List<Luntan> Luntans1 = luntanMapper.selectAll();
        PageHelper.startPage(page,limit);
        List<Luntan> Luntans = luntanMapper.selectAll();
        //将查询到的数据封装到PageInfo对象
        PageInfo<Luntan> pageInfo=new PageInfo(Luntans,limit);
        List<Luntan> list = pageInfo.getList();
        ComResult<List<Luntan>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(Luntans1.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }

    @RequestMapping(value = "/getAllLuntanApp",method = RequestMethod.POST)
    public ComResult<List<Luntan>>  getAllLuntanApp(){
        List<Luntan> Luntans1 = luntanMapper.selectAll();

        ComResult<List<Luntan>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(Luntans1.size());
        result.setData(Luntans1);
        result.setMsg("success");
        return result;
    }



    //注册
  @RequestMapping(value = "/addLuntan",method = RequestMethod.POST)
    public ComResult  register(String uname,String uimg,String title,Integer uid,String content) throws Exception {
      Luntan Luntan = new Luntan();
      Luntan.setContent(content);
      Luntan.setTitle(title);
      Luntan.setUid(uid);
      Luntan.setUimg(uimg);
      Luntan.setUname(uname);
      Luntan.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));

          int i = luntanMapper.insert(Luntan);
      ComResult result = new ComResult<>();

          if (i==1){
              result.setMsg("发布成功");
          }else {
              result.setMsg("注册失败");
          }
          result.setCode(0);

          return result;



    }
//    //更新
//    @RequestMapping(value = "/upLuntan",method = RequestMethod.POST)
//    public ComResult  upLuntan(Integer id,String name,String dec,String money,Integer cid){
//        Luntan Luntan = new Luntan();
//        Luntan.setCid(cid);
//        Luntan.setName(name);
//        Luntan.setDec(dec);
//        Luntan.setMoney(money);
//        Luntan.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
//
//
//
//
//
//        Luntan.setId(id);
//
//
//        int i = LuntanMapper.updateByPrimaryKey(Luntan);
//        ComResult result = new ComResult<>();
//        if (i==1){
//            result.setMsg("更新成功");
//        }else {
//            result.setMsg("更新失败");
//        }
//        result.setCode(0);
//
//        return result;
//    }

    //
    @RequestMapping(value = "/delLuntan",method = RequestMethod.POST)
    public ComResult  delLuntan(Integer id){

        luntanMapper.deleteByPrimaryKey(id);
        ComResult<Luntan> result = new ComResult<>();

        result.setMsg("删除成功");

        result.setCode(0);

        return result;
    }

}
