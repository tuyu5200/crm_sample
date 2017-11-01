package com.tuyu.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author walker tu
 * @date 2017/11/1
 * @description：
 */
@Controller
@Scope("prototype")
public class IndexAction {

    public String execute() {
        return "index";
    }
}
