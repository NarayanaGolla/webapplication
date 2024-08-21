package com.web.application.dao;

import com.web.application.dom.User;
import com.web.application.exception.CustomException;
import com.web.application.dom.Register;

import java.util.List;
import java.util.Optional;


public interface RegisterDao extends DefaultDao {

    Optional<Register> findByUsernameAndEmail(String username , String email) throws CustomException;
    List<Register> fetchUserRegisterList();

}
