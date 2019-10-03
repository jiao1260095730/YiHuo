package com.qfedu.entry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;
    private String userName;
    private Boolean gender;
    private String phone;
    private String headImgUrl;
    private String bgImgUrl;
    private String passWord;
    private String info;
    private String validateNum;

}
