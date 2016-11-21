package com.epam.suleimenov.service;

import com.epam.suleimenov.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> getList();
    void update(Order order);
    void delete(Order order);
    Order findById(Integer id);
    void save(Order order);
}
