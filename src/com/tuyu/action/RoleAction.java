package com.tuyu.action;

import com.tuyu.po.Role;
import com.tuyu.service.RoleService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
@Controller
@Scope("prototype")
@Setter
@Getter
public class RoleAction {

    private List<Role> roles = new ArrayList<>();
    private Role role;
    private final String REFRESH = "refresh";

    @Autowired
    private RoleService roleService;


    public String queryAll() {
        this.roles = this.roleService.queryAll();
        return "queryAll";
    }

    public String save() {
        this.roleService.save(this.role);
        return this.REFRESH;
    }

    public String delete() {
        this.roleService.delete(this.role);
        return this.REFRESH;
    }

    public String update() {
        this.roleService.update(this.role);
        return this.REFRESH;
    }
}
