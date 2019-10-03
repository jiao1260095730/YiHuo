package com.qfedu.utils;

public class CreateValidate {

    public static String getValidateCode(int num) {

        String result = "";
        for (int i = 0; i < num; i++) {
            String s = String.valueOf((int)(Math.random() * 10));
            result+=s;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getValidateCode(6));
    }
}
