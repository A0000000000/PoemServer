package com.dhrs.service.impl;

import com.dhrs.dao.PoemDao;
import com.dhrs.domain.Poem;
import com.dhrs.service.PoemService;

public class PoemServiceImpl implements PoemService {

    private PoemDao poemDao;

    @Override
    public Poem getPoemByTitle(String title) {
        try {
            return poemDao.selectPoemByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PoemDao getPoemDao() {
        return poemDao;
    }

    public void setPoemDao(PoemDao poemDao) {
        this.poemDao = poemDao;
    }

}
