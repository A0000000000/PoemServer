package com.dhrs.web.action;

import com.dhrs.domain.User;
import com.dhrs.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserAction extends ActionSupport {

    private String username;
    private String password;

    private UserService userService;

    public String favourites() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        return SUCCESS;
    }

    public String login() throws IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpSession session = request.getSession();
        User user = userService.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                response.getWriter().write("success");
            } else {
                response.getWriter().write("用户名或密码错误!");
            }
        } else {
            response.getWriter().write("用户不存在!");
        }
        return NONE;
    }

    public String register() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        if (userService.getUserByUsername(username) != null) {
            response.getWriter().write("用户名已存在!");
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            boolean res = userService.addNewUser(user);
            if (res) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("注册失败!");
            }
        }
        return NONE;
    }

    public String checkUsername() throws IOException {
        User user = userService.getUserByUsername(username);
        HttpServletResponse response = ServletActionContext.getResponse();
        if (user == null) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
        return NONE;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
