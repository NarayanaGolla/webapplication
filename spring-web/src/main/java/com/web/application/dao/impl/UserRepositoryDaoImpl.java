package com.web.application.dao.impl;

import com.web.application.dao.UserDao;
import com.web.application.dom.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryDaoImpl implements UserDao {

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
