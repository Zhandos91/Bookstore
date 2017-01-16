package com.epam.suleimenov.webservice;

import com.epam.suleimenov.domain.Book;
import com.epam.suleimenov.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import java.util.List;

@WebService
public class BookSOAP {

    @Autowired
    BookService bookService;

    @PostConstruct
    public void postConstruct() {
        System.out.println("postconstruct has run.");
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    }

    public List<Book> getList() {
        return bookService.getList();
    }

    public Book update(Book book) {
        return bookService.update(book);
    }

    public void delete(Book book) {
        bookService.delete(book);
    }

    public Book findById(Integer id) {
        return bookService.findById(id);
    }

    public void save(Book book) {
        bookService.save(book);
    }
}
