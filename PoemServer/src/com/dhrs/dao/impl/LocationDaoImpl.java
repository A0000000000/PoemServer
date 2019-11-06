package com.dhrs.dao.impl;

import com.dhrs.dao.LocationDao;
import com.dhrs.domain.Location;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LocationDaoImpl  extends HibernateDaoSupport implements LocationDao {
    @Override
    public Location selectLocationByName(String name) throws Exception {
        Location location = new Location();
        location.setLocationName(name);
        List<Location> list = getHibernateTemplate().findByExample(location);
        return list == null ? null : (list.size() > 0 ? list.get(0) : null);
    }
}
