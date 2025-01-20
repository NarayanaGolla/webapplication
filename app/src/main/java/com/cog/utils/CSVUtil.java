package com.cog.utils;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.List;

public class CSVUtil {

    public static List<String[]> readCSV(String filePath) throws Exception {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            return csvReader.readAll(); // Returns all rows as a list of String arrays
        }
    }
}

