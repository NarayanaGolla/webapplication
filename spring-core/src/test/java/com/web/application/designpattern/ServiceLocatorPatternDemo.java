package com.web.application.designpattern;

public class ServiceLocatorPatternDemo {
    public static void main(String[] args) {

        Service service = ServiceLocator.getService("Service1");
        service.execute();

    }
}
