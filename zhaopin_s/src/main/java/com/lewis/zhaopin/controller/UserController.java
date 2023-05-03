package com.lewis.zhaopin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lewis.zhaopin.entity.ComResult;
import com.lewis.zhaopin.entity.User;
import com.lewis.zhaopin.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    //所有的用户
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public ComResult<List<User>>  getAllUser(@RequestParam(value = "page",defaultValue="1") int page, @RequestParam(value = "limit",defaultValue="10") int limit){
        List<User> users1 = userMapper.selectAll();
        PageHelper.startPage(page,limit);
        List<User> users = userMapper.selectAll();
        //将查询到的数据封装到PageInfo对象
        PageInfo<User> pageInfo=new PageInfo(users,limit);
        List<User> list = pageInfo.getList();
        ComResult<List<User>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(users1.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }


    //登录接口
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ComResult<User>  login(String account, String pwd){
        User login=null;
        List<User> users = userMapper.selectAll();
        //将查询到的数据封装到PageInfo对象
        for (int i = 0; i <users.size() ; i++) {
            User user = users.get(i);
            if (user.getAccount().equals(account)&&user.getPwd().equals(pwd)){
                login=user;
            }
        }


        ComResult<User> result = new ComResult<>();
        if (login==null){
            result.setMsg("账号密码不正确");
        }else {
            result.setMsg("登录成功");
        }
        result.setCode(0);
        result.setData(login);
        return result;
    }
//用户信息
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public ComResult<User>  getUserInfo(Integer id){


        User login = userMapper.selectByPrimaryKey(id);
        ComResult<User> result = new ComResult<>();
        if (login==null){
            result.setMsg("sucess");
        }else {
            result.setMsg("faile");
        }
        result.setCode(0);
        result.setData(login);
        return result;
    }


    //注册
  @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ComResult  register(String account,String pwd) throws Exception {
      User User = new User();
      User.setAccount(account);
      User.setPwd(pwd);


      User User1 = userMapper.checkUser(account);
      ComResult result = new ComResult<>();

      if (User1!=null){

          result.setMsg("账号已存在");

          result.setCode(0);

          return result;
      }else {

          int i = userMapper.insert(User);


          if (i==1){
              result.setMsg("注册成功");
          }else {
              result.setMsg("注册失败");
          }
          result.setCode(0);

          return result;
      }


    }
    //更新
    @RequestMapping(value = "/upUser",method = RequestMethod.POST)
    public ComResult  upUser(Integer id,String img,String name){
        User user = new User();
        user.setName(name);
        user.setImg(img);

        user.setId(id);


        int i = userMapper.updateByPrimaryKey(user);
        ComResult result = new ComResult<>();
        if (i==1){
            result.setMsg("更新成功");
        }else {
            result.setMsg("更新失败");
        }
        result.setCode(0);

        return result;
    }
    //更新
    @RequestMapping(value = "/upPwd",method = RequestMethod.POST)
    public ComResult  upPwd(Integer id, String pwd){

        User user = new User();

        user.setPwd(pwd);

        user.setId(id);


        int i = userMapper.upPwd(user);
        ComResult result = new ComResult<>();
        if (i==1){
            result.setMsg("更新成功");
        }else {
            result.setMsg("更新失败");
        }
        result.setCode(0);

        return result;
    }
    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    public ComResult  delUser(Integer id){

         userMapper.deleteByPrimaryKey(id);
        ComResult<User> result = new ComResult<>();

        result.setMsg("删除成功");

        result.setCode(0);

        return result;
    }

}
