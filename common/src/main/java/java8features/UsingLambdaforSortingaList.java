package java8features;

import java.util.*;

 class LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        System.out.println(names);
    }
}



 class LambdaSortExample1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        names.sort((s1, s2) -> s1.compareTo(s2));

        System.out.println(names);
    }
}

public class UsingLambdaforSortingaList {
}
