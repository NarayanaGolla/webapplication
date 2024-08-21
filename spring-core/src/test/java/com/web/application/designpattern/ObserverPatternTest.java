package com.training.designpattern;

/*
Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified,
its depenedent objects are to be notified automatically.
Observer pattern falls under behavioral pattern category.
 */
public class ObserverPatternTest {
    public static void main(String[] args) {

        Subject subject = new Subject();

        new HexaObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

    }
}
