package com.jfj.controller;

import com.jfj.bookmodel.BookCatalogue;
import com.jfj.entities.BookEntity;
import com.jfj.service.XMLHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

import com.jfj.service.BookService;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    XMLHandler xmlHandler;


    @GetMapping("")
    public List<BookEntity> getAllPeople() {
        return bookService.findAllBooks();
    }

    @GetMapping("{id}")
    public BookEntity getBook(@PathVariable long id){
        return bookService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> addBook(@RequestBody BookEntity book){


        if(book != null){
            bookService.insert(book);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>("book is null",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getFromXML")
    public String getFromXML() throws JAXBException, IOException {

        InputStream is = null;

        is = new FileInputStream("BookCatalog.xml");

        BookCatalogue bookCatalogue = xmlHandler.readXML(is);

        is.close();

        return bookCatalogue.getBook().toString();
    }

}
