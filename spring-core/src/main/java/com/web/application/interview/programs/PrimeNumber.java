package com.training.interview;

public class PrimeNumber {
    public static void main(String[] args) {

        for(int index=1 ; index <=100 ; index++) {
            int c=0;

            // inner loop start
            for(int num = index ; num >=1 ; num--) {
                if(index % num == 0) {
                    c = c+1;
                }
            } // inner loop start

            int prime ;
            if(c==2) {
                System.out.println("Prime number" + index);
            }

        }
    }
}
