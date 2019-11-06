package com.dhrs.dao.impl;

import com.dhrs.dao.AttractionDao;
import com.dhrs.domain.Attraction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class AttractionDaoImpl extends HibernateDaoSupport implements AttractionDao {
    @Override
    public Attraction selectAttractionByName(String name) throws Exception {
        Attraction attraction = new Attraction();
        attraction.setAttractionName(name);
        List<Attraction> list = getHibernateTemplate().findByExample(attraction);
        return list == null ? null : (list.size() > 0 ? list.get(0) : null);
    }
}
