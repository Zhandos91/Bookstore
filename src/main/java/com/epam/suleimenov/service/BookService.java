package com.epam.suleimenov.service;


import com.epam.suleimenov.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getList();
    Book update(Book book);
    void delete(Book book);
    Book findById(Integer id);
    void save(Book book);
}
