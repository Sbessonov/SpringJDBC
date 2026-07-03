package com.example.SpringJDBC.service;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Page<BookEntity> getAllBooks(Pageable pageable);

     Long createBook(Book book);

     void deleteBook(Long id);

     Book updateBook(Long id, Book book);

     Book getBook(Long id);
}
