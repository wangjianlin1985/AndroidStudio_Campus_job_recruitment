package com.lewis.zhaopin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lewis.zhaopin.entity.ComResult;
import com.lewis.zhaopin.entity.Position;
import com.lewis.zhaopin.entity.Store;
import com.lewis.zhaopin.mapper.PositionMapper;
import com.lewis.zhaopin.mapper.StoreMapper;
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
@RequestMapping(value = "/position")
public class PositionController {
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    StoreMapper storeMapper;

    //所有的用户
    @RequestMapping(value = "/getAllPosition",method = RequestMethod.POST)
    public ComResult<List<Position>>  getAllPosition(@RequestParam(value = "page",defaultValue="1") int page, @RequestParam(value = "limit",defaultValue="10") int limit){
        List<Position> Positions1 = positionMapper.selectAll();
        PageHelper.startPage(page,limit);
        List<Position> Positions = positionMapper.selectAll();
        //将查询到的数据封装到PageInfo对象
        PageInfo<Position> pageInfo=new PageInfo(Positions,limit);
        List<Position> list = pageInfo.getList();
        ComResult<List<Position>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(Positions1.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }
    //所有的用户
    @RequestMapping(value = "/getAllPositionByCid",method = RequestMethod.POST)
    public ComResult<List<Position>>  getAllPositionByCid(@RequestParam(value = "page",defaultValue="1") int page, @RequestParam(value = "limit",defaultValue="10") int limit,Integer cid){
        List<Position> Positions1 = positionMapper.selectAllByCid(cid);
        PageHelper.startPage(page,limit);
        List<Position> Positions = positionMapper.selectAllByCid(cid);
        //将查询到的数据封装到PageInfo对象
        PageInfo<Position> pageInfo=new PageInfo(Positions,limit);
        List<Position> list = pageInfo.getList();
        ComResult<List<Position>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(Positions1.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }
    //所有的用户
    @RequestMapping(value = "/getAllPositionByAppCid",method = RequestMethod.POST)
    public ComResult<List<Position>>  getAllPositionByAppCid(Integer cid){
        List<Position> Positions1 = positionMapper.selectAllByCid(cid);

        ComResult<List<Position>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(Positions1.size());
        result.setData(Positions1);
        result.setMsg("success");
        return result;
    }
    @RequestMapping(value = "/getAllPositionApp",method = RequestMethod.POST)
    public ComResult<List<Position>>  getAllPositionApp(){
        List<Position> Positions1 = positionMapper.selectAll();

        ComResult<List<Position>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(Positions1.size());
        result.setData(Positions1);
        result.setMsg("success");
        return result;
    }
    @RequestMapping(value = "/getAllPositionByKey",method = RequestMethod.POST)
    public ComResult<List<Position>>  getAllPositionByKey(String key){
        List<Position> Positions1 = positionMapper.selectAll();
        List<Position> list=new ArrayList<>();
        for (int i = 0; i < Positions1.size(); i++) {
            Position position = Positions1.get(i);
            if (position.getName().contains(key)||position.getDec().contains(key)){
                list.add(position);
            }
        }
        ComResult<List<Position>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(list.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }


    //注册
  @RequestMapping(value = "/addPosition",method = RequestMethod.POST)
    public ComResult  register(String name,String dec,String money,Integer cid,String jianjie) throws Exception {
      Position Position = new Position();
      Position.setCid(cid);
      Position.setName(name);
      Position.setDec(dec);
      Position.setMoney(money);
      Position.setJianjie(jianjie);
      Position.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));

          int i = positionMapper.insert(Position);
      ComResult result = new ComResult<>();

          if (i==1){
              result.setMsg("发布成功");
          }else {
              result.setMsg("注册失败");
          }
          result.setCode(0);

          return result;



    }
    //更新
    @RequestMapping(value = "/upPosition",method = RequestMethod.POST)
    public ComResult  upPosition(Integer id,String name,String dec,String money,Integer cid,String jianjie){
        Position Position = new Position();
        Position.setCid(cid);
        Position.setName(name);
        Position.setDec(dec);
        Position.setMoney(money);
        Position.setJianjie(jianjie);
        Position.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));





        Position.setId(id);


        int i = positionMapper.updateByPrimaryKey(Position);
        ComResult result = new ComResult<>();
        if (i==1){
            result.setMsg("更新成功");
        }else {
            result.setMsg("更新失败");
        }
        result.setCode(0);

        return result;
    }

    //
    @RequestMapping(value = "/delPosition",method = RequestMethod.POST)
    public ComResult  delPosition(Integer id){

         positionMapper.deleteByPrimaryKey(id);
        ComResult<Position> result = new ComResult<>();

        result.setMsg("删除成功");

        result.setCode(0);

        return result;
    }

    //
    @RequestMapping(value = "/storeP",method = RequestMethod.POST)
    public ComResult  storeP(Integer pid,Integer uid){
        boolean isstore=false;
        List<Store> stores = storeMapper.selectAll();
        for (int i = 0; i <stores.size() ; i++) {
            Store store = stores.get(i);
            if (store.getPid()==pid&&store.getUid()==uid){
                isstore=true;
            }
        }
        ComResult<Position> result = new ComResult<>();
        Store store = new Store();
        store.setPid(pid);
        store.setUid(uid);
        if (isstore){
            result.setMsg("已经收藏");

        }else {
            result.setMsg("收藏成功");
            storeMapper.insert(store);
        }





        result.setCode(0);

        return result;
    }

    @RequestMapping(value = "/getMyStore",method = RequestMethod.POST)
    public ComResult<List<Position>>  getMyStore(Integer uid){
        List<Store> stores = storeMapper.getMyStore(uid);

        List<Position> Positions1 = positionMapper.selectAll();
        List<Position> list=new ArrayList<>();
        for (int i = 0; i < stores.size(); i++) {
            for (int j = 0; j < Positions1.size(); j++) {
                Position position = Positions1.get(j);
                if (position.getId()==stores.get(i).getPid()){
                    list.add(position);
                }
            }
        }
        ComResult<List<Position>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(list.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }




}
