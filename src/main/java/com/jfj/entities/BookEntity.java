package com.jfj.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class BookEntity {
    @Id
//    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String author;
    @Column(name = "year_date")
    private short date;
    private String isbn;
    private String publisher;
    private int cost;
    private String currency;

    public BookEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public short getDate() {
        return date;
    }

    public void setDate(short date) {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BookEntity(String title, String author, short date, String isbn, String publisher, int cost, String currency) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.isbn = isbn;
        this.publisher = publisher;
        this.cost = cost;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (date != that.date) return false;
        if (cost != that.cost) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;
        return currency != null ? currency.equals(that.currency) : that.currency == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (int) date;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
