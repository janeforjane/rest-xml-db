package com.jfj.controller;

import com.jfj.bookmodel.Book;
import com.jfj.bookmodel.BookCatalogue;
import com.jfj.entities.BookDBEntity;
import com.jfj.entities.JsonBookEntity;
import com.jfj.mapper.BookMapper;
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

    @Autowired
    BookMapper mapper;


    @GetMapping("")
    public ResponseEntity getAllBooks() {
//        return bookService.findAllBooks();
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public BookDBEntity getBook(@PathVariable long id){
        return bookService.findById(id);
    }

    @PostMapping("postBook")
    public ResponseEntity<?> addBook(@RequestBody JsonBookEntity book){

        System.out.println("i'm here");
        System.out.println(book.toString());


        if(book != null){
            BookDBEntity transformed = mapper.transform(book);
            transformed.setId((long)2);
            bookService.insert(transformed);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>("book is null",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getFromXML")
    public String getFromXML() throws JAXBException, IOException {

        InputStream is = null;

        is = new FileInputStream("BookCatalog.xml");

        BookCatalogue bookCatalogue = xmlHandler.readXML(is);

        for (Book book : bookCatalogue.book) {

            BookDBEntity bookDBEntity = mapper.transformBook(book);

            System.out.println(bookDBEntity);
        }

        is.close();

        return bookCatalogue.getBook().toString();
    }

}
