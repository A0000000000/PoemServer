package com.dhrs.dao;

import com.dhrs.domain.FavouritePoemInfo;
import com.dhrs.domain.Poem;
import com.dhrs.domain.User;

public interface FavouriteDao {

    void deletePoemInfo(User user, FavouritePoemInfo info) throws Exception;

    void insertPoemInfo(User user, FavouritePoemInfo info) throws Exception;
}
