package com.wastingmisaka.dglabjava;

import com.wastingmisaka.dglabjava.Utils.MessageThread;
import com.wastingmisaka.dglabjava.constVar.ConstVar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.wastingmisaka.dglabjava.Utils.MessageUtils.Msgs;


@SpringBootApplication
public class DgLabJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DgLabJavaApplication.class, args);
        init_();
        new MessageThread().start();;
    }

    public static void init_(){
        System.out.println(ConstVar.QRCodeURL);
        System.out.println("请用DG-LAB APP扫描二维码");
    }
}
