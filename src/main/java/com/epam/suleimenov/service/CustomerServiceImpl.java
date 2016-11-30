package com.epam.suleimenov.service;


import com.epam.suleimenov.DAO.CustomerDAO;
import com.epam.suleimenov.domain.Customer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    private static Logger logger = getLogger(CustomerServiceImpl.class);

    public List<Customer> getList() {
        return customerDAO.getList();
    }

    public Customer update(Customer customer) {
         return customerDAO.update(customer);
    }

    public void delete(Customer customer) {
        customerDAO.delete(customer);
    }

    public Customer findById(Integer id) {
        return customerDAO.findById(id);
    }

    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public Customer findCustomerByLogin(String login) {
        return customerDAO.getCustomerByEmail(login);
    }
}
