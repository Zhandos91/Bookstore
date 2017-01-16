package com.epam.suleimenov.webservice;


import com.epam.suleimenov.domain.Customer;
import com.epam.suleimenov.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import java.util.List;

@WebService
public class CustomerSOAP {

    @Autowired
    private CustomerService customerService;

    @PostConstruct
    public void postConstruct() {
        System.out.println("postconstruct has run.");
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public List<Customer> getList() {
        return customerService.getList();
    }

    public Customer update(Customer customer) {
        return customerService.update(customer);
    }

    public void delete(Customer customer) {
        customerService.delete(customer);
    }

    public Customer findById(Integer id) {
        return customerService.findById(id);
    }

    public void save(Customer customer) {
        customerService.save(customer);
    }

    public Customer findCustomerByLogin(String login) {
        return customerService.findCustomerByLogin(login);
    }
}
