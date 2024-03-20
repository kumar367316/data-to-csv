package com.filewriter.datatocsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DataToCsvApplication {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("sto1.csv");

        List<String> test = new ArrayList<>();
        test.add("Word1");
        test.add("Word2");
        test.add("Word3");
        test.add("Word4");

        String collect = test.stream().collect(Collectors.joining(","));
        System.out.println(collect);

        writer.write(collect);
        writer.close();
        SpringApplication.run(DataToCsvApplication.class, args);
    }

}
