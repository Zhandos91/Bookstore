package com.epam.suleimenov.DAO;


import com.epam.suleimenov.domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerDAOImpl implements GenericDAO<Customer> {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Customer> getList() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class, "Customer.getAll");
        List<Customer> customers = criteria.list();
        session.getTransaction().commit();
        return customers;
    }

    public Customer save(Customer customer) {
        return null;
    }

    public boolean remove(Customer customer) {
        return false;
    }

    public Customer fetchById(Integer id) {
        return null;
    }

    public Customer add(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        return null;
    }
}
