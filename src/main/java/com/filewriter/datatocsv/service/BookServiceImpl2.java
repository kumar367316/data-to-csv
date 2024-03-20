/*
package com.filewriter.datatocsv.service;

import com.filewriter.datatocsv.model.Book;
import com.filewriter.datatocsv.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class BookServiceImpl2 implements BookService{

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl2.class);
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "BookID,BookAuthor,BookName,BookPrice";

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String dataConversionToCsv() {
        FileWriter fileWriter = null;
        try{
            List<Book> bookList = bookRepository.findAll();
            if(CollectionUtils.isEmpty(bookList)){
                return "No data for processing";
            }

            fileWriter = new FileWriter("book.csv");
            //fileWriter = new FileWriter("book.txt"); generate txt file also
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(Book book : bookList){
                fileWriter.append(String.valueOf(book.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(book.getAuthor());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(book.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(book.getPrice()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        }catch (IOException exception){
            logger.error("Error while writing file",exception.getMessage());
            return "Error while writing file";
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                return "Error closing file writer";
            }
        }
        return "successfully while writing file";
    }
}
*/
