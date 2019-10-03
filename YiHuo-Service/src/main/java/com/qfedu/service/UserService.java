package com.qfedu.service;

import com.qfedu.entry.User;

public interface UserService {

    int register(User user);

    int validate(String email);

    boolean isLogin(User user);
}
