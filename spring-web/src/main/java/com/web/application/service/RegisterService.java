package com.web.application.service;

import com.web.application.interceptor.CustomInterceptor;
import org.springframework.stereotype.Service;

import java.io.Serializable;


public interface RegisterService extends DefaultService {
    @Override
    Serializable save(Object persistObject);
}
