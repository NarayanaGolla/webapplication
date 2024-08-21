package com.web.application.dom;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

//@Data
@Getter
@Setter
@MappedSuperclass
//@EqualsAndHashCode(callSuper = false)
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userinfo_id", referencedColumnName = "id")
    private UserInfo userInfo;

    // Optionally, you can override equals() and hashCode() if necessary
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return id == register.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
