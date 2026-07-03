package com.example.SpringJDBC;

import com.example.SpringJDBC.controller.BookController;
import com.example.SpringJDBC.model.Book;
import com.example.SpringJDBC.service.BookService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@RequiredArgsConstructor
public class BookControllerTest {


    private final MockMvc mockMvc;


    @Test
    public void creteBook() throws Exception {
        Book book = new Book(1L, "Book1", "Author1", LocalDateTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(book);


        mockMvc.perform(post("api/books/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(status().isCreated());
    }
}
