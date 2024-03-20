package com.example.demo.post;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

public class CSVHelper {

    public static ByteArrayInputStream tutorialsToCSV(List<Post> tutorials) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Post tutorial : tutorials) {
                List<Object> data = Arrays.asList(
                        String.valueOf(tutorial.getId()),
                        tutorial.getTitle(),
                        tutorial.getContent(),
                        tutorial.getUrl_slug(),
                        tutorial.getViewCount());

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}