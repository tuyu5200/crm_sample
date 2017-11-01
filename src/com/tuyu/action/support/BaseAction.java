package com.tuyu.action.support;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

/**
 * @author walker tu
 * @date 2017/10/31
 * @description： 提供一些action的通用方法
 */
public abstract class BaseAction {

    /**
     * 获取session对象
     *
     * @param isNative 是否获取原生的session对象 true表示获取原生，false表示获取Map包装后的session
     * @return session对象
     */
    protected Object getSession(boolean isNative) {
        if (isNative) {
            return ServletActionContext.getRequest().getSession();
        }
        return ActionContext.getContext().getSession();
    }

    /**
     * 获取request对象
     *
     * @param isNative 是否获取原生的request对象 true表示获取原生，false表示获取Map包装后的request对象
     * @return
     */
    protected Object getRequest(boolean isNative) {
        if (isNative) {
            return ServletActionContext.getRequest();
        }
        return ActionContext.getContext().get("request");
    }

    /**
     * 向session作用域中存值
     *
     * @param name            键
     * @param value           值
     * @param isNativeSession 是否使用原生HttpSession， true 是 ， false 使用Map
     */
    protected void setSessionAttribute(String name, Object value, boolean isNativeSession) {
        if (Objects.isNull(name) || Objects.equals("", name)) {
            throw new IllegalArgumentException("向session中存值时键不能为空");
        }
        if (isNativeSession) {
            HttpSession session = (HttpSession) this.getSession(true);
            session.setAttribute(name, value);
        } else {
            Map<String, Object> session = (Map<String, Object>) this.getSession(false);
            session.put(name, value);
        }
    }

    /**
     * 向request作用域中存值
     *
     * @param name            键
     * @param value           值
     * @param isNativeRequest 是否使用ServletRequest对象 ，true 是， false 使用Map
     */
    protected void setRequestAttribute(String name, Object value, boolean isNativeRequest) {
        if (Objects.isNull(name) || Objects.equals("", name)) {
            throw new IllegalArgumentException("向request中存值时键不能为空");
        }
        if (isNativeRequest) {
            ServletRequest request = (ServletRequest) this.getRequest(true);
            request.setAttribute(name, value);
        } else {
            Map<String, Object> request = (Map<String, Object>) this.getRequest(false);
            request.put(name, value);
        }
    }

    /**
     * 获取session中的值
     *
     * @param key             对应的键
     * @param isNativeSession 是否使用原生session（HttpSession）
     * @return object
     */
    protected Object getSessionAttribute(String key, boolean isNativeSession) {
        if (isNativeSession) {
            HttpSession session = (HttpSession) this.getSession(true);
            return session.getAttribute(key);
        } else {
            Map<String, Object> session = (Map<String, Object>) this.getSession(false);
            return session.get(key);
        }
    }

    /**
     * 获取request作用域中的值
     *
     * @param key             要获取的键
     * @param isNativeRequest 是否使用原生request
     * @return object
     */
    protected Object getRequestAttribute(String key, boolean isNativeRequest) {
        if (isNativeRequest) {
            ServletRequest request = (ServletRequest) this.getRequest(true);
            return request.getAttribute(key);
        } else {
            Map<String, Object> request = (Map<String, Object>) this.getRequest(false);
            return request.get(key);
        }
    }
}
