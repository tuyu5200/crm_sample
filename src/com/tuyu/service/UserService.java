package com.tuyu.service;

import com.tuyu.po.User;
import com.tuyu.service.support.BaseService;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
public interface UserService extends BaseService<User> {
    /**
     * 根据用户名进行查询，用于用户登陆
     *
     * @param username 用户名
     * @return User
     */
    User queryByUsername(String username);
}
