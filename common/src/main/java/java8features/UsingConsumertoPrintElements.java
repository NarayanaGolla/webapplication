package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class LambdaConsumerExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<Integer> printNumber = num -> System.out.println(num);

        numbers.forEach(printNumber);
    }
}


public class UsingConsumertoPrintElements {
}
