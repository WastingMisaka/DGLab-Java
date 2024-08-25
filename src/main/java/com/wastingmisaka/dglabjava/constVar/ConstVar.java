package com.wastingmisaka.dglabjava.constVar;

public class ConstVar {

    public static final String QRCodeURL = "https://www.dungeon-lab.com/app-download.php#DGLAB-SOCKET#ws://192.168.8.155:8080/"+"Server";
    // 最大消息数 && 最大消息长度
    public static final int maxMsg = 500;
    public static final int maxMsgLen = 1950;

    // 固定的ClientID 和 AppID (绑定时，clientId的value为APP)
    public static final String clientId = "Server";
    public static final String targetId = "APP";

    // APP允许的电流强度最小值和最大值。
    public static final int min_current = 0;
    public static final int max_current = 200;


}
