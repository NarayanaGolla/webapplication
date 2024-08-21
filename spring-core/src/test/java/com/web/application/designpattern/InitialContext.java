package com.web.application.designpattern;

public class InitialContext {

    public Object lookup(String jndiName){
        if(jndiName.equalsIgnoreCase("SERVICE1")){
            System.out.println("Looking up and creating a new Service1 object");
            return new Service1();
        }
        return null;
    }
}
