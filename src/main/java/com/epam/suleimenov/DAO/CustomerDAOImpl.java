package com.epam.suleimenov.DAO;


import com.epam.suleimenov.domain.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getList() {
        Query query = getSession().getNamedQuery("Customer.getAll").setParameter("lang", LocaleContextHolder.getLocale().getLanguage());
        return query.list();
    }

    public Customer update(Customer customer) {
//        Customer customer = findById(customer1.getId());
//        Customer updated = (Customer) getSession().merge(customer);

        getSession().saveOrUpdate(customer);
        return customer;
    }

    public void delete(Customer customer) {
        getSession().delete(customer);
    }

    public Customer findById(Integer id) {
        Query query = getSession().getNamedQuery("Customer.fetchById").setParameter("id", id).setParameter("lang", LocaleContextHolder.getLocale().getLanguage());
        Customer customer = (Customer) query.uniqueResult();
        return customer;
    }

    public void save(Customer customer) {
        getSession().persist(customer);
//        getSession().evict(customer);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Query query = getSession().getNamedQuery("Customer.getByEmail").setParameter("email", email).setParameter("lang", LocaleContextHolder.getLocale().getLanguage());
        Customer customer = (Customer) query.uniqueResult();
        return customer;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
