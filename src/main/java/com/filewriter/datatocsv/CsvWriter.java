package com.filewriter.datatocsv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvWriter {

    public static void writeCsv(List<User> userList, String filePath) {
       /* try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write header
            String[] header = {"ID", "Name", "Age", "Email"};
            writer.writeNext(header);

            // Write records
            userList.stream()
                    .map(user -> new String[]{String.valueOf(user.getId()), user.getName(), String.valueOf(user.getAge()), user.getEmail()})
                    .forEach(record -> writer.writeNext(record));

            System.out.println("CSV file written successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write header
            String[] header = {"ID", "Name", "Age", "Email"};
            writer.writeNext(header);
            // Convert each User object to a string array and collect into a list
            List<String[]> records = userList.stream()
                    .map(user -> new String[]{String.valueOf(user.getId()), user.getName(), String.valueOf(user.getAge()), user.getEmail()})
                    .collect(Collectors.toList());

            // Write all records to the CSV file at once
            writer.writeAll(records);

            System.out.println("CSV file written successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example data: List of User objects
        User user = new User(1, "John Doe", 30, "john@example.com");
        User user2 = new User(2, "Jane Smith", 25, "jane@example.com");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);

        // Path to the CSV file
        String filePath = "output2.csv";

        // Write data to CSV file
        writeCsv(userList, filePath);
    }

    public static class User {
        private int id;
        private String name;
        private int age;
        private String email;

        public User(int id, String name, int age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }
    }
}
