package com.wastingmisaka.dglabjava;

import com.wastingmisaka.dglabjava.constVar.ConstVar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DgLabJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DgLabJavaApplication.class, args);
        init_();
    }

    public static void init_(){
        System.out.println(ConstVar.QRCodeURL);
        System.out.println("请用DG-LAB APP扫描二维码");
    }
}
