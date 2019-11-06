package com.dhrs.dao;

import com.dhrs.domain.Location;

public interface LocationDao {

    Location selectLocationByName(String name) throws Exception;

}
