package com.lewis.zhaopin.controller;

import com.lewis.zhaopin.entity.*;
import com.lewis.zhaopin.mapper.JianliMapper;
import com.lewis.zhaopin.mapper.PositionMapper;
import com.lewis.zhaopin.mapper.ToudiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/toudi")
public class ToudiController {
    @Autowired(required=true)
    ToudiMapper toudiMapper;

    @Autowired(required=true)
    PositionMapper positionMapper;
     @Autowired(required=true)
     JianliMapper jianliMapper;

    //
    @RequestMapping(value = "/getMyToudi",method = RequestMethod.POST)
    public ComResult<List<TouDiPostion>> getMyToudi(Integer uid){
        List<TouDiPostion> list=new ArrayList<>();
        List<Toudi> tJds = toudiMapper.selectAll();
        for (int i = 0; i <tJds.size() ; i++) {
            Toudi Toudi = tJds.get(i);
            if (Toudi.getUid()==uid){
                Position position = positionMapper.selectByPrimaryKey(Toudi.getPid());
                TouDiPostion touDiPostion = new TouDiPostion();
                touDiPostion.setDec(position.getDec());
                touDiPostion.setJid(Toudi.getJid());
                touDiPostion.setMoney(position.getMoney());
                touDiPostion.setPid(position.getId());
                touDiPostion.setName(position.getName());
                touDiPostion.setStatus(Toudi.getStatus());
                touDiPostion.setTime(position.getTime());
                touDiPostion.setUid(Toudi.getUid());
                touDiPostion.setTid(Toudi.getId());
                list.add(touDiPostion);
            }
        }
        ComResult<List<TouDiPostion>> result = new ComResult<>();

        result.setMsg("sucess");

        result.setCode(0);
        result.setData(list);
        return result;
    }

    @RequestMapping(value = "/getToudibyP",method = RequestMethod.POST)
    public ComResult<List<TouDiJianLi>> getToudibyP(Integer pid){
        List<TouDiJianLi> list=new ArrayList<>();
        List<Toudi> tJds = toudiMapper.selectAll();
        for (int i = 0; i <tJds.size() ; i++) {
            Toudi Toudi = tJds.get(i);
            if (Toudi.getPid()==pid){
                Jianli jianli = jianliMapper.selectByPrimaryKey(Toudi.getJid());
                TouDiJianLi touDiJianLi = new TouDiJianLi();
                touDiJianLi.setJianli(jianli);
                touDiJianLi.setToudi(Toudi);
                list.add(touDiJianLi);
            }
        }
        ComResult<List<TouDiJianLi>> result = new ComResult<>();

        result.setMsg("sucess");

        result.setCode(0);
        result.setData(list);
        return result;
    }
  //发布
    @RequestMapping(value = "/addToudi",method = RequestMethod.POST)
    public ComResult addPjia(Integer uid,Integer jid,Integer pid ){
        Toudi toudi = new Toudi();
        toudi.setJid(jid);
        toudi.setStatus("待处理");
        toudi.setPid(pid);
        toudi.setUid(uid);

        toudiMapper.insert(toudi);

        ComResult result = new ComResult<>();

        result.setMsg("投递成功");
        result.setCode(0);
        return result;
    }

    //发
    @RequestMapping(value = "/upStatus",method = RequestMethod.POST)
    public ComResult upStatus(Integer id,String status ){
        Toudi toudi = new Toudi();
        toudi.setId(id);
        toudi.setStatus(status);
        toudiMapper.updateByPrimaryKey(toudi);
        ComResult result = new ComResult<>();

        result.setMsg("操作成功");
        result.setCode(0);
        return result;
    }



    //删除
    @RequestMapping(value = "/delToudi",method = RequestMethod.POST)
    public ComResult delToudi(Integer id){

        int i = toudiMapper.deleteByPrimaryKey(id);
        ComResult result = new ComResult<>();


        if (i==1){
            result.setMsg("删除成功");
        }else {
            result.setMsg("删除失败");
        }
        result.setCode(0);
        return result;
    }



}
