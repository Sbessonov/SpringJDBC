package com.example.SpringJDBC.service;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.mapper.BookMapper;
import com.example.SpringJDBC.model.Book;
import com.example.SpringJDBC.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    @Override
    public Page<BookEntity> getAllBooks(Pageable pageable) {
        return bookRepository.getBooks(pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    @Transactional
    public Long createBook(Book book) {
        return bookRepository.createBook(book);
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
        return getBook(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBook(Long id) {
        return bookMapper.toModel(bookRepository.getBookById(id));
    }
}
