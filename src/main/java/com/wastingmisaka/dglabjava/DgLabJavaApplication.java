package com.wastingmisaka.dglabjava;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCSerializeException;
import com.illposed.osc.transport.OSCPortOut;
import com.wastingmisaka.dglabjava.Utils.MessageThread;
import com.wastingmisaka.dglabjava.constVar.ConstVar;
import com.wastingmisaka.dglabjava.osc.OSC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import static com.wastingmisaka.dglabjava.Utils.MessageUtils.Msgs;


@SpringBootApplication
public class DgLabJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DgLabJavaApplication.class, args);
        init_();
        new MessageThread().start();
    }

    public static void init_(){
        System.out.println(ConstVar.QRCodeURL);
        System.out.println("请用DG-LAB APP扫描二维码");
    }
}
