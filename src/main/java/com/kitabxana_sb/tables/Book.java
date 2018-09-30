package com.kitabxana_sb.tables;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    private int idbook;
    private String title;
    private String author;
    private String title2;
    private String author2;
    private Book book;

    public Book() {
    }

    public Book(int idbook, String title, String author) {
        this.idbook = idbook;
        this.title = title;
        this.author = author;
    }

    public int getIdbook() {
        return this.idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle2() {
        return this.title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getAuthor2() {
        return this.author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
