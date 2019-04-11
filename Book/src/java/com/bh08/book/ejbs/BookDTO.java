package com.bh08.book.ejbs;

import com.bh08.book.entities.BookType;
import java.io.Serializable;
import java.util.Objects;

public class BookDTO implements Serializable {

    private Long id;

    private String title;

    private BookType bookType;

    private String authorId;

    public BookDTO(String title, BookType bookType, String authorId) {
        this.title = title;
        this.bookType = bookType;
        this.authorId = authorId;
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

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.bookType);
        hash = 29 * hash + Objects.hashCode(this.authorId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookDTO other = (BookDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "id=" + id + ", title=" + title + ", bookType=" + bookType + ", authorId=" + authorId + '}';
    }
    
    
}
