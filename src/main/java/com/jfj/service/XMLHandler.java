package com.jfj.service;


import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import com.jfj.bookmodel.*;

@Component
public class XMLHandler {

    public BookCatalogue readXML(InputStream is) throws JAXBException {
        // Подготавливаем необходимый набор объектов для чтения
        JAXBContext jc = JAXBContext.newInstance(BookCatalogue.class, Book.class, Cost.class);
        Unmarshaller u = jc.createUnmarshaller();

        // Считываем файл в иерархию объектов
        BookCatalogue bookCatalogue = (BookCatalogue) u.unmarshal(is);

        // Убеждаемся, что объекты есть
        System.out.println("Author:" + bookCatalogue.getBook().get(0).getAuthor());

        return bookCatalogue;
    }


}
