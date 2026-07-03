package com.example.SpringJDBC.controller;

import com.example.SpringJDBC.model.Book;
import com.example.SpringJDBC.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("/post")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable Long id, Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id, Book book) {
        bookService.deleteBook(id);
    }


}
