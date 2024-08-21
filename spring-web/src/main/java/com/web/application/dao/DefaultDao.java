package com.web.application.dao;

import com.web.application.exception.CustomException;
import com.web.application.dom.Register;

import java.io.Serializable;
import java.util.Optional;

public interface DefaultDao {

    Serializable save(Object persistObject);

    Optional<Register> loginUser(String password, String emailed) throws CustomException;
}
