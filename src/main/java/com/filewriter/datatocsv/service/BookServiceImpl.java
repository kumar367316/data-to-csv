package com.filewriter.datatocsv.service;

import com.filewriter.datatocsv.model.Book;
import com.filewriter.datatocsv.repository.BookRepository;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookRepository bookRepository;

    @Override
    public String dataConversionToCsv() {
        try (CSVWriter writer = new CSVWriter(new FileWriter("opencsvwriter.csv"))) {
            List<Book> bookList = bookRepository.findAll();
            if (CollectionUtils.isEmpty(bookList)) {
                return "No data for processing";
            }
            String[] header = {"BookID", "BookAuthor", "BookName", "BookPrice"};
            writer.writeNext(header);
            List<String[]> records = bookList.stream()
                    .map(book -> new String[]{String.valueOf(book.getId()), book.getAuthor(), book.getName(), String.valueOf(book.getPrice())})
                    .collect(Collectors.toList());
            writer.writeAll(records);

            System.out.println("CSV file written successfully at: " + "opencsvwriter.csv");
        } catch (Exception exception) {
            logger.error("Error while writing file", exception.getMessage());
            return "Error while writing file";
        }
        return "successfully while writing file";
    }
}
