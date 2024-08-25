package com.wastingmisaka.dglabjava.Utils;

import com.alibaba.fastjson.JSON;
import com.wastingmisaka.dglabjava.constVar.ConstVar;
import com.wastingmisaka.dglabjava.ws.WebSocketServer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Data
public class MessageUtils {
    // 消息类
    private Message message;
    public static List<Message> Msgs = new ArrayList<>();

    private int a_current,b_current;
    private int a_max,b_max;

    private int[] current = new int[5];

    /**
     * 发送消息给APP
     * @param message
     */
    public void send(Message message){
        // Message对象 转换为json格式字符串
        String msg = JSON.toJSONString(message);
        if(msg.length()> ConstVar.maxMsgLen){
            log.info("消息长度length: " + msg.length() + " 过长： " + msg);
        }
        // 发送消息
        try {
            WebSocketServer.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 封装消息 格式：
    // Type Message ClientId TargetId
    public Message sealMsg(Message message,String type){
        Message backMsg = new Message();
        switch (type){
            case "bind":{
                backMsg = new Message("bind","200",message.getClientId(),message.getTargetId());
                break;
            }
            case "msg":{
                backMsg = new Message("msg",message.getMessage(),message.getClientId(),message.getTargetId());
                break;
            }
            case "heartbeat":{
                break;
            }
            case "break":{
                break;
            }
            case "error":{
                break;
            }
            default:{
                log.info("无效的数据格式 "+message);
            }
        }
        return backMsg;
    }

    public void receive(Message message){
        log.info("MessageUtils收到消息： " + message);
        switch (message.getType()){
            case "bind":{
                // 封装并发送绑定成功消息
                Msgs.add(sealMsg(message,"bind"));
                break;
            }
            case "heartbeat":{
                // 还不知道是什么。
            }
            case "break":{
                // 还没见过这个类型
            }
            case "error":{
                // 喵喵喵
            }
            // 接受来自app的新数据
            case "msg":{
                String check_message = message.getMessage();
                // 电流强度信息 更新 current[ A , B , A_MAX , B_MAX ]
                if(check_message.contains("strength")){
                    int st = 8;
                    for(int i=0;i<4;i++){
                        int cut = check_message.indexOf("+",st+1);
                        if(cut==-1){
                            current[i+1] = Integer.parseInt(check_message.substring(st+1));
                            break;
                        }
                        String num = check_message.substring(st+1,cut);
                        st = cut;
                        current[i+1] = Integer.parseInt(num);
                    }
                    log.info("当前电流情况："+current[1]+"+"+current[2]+"+"+current[3]+"+"+current[4]);
                }
                break;
            }
        }
    }
}
