package com.example.SpringJDBC.service;

import com.example.SpringJDBC.mapper.BookMapper;
import com.example.SpringJDBC.model.Book;
import com.example.SpringJDBC.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    @Override
    @Transactional
    public Book createBook(Book book) {
        return bookMapper.toModel(bookRepository.createBook(book));
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

    @Override
    @Transactional
    public Book updateBook(Long id, Book book) {
        bookRepository.updateBook(id, book);
        return book;
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBook(Long id) {
        return null;
    }
}
