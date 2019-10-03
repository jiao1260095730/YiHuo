package com.qfedu.controller;

import com.qfedu.entry.User;
import com.qfedu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@Api(tags = "该类用于后台操作")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "该方法是用户注册时发送验证码并保存至数据库")
    @RequestMapping("/validate")
    @ResponseBody
    public String validate(String email) {
        int count = userService.validate(email);
        if (count > 0) {
            return "success";
        }
        return "fail";
    }

    @ApiOperation(value =  "该方法用于用户使用邮箱注册，输入邮箱，密码，验证码")
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user) {
        int count = userService.register(user);

        if (count > 0) {
            return "success";
        }
        return "fail";
    }

}
