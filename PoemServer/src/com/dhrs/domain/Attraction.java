package com.dhrs.domain;

import java.io.Serializable;
import java.util.Set;

public class Attraction implements Serializable {
    private String AttractionID;
    private Location location;
    private String AttractionName;
    private Set<Poem> poems;

    public String getAttractionID() {
        return AttractionID;
    }

    public void setAttractionID(String attractionID) {
        AttractionID = attractionID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAttractionName() {
        return AttractionName;
    }

    public void setAttractionName(String attractionName) {
        AttractionName = attractionName;
    }

    public Set<Poem> getPoems() {
        return poems;
    }

    public void setPoems(Set<Poem> poems) {
        this.poems = poems;
    }
}
