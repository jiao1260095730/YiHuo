package com.qfedu.controller;

import com.qfedu.entry.User;
import com.qfedu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@Api(tags = "该类用于后台操作")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "该方法是用户注册时发送验证码并保存至数据库")
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public String validate(String email) {
        int count = userService.validate(email);
        if (count > 0) {
            return "success";
        }
        return "fail";
    }

    @ApiOperation(value =  "该方法用于用户使用邮箱注册，输入邮箱，密码，验证码")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String"),
             @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")}
    )
    public String register(User user) {
        int count = userService.register(user);

        if (count > 0) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping(value = "isLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证用户名email和密码password登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email",value = "邮箱",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String")
    })
    public String isLogin(String email,String password) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        boolean result = userService.isLogin(user);

        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

}
