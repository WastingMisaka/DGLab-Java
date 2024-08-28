package com.wastingmisaka.dglabjava.Utils;

import lombok.extern.slf4j.Slf4j;

import static com.wastingmisaka.dglabjava.Utils.MessageUtils.Msgs;

@Slf4j
public class MessageThread extends Thread{
    MessageUtils messageUtils = new MessageUtils();
    @Override
    public void run(){
        System.out.println("--========消息处理线程已启动=========--");
        while(true){
            // 当消息List里有消息时，发送消息。
            if(!Msgs.isEmpty()){
                try{
                    messageUtils.send(Msgs.getFirst());
                    log.info("发送消息： " + Msgs.getFirst());
                    Msgs.removeFirst();
                    Thread.sleep(100);
                }catch (Exception e){
                    System.out.println("消息发送失败： "+e);
                }
            }
        }

    }
}
