package com.example.SpringJDBC.repository;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.model.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<BookEntity> getBooks(int page, int size) {
        int offset = page * size;

        String query = "SELECT * FROM book ORDER BY id LIMIT ? OFFSET ?";
        List<BookEntity> books = jdbcTemplate.query(
                query, new BeanPropertyRowMapper<>(BookEntity.class),
                size, offset

        );

        String countQuery = "SELECT COUNT(*) FROM book";
        int total = jdbcTemplate.queryForObject(countQuery, Integer.class);

        return new PageImpl<>(books, PageRequest.of(page, size), total);
    }


    public BookEntity getBookById(Long id) {
        String query = "SELECT * FROM book WHERE id = ?";
        RowMapper<BookEntity> mapper = (rs, rowNum) -> {
            BookEntity book = new BookEntity();
            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPublishingYear(rs.getString("publishing_year"));
            return book;
        };
        try {
            return jdbcTemplate.queryForObject(query, mapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException();
        }

    }

    public Long createBook(Book book) {
        String query = "INSERT INTO book (title, author, publishing_year) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublishingYear());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId == null) {
            throw new RuntimeException("Не удалось получить сгенерированный ID");
        }

        return generatedId.longValue();
    }

    public void deleteBook(Long id) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

    public void updateBook(Long id, Book book) {
        String query = "UPDATE book SET title = ?, author = ?, publishing_year = ? WHERE id = ?";
        jdbcTemplate.update(query, book.getTitle(), book.getAuthor(), book.getPublishingYear(), id);
    }

}
