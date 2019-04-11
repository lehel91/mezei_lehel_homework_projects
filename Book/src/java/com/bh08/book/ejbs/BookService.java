package com.bh08.book.ejbs;

import com.bh08.book.entities.BookType;

public interface BookService {

    boolean saveAuthor(String id, String name, String password);

//    Long saveBook(Long id, String title, BookType bookType);
}
