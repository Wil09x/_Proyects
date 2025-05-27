package com.lectorium.service;

import com.lectorium.model.Book;
import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book save(Book book);
    Book getById(Long id);
    void delete(Long id);
}