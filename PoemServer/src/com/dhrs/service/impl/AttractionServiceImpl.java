package com.dhrs.service.impl;

import com.dhrs.dao.AttractionDao;
import com.dhrs.domain.Attraction;
import com.dhrs.service.AttractionService;


public class AttractionServiceImpl implements AttractionService {

    private AttractionDao attractionDao;

    @Override
    public Attraction getAttractionByName(String name) {
        Attraction attraction = null;
        try {
            attraction = attractionDao.selectAttractionByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attraction;
    }
    public AttractionDao getAttractionDao() {
        return attractionDao;
    }

    public void setAttractionDao(AttractionDao attractionDao) {
        this.attractionDao = attractionDao;
    }
}
