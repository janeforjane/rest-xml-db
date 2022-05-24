package com.jfj.service;

import com.jfj.db.BookRepository;
import com.jfj.entities.BookEntity;
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
    public List<BookEntity> findAllBooks() {

        List<BookEntity> bookList = new ArrayList<>();

        Iterable<BookEntity> bookEntities = bookRepository.findAll();

//        return bookRepository.findAll();
        return null;
    }

    @Override
    public BookEntity findById(long id) {

        Optional<BookEntity> bookEntity = bookRepository.findById(id);

        if(bookEntity.isPresent()){
            return bookEntity.get();
        }

        return null;
    }

    @Override
    public BookEntity insert(BookEntity book) {

        return bookRepository.save(book);
    }
}
