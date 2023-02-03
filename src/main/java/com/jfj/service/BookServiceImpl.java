package com.jfj.service;

import com.jfj.db.BookRepository;
import com.jfj.entities.BookDBEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookDBEntity> findAllBooks() {

        List<BookDBEntity> bookList = new ArrayList<>();

        List<BookDBEntity> bookEntities = (List<BookDBEntity>) bookRepository.findAll();

//        return bookRepository.findAll();
        return bookEntities;
    }

    @Override
    public BookDBEntity findById(long id) {

        Optional<BookDBEntity> bookEntity = bookRepository.findById(id);

        if(bookEntity.isPresent()){
            return bookEntity.get();
        }

        return null;
    }

    @Override
    public BookDBEntity insert(BookDBEntity book) {

        return bookRepository.save(book);
    }
}
