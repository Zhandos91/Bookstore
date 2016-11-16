package com.epam.suleimenov.service;

import com.epam.suleimenov.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getList();
    Customer save(Customer customer);
    boolean remove(Customer customer);
    Customer fetchById(Integer id);
    Customer add(Customer customer);

}
