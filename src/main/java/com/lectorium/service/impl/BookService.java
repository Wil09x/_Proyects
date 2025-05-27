package com.lectorium.service.impl;
import com.lectorium.model.Book;
import com.lectorium.repo.IBookRepo;
import com.lectorium.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final IBookRepo bookRepository;

    @Autowired
    public BookService(IBookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}