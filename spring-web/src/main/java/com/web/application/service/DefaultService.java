package com.web.application.service;

import com.web.application.exception.CustomException;
import com.web.application.dom.Register;

import java.io.Serializable;
import java.util.Optional;

public interface DefaultService {

    Serializable save(Object persistObject);
    boolean userExists(String username, String email) throws CustomException;
    Optional<Register> loginUser(String password, String emailed) throws CustomException;
}
