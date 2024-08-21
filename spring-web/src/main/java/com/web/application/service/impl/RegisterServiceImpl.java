package com.web.application.service.impl;

import com.web.application.dao.RegisterDao;
import com.web.application.exception.CustomException;
import com.web.application.service.RegisterService;
import com.web.application.dom.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service("myRegisterService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Override
    public Serializable save(Object persistObject) {
        return registerDao.save(persistObject);
    }


    @Override
    public boolean userExists(String username, String email) throws CustomException {
        Optional<Register> register = this.registerDao.findByUsernameAndEmail(username , email);
        if (register != null && !register.isPresent()) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Optional<Register> loginUser(String password, String emailed) throws CustomException {
        return registerDao.loginUser(password , emailed);
    }

    @Override
    public List<Register> fetchUserRegisterList() {
        return registerDao.fetchUserRegisterList();
    }
}
