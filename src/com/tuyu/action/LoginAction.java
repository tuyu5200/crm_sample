package com.tuyu.action;

import com.tuyu.action.support.BaseAction;
import com.tuyu.po.User;
import com.tuyu.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
@Controller
@Scope("prototype")
@Setter
@Getter
public class LoginAction extends BaseAction {
    @Autowired
    private UserService userService;

    private String username;

    private String password;

    private String message;

    public String login() {
        User user = this.userService.queryByUsername(this.username);
        if (Objects.nonNull(user)) {
            if (Objects.equals(user.getPassword(), this.password)) {
                this.setSessionAttribute("_SUBJECT", user, true);
                return "success";
            }
        }
        this.message = "用户名或密码错误，请重新登陆";
        return "login";

    }

    public String logout() {
        HttpSession session = (HttpSession) this.getSession(true);
        session.invalidate();
        return "logout";
    }
}
