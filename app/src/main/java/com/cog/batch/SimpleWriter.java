package com.cog.batch;

import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;
import org.springframework.batch.item.ItemWriter;

//Define a writer to output data.

@Component
public class SimpleWriter implements ItemWriter<String> {

    @Override
    public void write(Chunk<? extends String> items) throws Exception {
        System.out.println("Writing items: " + items);
    }
}

