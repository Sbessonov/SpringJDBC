package com.example.SpringJDBC.mapper;

import com.example.SpringJDBC.entity.BookEntity;
import com.example.SpringJDBC.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    public BookEntity toEntity(Book nodel);
    public Book toModel(BookEntity entity);
}
