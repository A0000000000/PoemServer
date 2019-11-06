package com.dhrs.dao;

import com.dhrs.domain.User;

public interface UserDao {

    User selectUserByName(String username) throws Exception;

    void insertNewUser(User user) throws Exception;

    User selectUserByID(String id) throws Exception;

}
