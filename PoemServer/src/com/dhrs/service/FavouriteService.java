package com.dhrs.service;

import com.dhrs.domain.FavouritePoemInfo;
import com.dhrs.domain.Poem;
import com.dhrs.domain.User;

public interface FavouriteService {

    Poem getPoemByTitle(String title);

    boolean removePoemInfo(User user, FavouritePoemInfo info);

    boolean addPoemInfo(User user, FavouritePoemInfo info);
}
