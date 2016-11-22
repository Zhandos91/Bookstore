package com.epam.suleimenov.DAO;


import com.epam.suleimenov.domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    public void update(Customer customer) {
        getSession().update(customer);
    }

    public void delete(Customer customer) {
        getSession().delete(customer);
    }

    public Customer findById(Integer id) {
        Customer customer = getSession().get(Customer.class, id);
        return customer;
    }

    public void save(Customer customer) {
        getSession().save(customer);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Query query = getSession().getNamedQuery("Customer.getByEmail").setParameter("email", email);
        Customer customer = (Customer) query.uniqueResult();
        return customer;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
