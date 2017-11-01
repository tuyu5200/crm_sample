package com.tuyu.service.impl;

import com.tuyu.dao.RoleDao;
import com.tuyu.po.Role;
import com.tuyu.service.RoleService;
import com.tuyu.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        super.setBaseDao(roleDao);
        this.roleDao = roleDao;
    }

    @Override
    public Role queryOne(Role role) {
        return null;
    }
}
