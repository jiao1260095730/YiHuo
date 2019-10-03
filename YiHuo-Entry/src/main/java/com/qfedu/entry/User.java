package com.qfedu.entry;

import lombok.Getter;
import lombok.Setter;

import javax.xml.soap.SAAJResult;

@Getter
@Setter
public class User {

    private int id;
    private String email;
    /**
     * 昵称
     */
    private String userName;
    private String password;
    private Boolean gender;
    private String phone;
    private String headImgUrl;
    /**
     * 信息
     */
    private String info;
    /**
     * 背景图片
     */
    private String bgImgUrl;
    private String validateNum;
    /**
     * 获赞数量
     */
    private int huoZan;
    /**
     * 粉丝
     */
    private int fans;
    private int guanZhuNum;
    private String vip;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 地区
     */
    private String adress;
    /**
     * 职业
     */
    private String profession;
    /**
     * 行业
     */
    private String trade;
    /**
     * 学历
     */
    private String eduction;
    /**
     * 购买课程ID
     */
    private int buyCourseId;
}
