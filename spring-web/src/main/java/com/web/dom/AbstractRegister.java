package com.web.dom;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractRegister extends ApplicationId {

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="inactive")
    private boolean inActive;

    @Column(name="gender")
    private String gender;

    @Column(name="country")
    private String country;

    @Column(name="emailed")
    private String emailId;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="createdate")
    private String createDate;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
