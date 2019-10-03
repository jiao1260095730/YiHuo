package com.qfedu.service.impl;

import com.qfedu.entry.User;
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserMapper userMapper;

    public boolean isLogin(User user) {
        int result = userMapper.selectUserByUserNameAndPassword(user);
        return result == 1 ? true : false;
    }
}
