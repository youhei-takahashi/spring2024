package jp.ac.morijyobi.bean.entity;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publicationDate;

    public Book(int id, String title, String author, String publisher, LocalDate publicationDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
