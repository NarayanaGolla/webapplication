package com.cog.dom;

import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String course;
    private String email;
}

