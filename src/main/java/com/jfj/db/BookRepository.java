package com.jfj.db;

import com.jfj.entities.BookDBEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<BookDBEntity, Long> {

//    List<BookDBEntity> findAll();

//    List<BookDBEntity> findAllById();

    Optional<BookDBEntity> findById(long id);


}
