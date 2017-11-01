package com.tuyu.dao;

import com.tuyu.dao.support.BaseDao;
import com.tuyu.po.User;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
public interface UserDao extends BaseDao<User> {
    /**
     * 根据用户名查询用户，用于登陆
     *
     * @param username 用户名
     * @return User
     */
    User queryByUsername(String username);
}
