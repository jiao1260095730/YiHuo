package com.qfedu.utils;

import java.util.UUID;

public class UUIDUtils {
    //uuid 是一个字符串，不可重复
    public static String  getUUID(){
        //uuid 全球唯一
        // ip + 电脑设备 + 时间戳
       String uuidStr =  UUID.randomUUID().toString().replace("-","");
       return uuidStr;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(getUUID());
        }
    }
}
