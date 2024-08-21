package com.core.application.threads;

public class ThreadExample2 {
    public static void main(String args[]) {

        new NewThread("1st");

        try {
            Thread.sleep(8000); //8 sec
        } catch (InterruptedException excetion) {
            System.out.println("Inturruption occurs in Main Thread");
        }
        System.out.println("We are exiting from Main Thread");
    }
}
