package com.epam.suleimenov.DAO;


import com.epam.suleimenov.domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Customer> getList() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        return criteria.list();
    }

    public Customer save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
        return customer;
    }

    public boolean remove(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Customer removing_customer = fetchById(customer.getId());
        session.delete(removing_customer);
        return true;
    }

    public Customer fetchById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.get(Customer.class, id);
        return customer;
    }

    public Customer add(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
        return customer;
    }
}
