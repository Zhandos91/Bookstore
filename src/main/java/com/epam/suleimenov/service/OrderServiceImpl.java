package com.epam.suleimenov.service;

import com.epam.suleimenov.DAO.OrderDAO;
import com.epam.suleimenov.domain.Order;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    private static Logger logger = getLogger(CustomerServiceImpl.class);

    public List<Order> getList() {
        return orderDAO.getList();
    }

    public void update(Order order) {
        orderDAO.update(order);
    }

    public void delete(Order order) {
        orderDAO.delete(order);
    }

    public Order findById(Integer id) {
        return orderDAO.findById(id);
    }

    public void save(Order order) {
        orderDAO.save(order);
    }
}
