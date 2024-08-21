package com.core.application.threads;

public class NewThread  implements Runnable {

    String name;
    Thread thread;
    NewThread (String name){
        this.name = name;
        thread = new Thread(this, name);
        System.out.println( "A New thread: " + thread+ "is created\n" );
        thread.start();
    }

    public void run() {
        try {
            for(int j = 5; j > 0; j--) {
                System.out.println(name + ": " + j);
                Thread.sleep(2000);
            }
        }catch (InterruptedException e) {
            System.out.println(name + " thread Interrupted");
        }
        System.out.println(name + " thread exiting.");
    }
}
