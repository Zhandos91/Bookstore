package com.epam.suleimenov.service;

import com.epam.suleimenov.domain.Customer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    CustomerService customerService;
    @Autowired
    DeliveryService deliveryService;

    private static Logger logger = getLogger(TestController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {

        logger.info("TestController Testing");
        model.addAttribute("test", "testing model viewer");
        model.addAttribute(new Customer());

//        model.addObject
//        Delivery delivery = new Delivery();
//        delivery.setCost(3.22);
//        delivery.setEstimated_time("Within 6-8 business days");
//        delivery.setType("air shipping");
//        deliveryService.addDelivery(delivery);
//        model.addAttribute("delivery", delivery);
//
//        logger.debug("customer", customer);
//        logger.info("customer", customer);
//
//        List<Customer> customerList = customerService.getList();
//        ModelAndView model = new ModelAndView("test");
//        model.addObject("customerList", customerList);
        return "customerForm";
    }
}
