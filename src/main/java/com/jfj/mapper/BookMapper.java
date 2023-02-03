package com.jfj.mapper;

import com.jfj.bookmodel.Book;
import com.jfj.entities.BookDBEntity;
import com.jfj.entities.JsonBookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class BookMapper {


    @Mapping(target = "cost", source = "cost.value")
    @Mapping(target = "currency", source = "cost.currency")
    public abstract BookDBEntity transformBook(Book book);


    public abstract BookDBEntity transform(JsonBookEntity jsonBookEntity);



}
