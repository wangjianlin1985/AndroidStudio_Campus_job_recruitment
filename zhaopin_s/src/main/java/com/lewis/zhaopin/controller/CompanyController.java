package com.lewis.zhaopin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lewis.zhaopin.entity.ComResult;
import com.lewis.zhaopin.entity.Company;
import com.lewis.zhaopin.mapper.CompanyMapper;
import com.lewis.zhaopin.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired(required=true)
    CompanyMapper companyMapper;

    //所有的用户
    @RequestMapping(value = "/getAllCompany",method = RequestMethod.POST)
    public ComResult<List<Company>>  getAllCompany(@RequestParam(value = "page",defaultValue="1") int page, @RequestParam(value = "limit",defaultValue="10") int limit){
        List<Company> Companys1 = companyMapper.selectAll();
        PageHelper.startPage(page,limit);
        List<Company> Companys = companyMapper.selectAll();
        //将查询到的数据封装到PageInfo对象
        PageInfo<Company> pageInfo=new PageInfo(Companys,limit);
        List<Company> list = pageInfo.getList();
        ComResult<List<Company>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(Companys1.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }


    //登录接口
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ComResult<Company>  login(String account, String pwd){
        Company login=null;
        List<Company> Companys = companyMapper.selectAll();
        //将查询到的数据封装到PageInfo对象
        for (int i = 0; i <Companys.size() ; i++) {
            Company Company = Companys.get(i);
            if (Company.getAccount().equals(account)&&Company.getPwd().equals(pwd)){
                login=Company;
            }
        }


        ComResult<Company> result = new ComResult<>();
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
    @RequestMapping(value = "/getCompanyInfo",method = RequestMethod.POST)
    public ComResult<Company>  getCompanyInfo(Integer id){


        Company login = companyMapper.selectByPrimaryKey(id);
        ComResult<Company> result = new ComResult<>();
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
      Company Company = new Company();
      Company.setAccount(account);
      Company.setPwd(pwd);


      Company Company1 = companyMapper.checkCompany(account);
      ComResult result = new ComResult<>();

      if (Company1!=null){

          result.setMsg("账号已存在");

          result.setCode(0);

          return result;
      }else {

          int i = companyMapper.insert(Company);


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
    @RequestMapping(value = "/upCompany",method = RequestMethod.POST)
    public ComResult  upCompany(Integer id,String img,String name,String guimo,String boss,
                                String address,String phone,String neturl,String jianjie){
        Company Company = new Company();
        Company.setName(name);
        Company.setImg(img);
        Company.setAddress(address);
        Company.setGuimo(guimo);
        Company.setBoss(boss);
        Company.setPhone(phone);
        Company.setNeturl(neturl);
        Company.setJianjie(jianjie);

        Company.setId(id);


        int i = companyMapper.updateByPrimaryKey(Company);
        ComResult result = new ComResult<>();
        if (i==1){
            result.setMsg("更新成功");
        }else {
            result.setMsg("更新失败");
        }
        result.setCode(0);

        return result;
    }

    @RequestMapping(value = "/delCompany",method = RequestMethod.POST)
    public ComResult  delCompany(Integer id){

         companyMapper.deleteByPrimaryKey(id);
        ComResult<Company> result = new ComResult<>();

        result.setMsg("删除成功");

        result.setCode(0);

        return result;
    }

}
