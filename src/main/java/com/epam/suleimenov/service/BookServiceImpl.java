package com.epam.suleimenov.service;

import com.epam.suleimenov.DAO.BookDAO;
import com.epam.suleimenov.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Autowired
    BookDAO bookDAO;

    @Override
    public List<Book> getList() {
        return bookDAO.getList();
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public void delete(Book book) {
        bookDAO.delete(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookDAO.findById(id);
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }
}
