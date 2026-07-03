package com.example.SpringJDBC.controller;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.model.Book;
import com.example.SpringJDBC.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public Page<BookEntity> getAllBooks(Pageable pageable) {
        return bookService.getAllBooks(pageable);
    }

    @PostMapping("/post")
    public Book createBook(@RequestBody Book book) {
        Long id = bookService.createBook(book);
        return bookService.getBook(id);
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id, Book book) {
        bookService.deleteBook(id);
    }


}
