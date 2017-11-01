package com.tuyu.action;

import com.tuyu.po.User;
import com.tuyu.service.UserService;
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
public class UserAction {

    private List<User> users = new ArrayList<>();
    private User user;
    private final String REFRESH = "refresh";

    @Autowired
    private UserService userService;


    public String queryAll() {
        this.users = this.userService.queryAll();
        return "queryAll";
    }

    public String save() {
        this.userService.save(this.user);
        return this.REFRESH;
    }

    public String delete() {
        this.userService.delete(this.user);
        return this.REFRESH;
    }

    public String update() {
        this.userService.update(this.user);
        return this.REFRESH;
    }


}
