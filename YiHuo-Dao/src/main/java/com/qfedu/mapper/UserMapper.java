package com.qfedu.mapper;

import com.qfedu.entry.User;

import java.util.List;

public interface UserMapper {

    int register(User user);

    int insertValidateNum(User user);

    int selectUserByUserNameAndPassword(User user);

    int selectVerify(String email);

    void updatePasswordByEmail(User user);

    int selectUserByValidateNumAndEmail(User user);

    User selectShowUserByEmail(String email);
}
