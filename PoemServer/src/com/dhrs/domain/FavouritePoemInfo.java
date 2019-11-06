package com.dhrs.domain;

import java.io.Serializable;
import java.util.Date;

public class FavouritePoemInfo implements Serializable {
    private String FavouritePoemID;
    private User user;
    private Poem poem;
    private Date FavouriteTime;

    public String getFavouritePoemID() {
        return FavouritePoemID;
    }

    public void setFavouritePoemID(String favouritePoemID) {
        FavouritePoemID = favouritePoemID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Poem getPoem() {
        return poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }

    public Date getFavouriteTime() {
        return FavouriteTime;
    }

    public void setFavouriteTime(Date favouriteTime) {
        FavouriteTime = favouriteTime;
    }
}
