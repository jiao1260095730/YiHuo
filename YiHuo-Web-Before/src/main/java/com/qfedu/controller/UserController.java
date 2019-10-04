package com.qfedu.controller;

import com.qfedu.entry.User;
import com.qfedu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
@Api(tags = "该类实现所有关于user的功能")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "该方法用来验证邮箱是否存在")
    public String verify(String email) {
        int count = userService.selectVerify(email);

        if (count > 0) {
            return "success";
        }
        return "fail";
    }

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
    public String isLogin(String email,String password,HttpSession session) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        boolean result = userService.isLogin(user);

        if (result) {
            //将email存入session
            session.setAttribute("email",email);
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 忘记密码并重置密码的流程：
     *      1.验证邮箱是否存在，前端blur方法触发ajax，调用verify方法，存在返回false
     *      2.前端点击发送验证码按钮（邮箱存在方可使用），调用后端validate方法发送验证码至邮箱，验证通过跳转重置密码页面
     *      3.输入两次新密码，前端完成密码相同验证；将新密码存入数据库。返回success，跳转登录页面
     */

    /**
     * 验证忘记密码时重置密码验证码是否正确的方法
     * @param email 经确认后的邮箱
     * @param code 用户输入的验证码
     * @return 验证通过返回success
     */
    @RequestMapping(value = "resetValidateCode",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "验证忘记密码时重置密码的验证码是否正确")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email",value = "邮箱",required = true,dataType = "String"),
            @ApiImplicitParam(name = "code",value = "验证码",required = true,dataType = "String")
    })
    public String resetValidateCode(String email,String code,HttpSession session) {
        User user = new User();
        user.setEmail(email);
        user.setValidateNum(code);

        boolean result = userService.selectUserByValidateNumAndEmail(user);

        if (result) {
            session.setAttribute("EMAIL",email);
            return "success";
        } else {
            return "fail";
        }
    }


    @RequestMapping(value = "resetPassword",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password",value = "新密码",required = true,dataType = "String")
    })
    public String resetPassword(String password, HttpSession session) {
        String email = (String) session.getAttribute("EMAIL");
        session.removeAttribute("EMAIL");

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        userService.updatePasswordByEmail(user);
        return "success";
    }

    /**
     * 修改密码流程：
     *      1.前端页面输入旧密码，blur事件触发ajax方法，验证旧密码
     *      2.输入两次新密码，页面完成相同验证，点击修改按钮，后台完成数据库更新
     */

    /**
     * 验证旧密码
     * @param oldPassword 前端页面输入的旧密码
     * @return 验证通过返回success
     */
    @RequestMapping(value = "validateOldPassword",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改密码时，验证旧密码是否正确")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword",value = "旧密码",required = true,dataType = "String")
    })
    public String validateOldPassword(String oldPassword,HttpSession session) {
        String email = (String) session.getAttribute("email");

        User user = new User();
        user.setEmail(email);
        user.setPassword(oldPassword);
        boolean result = userService.isLogin(user);

        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "setNewPassword",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改密码，设置新密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newPassword",value = "新密码",required = true,dataType = "String")
    })
    public String setNewPassword(String newPassword,HttpSession session) {
        String email = (String) session.getAttribute("email");

        User user = new User();
        user.setEmail(email);
        user.setPassword(newPassword);

        userService.updatePasswordByEmail(user);
        return "success";
    }

    @RequestMapping(value = "/showUser",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据用户的email展示用户的所有信息")
    public String showUser(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        User user = userService.selectShowUserByEmail(email);
        model.addAttribute("user",user);
        return "success";
    }
}
