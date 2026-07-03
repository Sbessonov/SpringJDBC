package com.example.SpringJDBC.service;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.model.Book;

public interface BookService {

    public Book createBook(Book book);

    public void deleteBook(Long id);

    public Book updateBook(Long id, Book book);

    public Book getBook(Long id);
}
