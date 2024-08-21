package com.training.thread;

class Counter {
    private int count = 0;

    private final Object lock = new Object();

    // Synchronized method to ensure only one thread can access this method at a time
    public synchronized void increment() {
        count++;
    }

    // Method with synchronized block to ensure only one thread can execute this block at a time
    public void increment1() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
