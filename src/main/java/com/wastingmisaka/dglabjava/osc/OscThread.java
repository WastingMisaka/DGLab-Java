package com.wastingmisaka.dglabjava.osc;

import com.wastingmisaka.dglabjava.Utils.MessageUtils;

public class OscThread extends Thread{
    MessageUtils messageUtils = new MessageUtils();
    OSC osc = new OSC();
    @Override
    public void run(){
        System.out.println("--========osc收发线程启动=========--");
        while(true){
            try {
                String msg = messageUtils.currentcurrent();
                osc.send_chatbox(msg);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
