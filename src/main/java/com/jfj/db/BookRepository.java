package com.jfj.db;

import com.jfj.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

//    List<BookEntity> findAll();

//    List<BookEntity> findAllById();

    Optional<BookEntity> findById(long id);


}
