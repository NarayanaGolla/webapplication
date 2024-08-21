package com.training.designpattern;

public class PrototypePatternDemo {
    public static void main(String[] args) {

        ShapeCache.loadCache();

        ShapeProtoType clonedShape = (ShapeProtoType) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

    }
}
