package com.training.designpattern;

public class BridgePatternDemo {
    public static void main(String[] args) {

        ShapeBridge redCircle = new Circle(100,100, 10, new RedCircle());
        redCircle.draw();


    }
}
