package com.jfj.mapper;

import com.jfj.bookmodel.Book;
import com.jfj.entities.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class BookMapper {


    @Mapper(target = "cost", source = "cost", qualifiedByName = "costprice")
    public abstract BookEntity transformBook(Book book);



}
