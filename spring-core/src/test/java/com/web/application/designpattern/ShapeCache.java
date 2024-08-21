package com.training.designpattern;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, ShapeProtoType> shapeMap  = new Hashtable<String, ShapeProtoType>();

    public static ShapeProtoType getShape(String shapeId) {
        ShapeProtoType cachedShape = shapeMap.get(shapeId);
        return (ShapeProtoType) cachedShape.clone();
    }

    // for each shape run database query and create shape
    // shapeMap.put(shapeKey, shape);
    // for example, we are adding three shapes

    public static void loadCache() {
        //Circle circle = new Circle();
       // circle.setId("1");
       // shapeMap.put(circle.getId(),circle);

        //Square square = new Square();
        //square.setId("2");
        //shapeMap.put(square.getId(),square);

        RectangleProtoType rectangle = new RectangleProtoType();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
