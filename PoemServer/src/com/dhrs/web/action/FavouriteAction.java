package com.dhrs.web.action;

import com.dhrs.domain.FavouritePoemInfo;
import com.dhrs.domain.Poem;
import com.dhrs.domain.User;
import com.dhrs.service.FavouriteService;
import com.dhrs.service.UserService;
import com.dhrs.utils.JSONUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class FavouriteAction extends ActionSupport {

    private String title;

    private UserService userService;
    private FavouriteService favouriteService;

    public String changeFavouriteState() throws IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user = userService.getUserByID(user.getUserID());
        Poem poem = favouriteService.getPoemByTitle(title);
        Set<FavouritePoemInfo> infos = user.getFavouritePoemInfos();
        FavouritePoemInfo tmp = null;
        for (FavouritePoemInfo info : infos){
            if(info.getPoem().getPoemTitle().equals(poem.getPoemTitle())){
                tmp = info;
                break;
            }
        }
        if(tmp != null){
            boolean res = favouriteService.removePoemInfo(user, tmp);
            if(res){
                response.getWriter().write("2");
            }else{
                response.getWriter().write("取消收藏出错!请稍后再试");
            }
        }else{
            tmp = new FavouritePoemInfo();
            tmp.setPoem(poem);
            tmp.setFavouriteTime(new Date());
            tmp.setUser(user);
            boolean res = favouriteService.addPoemInfo(user, tmp);
            if(res){
                response.getWriter().write("1");
            }else{
                response.getWriter().write("收藏出错!请稍后再试.");
            }
        }
        return NONE;
    }

    public String isFavouritePoem() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        if(user != null){
            user = userService.getUserByID(user.getUserID());
            Poem poem = favouriteService.getPoemByTitle(title);
            Set<FavouritePoemInfo> infos = user.getFavouritePoemInfos();
            boolean flag = true;
            for (FavouritePoemInfo info : infos){
                if(info.getPoem().getPoemTitle().equals(poem.getPoemTitle())){
                    response.getWriter().write("1");
                    flag = false;
                    break;
                }
            }
            if (flag){
                response.getWriter().write("2");
            }
        }else {
            response.getWriter().write("2");
        }
        return NONE;
    }

    public String getFavouritePoems() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        user = userService.getUserByID(user.getUserID());
        Set<FavouritePoemInfo> infos = user.getFavouritePoemInfos();
        List<Map<String, String>> list = new ArrayList<>();
        for(FavouritePoemInfo info : infos){
            list.add(JSONUtils.PoemToJson(info.getPoem()));
        }
        String res = JSONUtils.ListToJson(list);
        response.getWriter().write(res);
        return NONE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public FavouriteService getFavouriteService() {
        return favouriteService;
    }

    public void setFavouriteService(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }
}
