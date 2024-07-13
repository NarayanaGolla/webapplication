package com.web.application.service.impl;

import com.web.application.dao.RegisterDao;
import com.web.application.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("myRegisterService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Override
    public Serializable save(Object persistObject) {
        return registerDao.save(persistObject);
    }
}
