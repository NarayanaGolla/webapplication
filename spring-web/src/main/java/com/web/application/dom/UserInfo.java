package com.web.application.dom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userinfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String username;

    @JsonIgnore
    private String password;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

}
