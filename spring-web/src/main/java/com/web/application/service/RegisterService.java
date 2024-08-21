package com.web.application.service;

import com.web.application.dom.Register;

import java.io.Serializable;
import java.util.List;


public interface RegisterService extends DefaultService {

    List<Register> fetchUserRegisterList();
}
