package com.qfedu.mapper;

import com.qfedu.entry.User;

public interface UserMapper {

    int register(User user);

    int insertValidateNum(User user);

    int selectUserByUserNameAndPassword(User user);

    int selectVerify(String email);
}
