package com.core.application.collection.utils;

import com.core.application.collection.utils.dom.Person;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ListStreamUtilsTest {

    @Test
    public void sortedList(){

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

    }

    @Test
    public void convertStringArrayToList() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(filteredNames); // Output: [Alice]

        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie", "David");

        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(nameLengths); // Output: [5, 3, 7, 5]


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println(sum); // Output: 15

        List<String> names12 = Arrays.asList("Charlie", "Alice", "David", "Bob");

        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNames); // Output: [Alice, Bob, Charlie, David]

        List<String> names56 = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(name -> name, String::length));

        System.out.println(nameLengthMap); // Output: {Alice=5, Bob=3, Charlie=7, David=5}


        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David")
        );

        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flatList); // Output: [Alice, Bob, Charlie, David]

        List<String> names123 = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Predicate to check if a string starts with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        List<String> filteredNames12 = names.stream()
                .filter(startsWithA)
                .collect(Collectors.toList());

        System.out.println(filteredNames); // Output: [Alice]

        // Supplier to provide the current time in milliseconds
        Supplier<Long> currentTimeSupplier = System::currentTimeMillis;

        // Use the supplier
        long currentTime = currentTimeSupplier.get();

        System.out.println(currentTime);

        // Another example with a custom supplier
        Supplier<String> stringSupplier = () -> "Hello, World!";

        // Supplier to provide a default message if no names match the predicate
        Supplier<String> defaultMessage = () -> "No names match the criteria.";

        // Use the supplier
        String result = stringSupplier.get();

        System.out.println(result); // Output: Hello, World!


    }
}
