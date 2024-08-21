package com.core.application.threads;

public class Customer {

    int amount=10000;  // 10,000

    synchronized void withdraw(int amount){
        System.out.println("going to withdraw...");

        if(this.amount<amount){ // 15,000
            System.out.println("Less balance; waiting for deposit...");
            try{wait();}catch(Exception e){}
        }
        this.amount-=amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount){
        System.out.println("going to deposit...");
        this.amount+=amount;
        System.out.println("deposit completed... ");
        notify();
    }
}
