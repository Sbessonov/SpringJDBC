package com.example.SpringJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime publishingYear;
}
