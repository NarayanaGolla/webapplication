package com.core.application.constants;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum EnumSingleton {

    INSTANCE("Initial enum info"); //Name of the single instance

    private String info;

    private EnumSingleton(String info) {
        this.info = info;
    }

    public EnumSingleton getInstance(){
        return INSTANCE;
    }

}
