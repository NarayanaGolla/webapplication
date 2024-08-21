package com.web.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginBean {

    @NotNull(message = "userName cannot be null")
    @Size(min = 1, message = "userName cannot be empty")
    private String userName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 5, max = 15, message = "Password must be between 5 and 15 characters")
    private String password;

    @ValidInActive
    private boolean inActive;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isInActive() {
        return inActive;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }
}
