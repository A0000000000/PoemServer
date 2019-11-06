package com.dhrs.domain;

import java.io.Serializable;
import java.util.Set;

public class Poem implements Serializable {
    private String PoemID;
    private Poet poet;
    private Attraction attraction;
    private String PoemTitle;
    private String PoemText;
    private Set<FavouritePoemInfo> favouritePoemInfos;

    public String getPoemID() {
        return PoemID;
    }

    public void setPoemID(String poemID) {
        PoemID = poemID;
    }

    public Poet getPoet() {
        return poet;
    }

    public void setPoet(Poet poet) {
        this.poet = poet;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public String getPoemTitle() {
        return PoemTitle;
    }

    public void setPoemTitle(String poemTitle) {
        PoemTitle = poemTitle;
    }

    public String getPoemText() {
        return PoemText;
    }

    public void setPoemText(String poemText) {
        PoemText = poemText;
    }

    public Set<FavouritePoemInfo> getFavouritePoemInfos() {
        return favouritePoemInfos;
    }

    public void setFavouritePoemInfos(Set<FavouritePoemInfo> favouritePoemInfos) {
        this.favouritePoemInfos = favouritePoemInfos;
    }
}
