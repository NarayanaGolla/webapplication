package com.training.thread;

public class ThreadLocalExample {

    // Create a ThreadLocal variable
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {

        // Create a few threads
        Thread thread1 = new Thread(new MyRunnable(), "Thread-1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread-2");
        Thread thread3 = new Thread(new MyRunnable(), "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {

            try {
                // Get the current thread's value of the thread-local variable
                Integer initialValue = threadLocal.get();
                System.out.println(Thread.currentThread().getName() + " initial value: " + initialValue);

                // Set a new value
                threadLocal.set(initialValue + 1);

                // Get the updated value
                Integer updatedValue = threadLocal.get();
                System.out.println(Thread.currentThread().getName() + " updated value: " + updatedValue);

            } finally {
                // Ensure that the ThreadLocal value is removed to prevent memory leaks
                threadLocal.remove();
            }
        }

    }
}