package com.dhrs.domain;

import java.io.Serializable;
import java.util.Set;

public class Location implements Serializable {

    private String LocationID;
    private String LocationName;
    private Set<Attraction> attractions;
    private Set<Poet> poets;
    public String getLocationID() {
        return LocationID;
    }

    public void setLocationID(String locationID) {
        LocationID = locationID;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public Set<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Set<Attraction> attractions) {
        this.attractions = attractions;
    }

    public Set<Poet> getPoets() {
        return poets;
    }

    public void setPoets(Set<Poet> poets) {
        this.poets = poets;
    }
}
