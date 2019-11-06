package com.dhrs.service.impl;

import com.dhrs.dao.LocationDao;
import com.dhrs.domain.Location;
import com.dhrs.service.LocationService;

public class LocationServiceImpl implements LocationService {

    private LocationDao locationDao;

    @Override
    public Location getLocationByName(String name) {
        Location location = null;
        try {
            location = locationDao.selectLocationByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    public LocationDao getLocationDao() {
        return locationDao;
    }

    public void setLocationDao(LocationDao locationDao) {
        this.locationDao = locationDao;
    }
}
