package java8features;

import java.util.function.Supplier;

class LambdaSupplierExample {
    public static void main(String[] args) {
        Supplier<Double> randomValue = () -> Math.random();

        System.out.println("Random Value: " + randomValue.get());
    }
}


public class UsingSupplierforLazyInitialization {
}
