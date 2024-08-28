package com.wastingmisaka.dglabjava.osc;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.OSCPortOut;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
@Slf4j
public class OSC {

    InetAddress localhost;
    int port = 9000; // VRChat osc的传入接口 默认是9000
    OSCPortOut sender;

    // 构造器
    public OSC(){
        try {
            localhost = InetAddress.getLocalHost();
            sender = new OSCPortOut(localhost, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void send_chatbox(String osc_message) {
        try {
            OSCMessage osc_msg = new OSCMessage("/chatbox/input", Arrays.asList(osc_message, true, false));

            sender.send(osc_msg);

            System.out.println("-----osc-message sent : "+osc_msg.getArguments());

        } catch (Exception e) {
            log.info("发送消息失败");
        }
    }
}
