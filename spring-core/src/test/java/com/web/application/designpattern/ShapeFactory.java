package com.training.designpattern;

public class ShapeFactory extends AbstractFactory  {

    //use getShape method to get object of type shape
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
       if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        }

        return null;
    }
}
