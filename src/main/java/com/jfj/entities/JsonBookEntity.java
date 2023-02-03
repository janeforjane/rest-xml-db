package com.jfj.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jfj.bookmodel.Cost;

import javax.xml.bind.annotation.XmlElement;

public class JsonBookEntity {

    @JsonProperty("title")
    protected String title;
    @JsonProperty("author")
    protected String author;
    @JsonProperty("date")
    protected String date;
    @JsonProperty(value = "isbn", required = true)
    protected String isbn;
    @JsonProperty(value = "publisher", defaultValue = "no name publisher")
    protected String publisher;
    @JsonProperty("cost")
    protected String cost;
    @JsonProperty("currency")
    private String currency;

    public JsonBookEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "JsonBookEntity{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", cost='" + cost + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
