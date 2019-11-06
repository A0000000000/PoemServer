package com.dhrs.web.interceptor;

import com.dhrs.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class CheckLoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "login";
        }
        String rtValue = actionInvocation.invoke();
        return rtValue;
    }
}
