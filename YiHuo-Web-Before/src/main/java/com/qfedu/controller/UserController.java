package com.qfedu.controller;

import com.qfedu.entry.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/validate")
    @ResponseBody
    public String validate(String phone) {
        int count = userService.validate(phone);
        if (count > 0) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/register")
    public String register(User user) {
        int count = userService.register(user);

        if (count > 0) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/login")
    public String login(User user) {
        return "success";
    }
}
