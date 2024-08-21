package com.training.designpattern;

public class RectangleProtoType extends  ShapeProtoType {

    public RectangleProtoType(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
