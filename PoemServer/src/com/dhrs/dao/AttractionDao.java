package com.dhrs.dao;

import com.dhrs.domain.Attraction;
import com.dhrs.domain.Location;

import java.util.List;

public interface AttractionDao {

    Attraction selectAttractionByName(String name) throws Exception;

}
