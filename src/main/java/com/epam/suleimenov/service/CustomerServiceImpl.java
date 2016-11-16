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

    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    public boolean remove(Customer customer) {
        return customerDAO.remove(customer);
    }

    public Customer fetchById(Integer id) {
        return customerDAO.fetchById(id);
    }

    public Customer add(Customer customer) {
        logger.info("TestController Testing");
        logger.debug("TestController Testing");
        logger.warn("TestController Testing");
        logger.error("TestController Testing");

        return customerDAO.add(customer);
    }
}
