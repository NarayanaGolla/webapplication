package com.common.assertjth;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

public class AssertJExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Assert that the list contains specific elements
        assertThat(names).contains("Alice1", "Charlie");

        // Assert that the list contains elements in any order
        assertThat(names).containsExactlyInAnyOrder("Charlie", "Alice", "Bob");

        // Assert that the list contains elements in the given order
        assertThat(names).containsSequence("Alice", "Bob");

        System.out.println("Assertions passed!");
    }
}
