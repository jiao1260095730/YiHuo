package com.qfedu.utils;

import java.util.Properties;

public class InfoUtils {



   static Properties properties = null;
    static{
        try{
            properties=new Properties();
            properties.load(InfoUtils.class.getClassLoader().getResourceAsStream("info.properties"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperties(String name){
        return properties.getProperty(name);
    }


}
