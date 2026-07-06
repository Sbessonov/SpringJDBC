package com.example.SpringJDBC;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.model.Book;
import com.example.SpringJDBC.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;


@JdbcTest
@Import(BookRepository.class)
@TestPropertySource(properties = "spring.sql.init.mode=always")
@Sql(scripts = "/schem-init.sql")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void creteBook() throws Exception {
        Book book = new Book(1L, "Book1", "Author1", "6544");

        Long id = bookRepository.createBook(book);
        assert(id != null && id > 0);
    }


    @Test
    public void createAndGetBook() throws Exception {
        Book book = new Book(1L, "Book1", "Author1", "6544");
        Long id = bookRepository.createBook(book);
        BookEntity DBBook = bookRepository.getBookById(id);
        assertEquals(DBBook.getAuthor(), book.getAuthor());

    }
}
