package com.cog.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// Define a simple reader that reads data.

@Component
public class SimpleReader implements ItemReader<String> {

    private List<String> data = Arrays.asList("A", "B", "C", "D", "E");
    private int index = 0;

    @Override
    public String read() throws Exception {
        if (index < data.size()) {
            return data.get(index++);
        } else {
            return null; // Signals end of data
        }
    }
}

