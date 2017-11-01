package com.tuyu.dao.impl;

import com.tuyu.dao.UserDao;
import com.tuyu.dao.support.impl.BaseDaoImpl;
import com.tuyu.po.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User queryByUsername(String username) {
        return (User) this.getSession().createCriteria(this.clazz).add(Restrictions.eq("username", username)).uniqueResult();
    }
}
