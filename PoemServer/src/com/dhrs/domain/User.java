package com.dhrs.domain;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    private String UserID;
    private String Username;
    private String Password;
    private Set<FavouritePoemInfo> favouritePoemInfos;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Set<FavouritePoemInfo> getFavouritePoemInfos() {
        return favouritePoemInfos;
    }

    public void setFavouritePoemInfos(Set<FavouritePoemInfo> favouritePoemInfos) {
        this.favouritePoemInfos = favouritePoemInfos;
    }
}
