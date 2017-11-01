package com.tuyu.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author walker tu
 * @date 2017/10/31
 * @description： 做安全控制
 */
@Component
public class SecurityInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionProxy proxy = actionInvocation.getProxy();
        String namespace = proxy.getNamespace();
        String actionName = proxy.getActionName();
        String method = proxy.getMethod();
        //如果是登陆，不拦截
        if (Objects.equals("/", namespace) && Objects.equals(actionName, "login") && Objects.equals("login", method)) {
            actionInvocation.invoke();
            return null;
        }
        //判断当前用户是否登陆
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (!session.containsKey("_SUBJECT")) {
            return "login";
        }
        //判断当前登陆用户的操作是否具有相应的权限


        actionInvocation.invoke();
        return null;
    }
}
