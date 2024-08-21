package com.web.application.designpattern;

public class FactoryProducer {

    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return null;

        }else{
            return new ShapeFactory();
        }
    }
}
