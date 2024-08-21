package com.core.application.threads;

public class TestSleepMethod1 extends Thread {

    public void run(){
        for(int i=1;i<5;i++){
            // the thread will sleep for the 500 milli seconds
            try{
                System.out.println("Thread start");
                Thread.sleep(5000);
                System.out.println("Thread end");
            }

            catch(InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i + "---" + Thread.currentThread().getName());
        }
    }
    public static void main(String args[]){
        TestSleepMethod1 t1=new TestSleepMethod1();
        TestSleepMethod1 t2=new TestSleepMethod1();

        t1.start();
        t2.start();
    }
}
