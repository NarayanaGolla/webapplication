//package com.web.application.controller;
//
//import com.web.bean.RegisterBean;
//import com.web.dom.Register;
//import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//@WebMvcTest(RegistrationController.class)
//public class RegistrationControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private RegistrationController registerController;
//
//    private Register register;
//    private RegisterBean registerBean;
//
//    @BeforeEach
//    public void setup() {
//
//        register = new Register();
//        registerBean = new RegisterBean();
//        registerBean.setUserName("");
//        registerBean.setPassword("sankar");
//        registerBean.setInActive(true);
//        registerBean.setEmailId("gollanarayana114@gmail.com");
//        registerBean.setGender("M");
//        registerBean.setPhoneNumber("9986275546");
//        registerBean.setCountry("IND");
//        registerBean.setCreateDate("06-06-1986");
//
//    }
//
//    @Test
//    public void testRegisterUser_ValidUser()  throws Exception {
//
//        ResponseEntity<Register> responseEntity = new ResponseEntity<>(register, HttpStatus.OK);
//        when(registerController.userRegister(any(RegisterBean.class))).thenReturn(responseEntity);
//        mockMvc.perform(post("/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(registerBean)))
//                .andExpect(status().isOk());
//               // .andExpect(jsonPath("$.value1").value(10))
//                //.andExpect(jsonPath("$.value2").value(20))
//               // .andExpect(jsonPath("$.sum").value(30));
//        verify(registerController, times(1)).userRegister(any(RegisterBean.class));
//    }
//}
