package com.jfj.service;

import com.jfj.entities.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    List<BookEntity> findAllBooks();
    BookEntity findById(long id);
    BookEntity insert(BookEntity book);

}
