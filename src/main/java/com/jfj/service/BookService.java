package com.jfj.service;

import com.jfj.entities.BookDBEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    List<BookDBEntity> findAllBooks();
    BookDBEntity findById(long id);
    BookDBEntity insert(BookDBEntity book);

}
