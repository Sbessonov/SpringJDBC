package com.example.SpringJDBC.repository;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public BookEntity getBookById(Long id) {
        String query = "SELECT * FROM book WHERE id = ?";

        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?", BookEntity.class, id);
    }

    public BookEntity createBook(Book book) {
        String query = "INSERT INTO book (title, author, publishing_year) VALUES (?, ?)";
        return jdbcTemplate.queryForObject(
                query,
                BookEntity.class,
                book.getTitle(), book.getAuthor(), book.getPublishingYear());
    }

    public void deleteBook(Long id) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

    public BookEntity updateBook(Long id, Book book) {
        return jdbcTemplate.queryForObject("UPDATE book SET title = ?, author = ?, publishing_year = ? WHERE id = ?",
                BookEntity.class,
                book.getTitle(), book.getAuthor(), book.getPublishingYear(), id);
    }

}
