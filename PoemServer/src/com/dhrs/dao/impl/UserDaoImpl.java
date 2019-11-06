package com.dhrs.dao.impl;

import com.dhrs.dao.UserDao;
import com.dhrs.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl  extends HibernateDaoSupport implements UserDao {
    @Override
    public User selectUserByName(String username) throws Exception {
        User user = new User();
        user.setUsername(username);
        List<User> list = getHibernateTemplate().findByExample(user);
        return list == null ? null : (list.size() > 0 ? list.get(0) : null);
    }

    @Override
    public void insertNewUser(User user) throws Exception {
        getHibernateTemplate().save(user);
    }

    @Override
    public User selectUserByID(String id) throws Exception {
        User user = getHibernateTemplate().get(User.class, id);
        return user;
    }
}
