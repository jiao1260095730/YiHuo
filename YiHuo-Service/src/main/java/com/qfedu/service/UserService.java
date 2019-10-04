package com.qfedu.service;

import com.qfedu.entry.User;

import java.util.List;

public interface UserService {

    int register(User user);

    int validate(String email);

    boolean isLogin(User user);

    int selectVerify(String email);

    void updatePasswordByEmail(User user);

    boolean selectUserByValidateNumAndEmail(User user);

    User selectShowUserByEmail(String email);
}
