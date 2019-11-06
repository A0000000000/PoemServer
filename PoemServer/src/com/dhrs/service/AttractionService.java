package com.dhrs.service;

import com.dhrs.domain.Attraction;
import com.dhrs.domain.Location;

import java.util.List;

public interface AttractionService {

    Attraction getAttractionByName(String name);
}
