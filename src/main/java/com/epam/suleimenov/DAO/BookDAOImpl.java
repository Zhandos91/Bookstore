package com.epam.suleimenov.DAO;

import com.epam.suleimenov.domain.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getList() {
        Criteria criteria = getSession().createCriteria(Book.class);
        return criteria.list();
    }

    public Book update(Book book) {
        return (Book)getSession().merge(book);
    }

    public void delete(Book book) {
        getSession().delete(book);
    }

    public Book findById(Integer id) {
        Book book = getSession().get(Book.class, id);
        return book;
    }

    public void save(Book book) {
        getSession().save(book);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
