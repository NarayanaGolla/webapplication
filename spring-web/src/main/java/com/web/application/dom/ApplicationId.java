package com.web.application.dom;

import lombok.Data;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract  class ApplicationId implements Serializable , Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    // Method 1
    @Override
    protected Object clone()
            throws CloneNotSupportedException {
        // Super() keyword refers to parent class
        return super.clone();
    }
}
