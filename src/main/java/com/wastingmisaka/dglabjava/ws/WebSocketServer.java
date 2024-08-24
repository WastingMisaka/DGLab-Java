package com.wastingmisaka.dglabjava.ws;

import com.alibaba.fastjson.JSON;
import com.wastingmisaka.dglabjava.Utils.Message;
import com.wastingmisaka.dglabjava.Utils.MessageUtils;
import com.wastingmisaka.dglabjava.constVar.ConstVar;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@ServerEndpoint("/Server")
@Component
public class WebSocketServer {
    // (全局)客户端会话
    public static Session session;

    // 消息处理&&发送对象
    MessageUtils messageUtils = new MessageUtils();

    // 消息队列
    public static List<String> Msg = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        Message message = new Message(
            "bind",
                ConstVar.targetId,
                "",
                "targetId"
        );
        try {
            String bindOrder = JSON.toJSONString(message);
            log.info("向session："+session.getId()+" 发送绑定消息： {}", bindOrder);
            session.getBasicRemote().sendText(bindOrder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @OnMessage
    public void onMessage(String message){
        log.info("接受到消息： {}", message);
        // 转换为Message类 结果执行receive方法
        Message msg = JSON.parseObject(message,Message.class);
        messageUtils.receive(msg);
    }
    @OnClose
    public void onClose(Session session){

    }
    @OnError
    public void onError(Throwable throwable){
        throwable.printStackTrace();
    }

    public void sendMsg(String msg,Session session){
        this.session = session;

    }

}
