package com.epam.suleimenov.DAO;

import com.epam.suleimenov.domain.Order;
import com.epam.suleimenov.domain.OrderBook;

public interface OrderDAO extends GenericDAO<Order> {

    void saveOrderBook(OrderBook orderBook);
}
