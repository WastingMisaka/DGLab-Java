package com.wastingmisaka.dglabjava.Utils;

import com.alibaba.fastjson.JSON;
import com.wastingmisaka.dglabjava.ws.WebSocketServer;
import jakarta.websocket.Session;
import lombok.Data;

import java.io.IOException;

@Data
public class MessageUtils {
    // 消息类
    private Message message;

    /**
     * 发送消息给APP
     * @param message
     */
    public void send(Message message){
        // Message对象 转换为json格式字符串
        String msg = JSON.toJSONString(message);
        try {
            WebSocketServer.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Message sealMsg(Message message,String type){
        Message backMsg = new Message();
        switch (type){
            case "bind":{
                backMsg = new Message("bind",message.getClientId(),message.getTargetId(),"200");
            }
            case "heartbeat":{

            }
            case "break":{

            }
            case "error":{

            }
            case "msg":{

            }
        }
        return backMsg;
    }

    public void receive(Message message){
        switch (message.getType()){
            case "bind":{
                // 封装并发送绑定成功消息
                send(sealMsg(message,"bind"));
            }
            case "heartbeat":{

            }
            case "break":{

            }
            case "error":{

            }
            case "msg":{

            }
        }
    }
}
