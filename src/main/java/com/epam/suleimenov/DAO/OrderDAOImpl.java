package com.epam.suleimenov.DAO;

import com.epam.suleimenov.domain.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List getList() {
        Criteria criteria = getSession().createCriteria(Order.class);
        return criteria.list();
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
        Order order = getSession().get(Order.class, id);
        return order;
    }

    @Override
    public Order update(Order order) {
        return (Order)getSession().merge(order);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
