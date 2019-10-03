package com.qfedu.controller;

import com.qfedu.entry.User;
import com.qfedu.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 周立雄
 * @date 2019/10/3 10:20
 */
@Controller
@RequestMapping("/admin")
@Api(tags = "用户登录验证")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "isLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证用户名email和密码password登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email",value = "邮箱",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String")
    })
    public String isLogin(String email,String password) {

        User user = new User();
        user.setUserName(email);
        user.setPassword(password);

        boolean result = adminService.isLogin(user);

        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }
}
