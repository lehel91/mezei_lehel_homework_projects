package com.mycompany.library.model;

import java.io.Serializable;

public class Book implements Serializable {

    private int book_id;
    private String isbn = "";
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, int book_id, String isbn, String author) {
        this(title, author);
        this.book_id = book_id;
        this.isbn = isbn;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        if (isbn.isEmpty()) {
            return title + ", " + author;
        } else {
            return title + ", " + author + ", book_id = " + book_id + ", isbn = " + isbn + "\n";
        }
    }
}
