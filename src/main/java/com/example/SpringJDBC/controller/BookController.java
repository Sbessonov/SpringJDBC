package com.example.SpringJDBC.controller;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.model.Book;
import com.example.SpringJDBC.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<Page<BookEntity>> getAllBooks(Pageable pageable) {
        return ResponseEntity.ok(bookService.getAllBooks(pageable));
    }

    @PostMapping("/post")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Long id = bookService.createBook(book);
        return ResponseEntity.ok().body(bookService.getBook(id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id, Book book) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
