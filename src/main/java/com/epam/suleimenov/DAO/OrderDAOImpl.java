package com.epam.suleimenov.DAO;

import com.epam.suleimenov.domain.Order;
import com.epam.suleimenov.domain.OrderBook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getList() {
        Query query = getSession().getNamedQuery("Order.getAll").setParameter("lang", LocaleContextHolder.getLocale().getLanguage());
        return query.list();
    }

    @Override
    public void save(Order order) {
        getSession().save(order);
    }

    @Override
    public void delete(Order order) {
        getSession().delete(order);
    }

    @Override
    public Order findById(Integer id) {
        Query query = getSession().getNamedQuery("Order.findById").setParameter("id", id).setParameter("lang", LocaleContextHolder.getLocale().getLanguage());
        Order order = (Order) query.uniqueResult();
        return order;
    }

    @Override
    public Order update(Order order) {
        return (Order)getSession().merge(order);
    }

    @Override
    public void saveOrderBook(OrderBook orderBook) {
        getSession().save(orderBook);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
