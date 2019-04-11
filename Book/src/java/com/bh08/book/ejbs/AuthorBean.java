package com.bh08.book.ejbs;

import com.bh08.book.entities.Author;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
//@LocalBean
@Remote(AuthorService.class)
public class AuthorBean implements AuthorService {

    private String id;

    @PersistenceContext
    private EntityManager em;

    @EJB
    private BookBean bookBean;
    
    private List<BookDTO> bookList;

    @Override
    public void loginAuthor(String id, String password) {
        Author author = em.find(Author.class, id);
        if (null == author) {
            throw new EJBException("Nem talalhato...");
        }

        if (author.getPassword().equals(password)) {
            this.id = id;
        } else {
            throw new EJBException("Rossz jelszo");
        }
        bookList = new ArrayList<>();
    }

    @Override
    public Long saveBook(BookDTO bookDTO) {
        if (null == this.id) {
            throw new EJBException("Valami gubanc van");
        }
        Long bookId = bookBean.saveBook(bookDTO.getTitle(), bookDTO.getBookType(), em.find(Author.class, this.id));
        if (null == bookId) {
            throw new EJBException("Sikertelen mentes");
        }
        bookDTO.setId(bookId);
        bookList.add(bookDTO);
        return bookId;
    }

    @Remove
    @Override
    public List<BookDTO> listAllBooks() {
        return bookList;
    }

}
