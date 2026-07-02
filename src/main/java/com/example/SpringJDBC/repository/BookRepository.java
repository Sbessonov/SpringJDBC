package com.example.SpringJDBC.repository;

import com.example.SpringJDBC.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book getBookById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?", Book.class, id);
    }


}
