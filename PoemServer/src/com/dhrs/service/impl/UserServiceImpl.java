package com.dhrs.service.impl;

import com.dhrs.dao.UserDao;
import com.dhrs.domain.User;
import com.dhrs.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        try {
            user = userDao.selectUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean addNewUser(User user) {
        try {
            userDao.insertNewUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserByID(String id) {
        try {
            return userDao.selectUserByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
