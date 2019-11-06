package com.dhrs.domain;

import java.io.Serializable;
import java.util.Set;

public class Poet implements Serializable {
    private String PoetID;
    private String PoetName;
    private Location location;
    private String Dynasty;
    private String PoetMessage;
    private Set<Poem> poems;

    public String getPoetID() {
        return PoetID;
    }

    public void setPoetID(String poetID) {
        PoetID = poetID;
    }

    public String getPoetName() {
        return PoetName;
    }

    public void setPoetName(String poetName) {
        PoetName = poetName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDynasty() {
        return Dynasty;
    }

    public void setDynasty(String dynasty) {
        Dynasty = dynasty;
    }

    public String getPoetMessage() {
        return PoetMessage;
    }

    public void setPoetMessage(String poetMessage) {
        PoetMessage = poetMessage;
    }

    public Set<Poem> getPoems() {
        return poems;
    }

    public void setPoems(Set<Poem> poems) {
        this.poems = poems;
    }
}
