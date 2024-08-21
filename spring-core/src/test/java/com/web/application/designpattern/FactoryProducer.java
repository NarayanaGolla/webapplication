package com.training.designpattern;

public class FactoryProducer {

    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return null;

        }else{
            return new ShapeFactory();
        }
    }
}
