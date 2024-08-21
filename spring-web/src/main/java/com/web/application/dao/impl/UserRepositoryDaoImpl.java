package com.web.application.dao.impl;

import com.web.application.dao.RegisterDao;
import com.web.application.dao.UserDao;
import com.web.application.dom.Register;
import com.web.application.dom.User;
import com.web.application.exception.CustomException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;


@Repository
public class UserRepository implements UserDao {

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
