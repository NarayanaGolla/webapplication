package java8features;

import java.util.function.Function;

class LambdaFunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> lengthFunction = str -> str.length();

        System.out.println("Length of 'Lambda': " + lengthFunction.apply("Lambda"));
    }
}


public class UsingFunctionforTransformation {
}
