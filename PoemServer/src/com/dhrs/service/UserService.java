package com.dhrs.service;

import com.dhrs.domain.User;

public interface UserService {

    User getUserByUsername(String username);

    boolean addNewUser(User user);

    User getUserByID(String id);
}
