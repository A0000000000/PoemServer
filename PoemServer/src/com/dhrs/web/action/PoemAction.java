package com.dhrs.web.action;

import com.dhrs.domain.Attraction;
import com.dhrs.domain.Poem;
import com.dhrs.service.AttractionService;
import com.dhrs.service.PoemService;
import com.dhrs.utils.JSONUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoemAction extends ActionSupport {

    private String attraction;
    private String title;

    private AttractionService attractionService;
    private PoemService poemService;

    public String getPoemsByAttraction() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        Attraction attr = attractionService.getAttractionByName(attraction);
        List<Map<String, String>> data = JSONUtils.PackagePoemsData(attr);
        String res = JSONUtils.ListToJson(data);
        response.getWriter().write(res);
        return NONE;
    }

    public String searchPoem(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        Poem poem = poemService.getPoemByTitle(title);
        if(poem != null){
            request.setAttribute("title", poem.getPoemTitle());
            request.setAttribute("dynasty", poem.getPoet().getDynasty());
            request.setAttribute("author", poem.getPoet().getPoetName());
            String[] content = poem.getPoemText().split("。");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < content.length; i++) {
                if(content[i].length() > 0) {
                    list.add(content[i] + "。");
                }
            }
            request.getSession().setAttribute("content", list);
        }else{
            request.setAttribute("title", title);
            request.setAttribute("dynasty", "没有数据！");
            request.setAttribute("author", "没有数据！");
            request.setAttribute("content", "没有数据！");
        }
        return SUCCESS;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AttractionService getAttractionService() {
        return attractionService;
    }

    public void setAttractionService(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    public PoemService getPoemService() {
        return poemService;
    }

    public void setPoemService(PoemService poemService) {
        this.poemService = poemService;
    }
}
