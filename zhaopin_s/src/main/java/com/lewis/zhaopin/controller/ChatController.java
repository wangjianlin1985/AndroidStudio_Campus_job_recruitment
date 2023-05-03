package com.lewis.zhaopin.controller;

import com.lewis.zhaopin.entity.*;
import com.lewis.zhaopin.mapper.ChatMapper;
import com.lewis.zhaopin.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {
    @Autowired
    ChatMapper chatMapper;
   @Autowired
   SessionMapper sessionMapper;


    //我的订单
    @RequestMapping(value = "/getMyChat", method = RequestMethod.POST)
    public ComResult<List<Chat>> getMyChat(Integer sessionid) {

        List<Chat> chats = chatMapper.selectAll();
        List<Chat> chatList = new ArrayList<>();
        for (int i = 0; i < chats.size(); i++) {
            Chat chat = chats.get(i);
            if (chat.getSessionid() == sessionid) {
                chatList.add(chat);
            }
        }

        ComResult<List<Chat>> result = new ComResult<>();
        result.setCode(0);

        result.setData(chatList);
        result.setMsg("success");
        return result;
    }
    //我的会话
    @RequestMapping(value = "/getMySession", method = RequestMethod.POST)
    public ComResult<List<Session>> getMySession(Integer did) {

        List<Session> chats = sessionMapper.selectAll();
        List<Session> chatList = new ArrayList<>();
        for (int i = 0; i < chats.size(); i++) {
            Session chat = chats.get(i);
            if (chat.getDid()==did){
                chatList.add(chat);
            }
        }

        ComResult<List<Session>> result = new ComResult<>();
        result.setCode(0);

        result.setData(chatList);
        result.setMsg("success");
        return result;
    }
    //添加
    @RequestMapping(value = "/addChat", method = RequestMethod.POST)
    public ComResult addChat(Integer sid, Integer gid, String sname,
                             String gname, String simg, String gimg,
                             String content,Integer sessionid) throws Exception {


        ComResult result = new ComResult<>();
        Chat Chat = new Chat();
        Chat.setContent(content);
        Chat.setGid(gid);
        Chat.setGimg(gimg);
        Chat.setGname(gname);
        Chat.setSid(sid);
        Chat.setSimg(simg);
        Chat.setSname(sname);
        Chat.setSessionid(sessionid);
        Chat.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        int i = chatMapper.insert(Chat);


        if (i == 1) {
            result.setMsg("发送成功");

        } else {
            result.setMsg("faile");
        }

        result.setCode(0);
        return result;
    }


    //添加
    @RequestMapping(value = "/addSession", method = RequestMethod.POST)
    public ComResult addSession(Integer uid, Integer did) throws Exception {


        ComResult result = new ComResult<>();
        Session Chat = new Session();
        Chat.setDid(did);
        Chat.setUid(uid);
        Session check = sessionMapper.check(Chat);
        if (check!=null){
            result.setData(check);
        }else {
            int i = sessionMapper.insert(Chat);
            if (i == 1) {
                result.setMsg("success");
                result.setData(sessionMapper.check(Chat));
            } else {
                result.setMsg("faile");
            }
        }




        result.setCode(0);
        return result;
    }
}
