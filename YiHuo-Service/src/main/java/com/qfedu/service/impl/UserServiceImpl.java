package com.qfedu.service.impl;

import com.qfedu.entry.User;
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.UserService;
import com.qfedu.utils.CreateValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public int register(User user) {
        return userMapper.register(user);
    }

    public int validate(String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setValidateNum(CreateValidate.getValidateCode(6));
        int count = userMapper.insertValidateNum(user);
        return count;
    }
}
