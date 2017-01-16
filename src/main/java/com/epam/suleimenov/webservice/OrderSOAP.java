package com.epam.suleimenov.webservice;

import com.epam.suleimenov.domain.Order;
import com.epam.suleimenov.domain.OrderBook;
import com.epam.suleimenov.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import java.util.List;

@WebService
public class OrderSOAP {

    @Autowired
    private OrderService orderService;

    @PostConstruct
    public void postConstruct() {
        System.out.println("postconstruct has run.");
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public List<Order> getList() {
        return orderService.getList();
    }

    public Order update(Order order) {
        return orderService.update(order);
    }

    public void delete(Order order) {
        orderService.delete(order);
    }

    public Order findById(Integer id) {
        return orderService.findById(id);
    }

    public void save(Order order) {
        orderService.save(order);
    }

    public void saveOrderBook(OrderBook orderBook) {
        orderService.saveOrderBook(orderBook);
    }
}
