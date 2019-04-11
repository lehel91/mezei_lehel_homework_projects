package com.bh08.book.ejbs;

import java.util.List;

public interface AuthorService {

    void loginAuthor(String id, String password);
    
    Long saveBook(BookDTO bookDTO);
    
    List<BookDTO> listAllBooks();
}
