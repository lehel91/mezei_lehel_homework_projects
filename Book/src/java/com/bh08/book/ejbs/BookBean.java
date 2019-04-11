package com.bh08.book.ejbs;

import com.bh08.book.entities.Author;
import com.bh08.book.entities.Book;
import com.bh08.book.entities.BookType;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@Remote(BookService.class)
public class BookBean implements BookService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean saveAuthor(String id, String name, String password) {
        Author author = new Author();
        author.setId(id);
        author.setName(name);
        author.setPassword(password);
        em.persist(author);

        return true;
    }

//    @Override
    public Long saveBook(String title, BookType bookType, Author author) {
        Book book = new Book();
        book.setTitle(title);
        book.setBookType(bookType);
        book.setAuthor(author);
        em.persist(book);

        return book.getId();
    }

}
