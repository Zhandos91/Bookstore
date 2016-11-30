package com.epam.suleimenov.service;

import com.epam.suleimenov.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getList();
    Customer update(Customer customer);
    void delete(Customer customer);
    Customer findById(Integer id);
    void save(Customer customer);
    Customer findCustomerByLogin(String login);
}
