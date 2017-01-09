package com.epam.suleimenov.DAO;

import com.epam.suleimenov.domain.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getList() {
        Query query = getSession().getNamedQuery("Book.getAll").setParameter("lang", LocaleContextHolder.getLocale().getLanguage());
        return query.list();
    }

    public Book update(Book book) {
        return (Book)getSession().merge(book);
    }

    public void delete(Book book) {
        getSession().delete(book);
    }

    public Book findById(Integer id) {
        Query query = getSession().getNamedQuery("Book.findById").setParameter("id", id).setParameter("lang", LocaleContextHolder.getLocale().getLanguage());
        Book book = (Book) query.uniqueResult();
        return book;
    }

    public void save(Book book) {
        getSession().save(book);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
