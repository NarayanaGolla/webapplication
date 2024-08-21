package com.web.application.bean;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class RegisterBean {

    @NotNull(message = "userName cannot be null")
    @Size(min = 1, message = "userName cannot be empty")
    private String userName;
    @NotNull(message = "Password cannot be null")
    @Size(min = 5, max = 15, message = "Password must be between 5 and 15 characters")
    private String password;
    @ValidInActive
    private boolean inActive;
    private String gender;
    private String country;
    private String emailId;
    private String phoneNumber;
    private String createDate;

}
