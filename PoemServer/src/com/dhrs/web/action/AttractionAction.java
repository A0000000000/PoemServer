package com.dhrs.web.action;

import com.dhrs.domain.Attraction;
import com.dhrs.domain.Location;
import com.dhrs.service.AttractionService;
import com.dhrs.service.LocationService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Set;

public class AttractionAction extends ActionSupport {

    private String location;

    private LocationService locationService;

    public String getAttractionsByLocation() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        Location local = locationService.getLocationByName(location);
        Set<Attraction> attractions = local.getAttractions();
        StringBuffer sb = new StringBuffer();
        for(Attraction attraction : attractions){
            sb.append(attraction.getAttractionName() + "#");
        }
        sb.deleteCharAt(sb.length() - 1);
        response.getWriter().write(sb.toString());
        return NONE;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

}
