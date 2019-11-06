package com.dhrs.service.impl;

import com.dhrs.dao.FavouriteDao;
import com.dhrs.domain.FavouritePoemInfo;
import com.dhrs.domain.Poem;
import com.dhrs.domain.User;
import com.dhrs.service.FavouriteService;
import com.dhrs.service.PoemService;

public class FavouriteServiceImpl implements FavouriteService {

    private FavouriteDao favouriteDao;
    private PoemService poemService;

    @Override
    public Poem getPoemByTitle(String title) {
        try {
            return poemService.getPoemByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removePoemInfo(User user, FavouritePoemInfo info) {
        try {
            favouriteDao.deletePoemInfo(user, info);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addPoemInfo(User user, FavouritePoemInfo info) {
        try {
            favouriteDao.insertPoemInfo(user, info);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public FavouriteDao getFavouriteDao() {
        return favouriteDao;
    }

    public void setFavouriteDao(FavouriteDao favouriteDao) {
        this.favouriteDao = favouriteDao;
    }

    public PoemService getPoemService() {
        return poemService;
    }

    public void setPoemService(PoemService poemService) {
        this.poemService = poemService;
    }
}
