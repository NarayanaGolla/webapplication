package com.core.application.functioninterface;

import java.util.ArrayList;
import java.util.List;

interface Drawable{
    public void draw();
}

interface Sayable{
    public String say();
}

interface SayableType{
    public String say(String name);
}

interface Addable{
    int add(int a,int b);
}

public class LambdaExpressionExample {
    public static void main(String[] args) {
        int width=10;

        //without lambda, Drawable implementation using anonymous class
        Drawable d=new Drawable(){
            public void draw(){System.out.println("Drawing "+width);}
        };

        //with lambda
        Drawable d2=()->{
            System.out.println("Drawing "+width);
        };

        Sayable s=()->{
            return "I have nothing to say.";
        };

        d.draw();

        // Lambda expression with single parameter.
        SayableType s1=(name)->{
            return "Hello, "+name;
        };
        System.out.println(s1.say("Sonoo"));

        // You can omit function parentheses
        SayableType s2= name ->{
            return "Hello, "+name;
        };
        System.out.println(s2.say("Sonoo"));


        // Multiple parameters in lambda expression
        Addable ad1=(a,b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Multiple parameters with data type in lambda expression
        Addable ad2=(int a,int b)->(a+b);
        System.out.println(ad2.add(100,200));

        List<String> list=new ArrayList<>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(
                (n)->System.out.println(n)
        );


    }
}
