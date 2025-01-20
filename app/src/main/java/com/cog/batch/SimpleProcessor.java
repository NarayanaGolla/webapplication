package com.cog.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//Define a processor to transform data.

@Component
public class SimpleProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) throws Exception {
        return item.toLowerCase(); // Transform data
    }
}

