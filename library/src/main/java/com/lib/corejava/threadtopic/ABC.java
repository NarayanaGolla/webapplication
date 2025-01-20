package com.lib.corejava.threadtopic;

class ABC implements Runnable   {
    @Override
    public void run() {

        // try-catch block
        try {
            System.out.println("ABC run state");
       // moving thread t2 to the state timed waiting
            Thread.sleep(100);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("The state of thread t1 while it invoked the method join() on thread t2 -"+ ThreadState.t1.getState());


        // try-catch block
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }


    }
}
