package com.web.application.dao;

import com.web.application.dom.User;

public interface UserDao {
    User findByUsername(String username);
}
