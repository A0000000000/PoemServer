package com.dhrs.dao.impl;

import com.dhrs.dao.FavouriteDao;
import com.dhrs.domain.FavouritePoemInfo;
import com.dhrs.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


public class FavouriteDaoImpl extends HibernateDaoSupport implements FavouriteDao {

    @Override
    public void deletePoemInfo(User user, FavouritePoemInfo info) throws Exception {
        user.getFavouritePoemInfos().remove(info);
        getHibernateTemplate().update(user);
        getHibernateTemplate().delete(info);
    }

    @Override
    public void insertPoemInfo(User user, FavouritePoemInfo info) throws Exception {
        user.getFavouritePoemInfos().add(info);
        getHibernateTemplate().update(user);
        getHibernateTemplate().save(info);
    }
}
