package com.qfedu.mapper;

import com.qfedu.entry.User;

public interface UserMapper {

    int register(User user);

    int insertValidateNum(User user);

    /**
     * 验证用户名和密码用于登录
     * @param user 包含用户名和密码的user容器
     * @return 查询到的user数量
     */
    int selectUserByUserNameAndPassword(User user);
}
