package com.filewriter.datatocsv.controller;

import com.filewriter.datatocsv.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/datacsvconversion")
    public String dataConvertToCsv(){
        return bookService.dataConversionToCsv();
    }
}
