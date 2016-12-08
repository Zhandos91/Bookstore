package com.epam.suleimenov.service;

import com.epam.suleimenov.domain.Order;
import com.epam.suleimenov.domain.OrderBook;

import java.util.List;

public interface OrderService {

    List<Order> getList();
    Order update(Order order);
    void delete(Order order);
    Order findById(Integer id);
    void save(Order order);
    void saveOrderBook(OrderBook orderBook);
}
