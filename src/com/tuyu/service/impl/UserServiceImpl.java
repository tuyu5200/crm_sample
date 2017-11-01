package com.tuyu.service.impl;

import com.tuyu.dao.UserDao;
import com.tuyu.po.User;
import com.tuyu.service.UserService;
import com.tuyu.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        super.setBaseDao(userDao);
        this.userDao = userDao;
    }

    @Override
    public User queryOne(User user) {
        return null;
    }

    @Override
    public User queryByUsername(String username) {
        if (Objects.isNull(username) || Objects.equals("", username)) {
            throw new IllegalArgumentException("查询用户时用户名不能为空");
        }
        return this.userDao.queryByUsername(username);
    }
}
