package com.epam.suleimenov.controller;

import com.epam.suleimenov.domain.Address;
import com.epam.suleimenov.domain.Book;
import com.epam.suleimenov.domain.Customer;
import com.epam.suleimenov.service.BookService;
import com.epam.suleimenov.service.CustomerService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class TestController {

    @Autowired
    CustomerService customerService;

    @Autowired
    BookService bookService;

    private static Logger logger = getLogger(TestController.class);

    @RequestMapping(value = "/listBooks")
    public String home(Model model) {
        logger.info("Listing Books");
        List<Book> bookList = bookService.getList();
        model.addAttribute("bookList", bookList);
        model.addAttribute("hello", "hi to all");
        return "listBooks";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String registrationForm(Model model) {

        logger.info("TestController Testing");
        model.addAttribute("test", "testing model viewer");
        model.addAttribute("customer", new Customer());
        model.addAttribute("address", new Address());

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

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String registrationFormSubmit(@ModelAttribute Customer customer, BindingResult bindingResult, SessionStatus sessionStatus) {
        logger.info("Customer {}", customer);
        customerService.save(customer);
        logger.info("CustomerId" + customer.getId());


        return "test";
    }


    @RequestMapping(value = "/jandos")
    public String test(Model model) {
        logger.info("In testing");
        Customer customer = new Customer();
//        customer.setEmail("sad@epam.com");
//        customer.setFirst_name("lian");
//        customer.setLast_name("li");
//        customer.setPassword("ddd");
//        customer.setPhone(3444);
//        Address address = new Address();
//        address.setCity("LA");
//        address.setState("CA");
//        address.setCountry("USA");
//        address.setZip_code(588);
//        List<Address> addresses = new ArrayList<>();
//        addresses.add(address);
//        customer.setAddresses(addresses);
        customer = customerService.findById(26);
        List<Address> addresses = customer.getAddresses();
        Address address = new Address();
        address.setState("IN");
        address.setCountry("USA");
        address.setCity("WL");
        address.setZip_code(333);
        addresses.add(address);
        customerService.update(customer);

        logger.info("Customer {}", customer);

        return "test";
    }

    @RequestMapping(value = "/addDefaultBooks")
    public String addDefaultBooks() {
        Book book = new Book();
        book.setTitle("Stories of the Game");
        book.setAuthor("Wayne Gretzky");
        book.setPublisher("LOST");
        book.setReleased_date(new Date());
        book.setPrice(15.33);
        book.setISBN(34323);
        book.setPages(577);
        book.setDescription("For the first time, Wayne Gretzky discusses candidly what the game" +
                " looks like to him and introduces us to the people who inspired and motivated " +
                "him: mentors, teammates, rivals, the famous and the lesser known. Weaving together" +
                " lives and moments from an extraordinary career, he reflects on the players who" +
                " inflamed his imagination when he was a kid, the way he himself figured in the" +
                " dreams of so many who came after; takes us onto the ice and into the dressing" +
                " rooms to meet the friends who stood by him and the rivals who spurred him to " +
                "greater heights; shows us some of the famous moments in hockey history through " +
                "the eyes of someone who regularly made that history.");
        book.setBrief("The Great One weaves memories of his legendary career with an inside look" +
                " at the sport of professional hockey, and the heroes and stories that inspired him.");
        bookService.save(book);

        book = new Book();
        book.setTitle("The Pope of Physics");
        book.setAuthor("Gino Segre");
        book.setPublisher("GERONIMO");
        book.setReleased_date(new Date());
        book.setPrice(16.33);
        book.setISBN(4533);
        book.setPages(666);
        book.setBrief("Enrico Fermi is unquestionably among the greats of the world's physicists," +
                " the most famous Italian scientist since Galileo. Called the Pope by his peers, " +
                "he was regarded as infallible in his instincts and research. His discoveries" +
                " changed our world; they led to weapons of mass destruction and conversely to" +
                " life-saving medical interventions. His rich legacy encompasses key advances " +
                "in fields as diverse as comic rays, nuclear technology, and early computers.");

        book.setDescription("Enrico Fermi is unquestionably among the greats of the world's physicists, " +
                "the most famous Italian scientist since Galileo. Called the Pope by his peers, he was " +
                "regarded as infallible in his instincts and research. His discoveries changed our world;" +
                " they led to weapons of mass destruction and conversely to life-saving medical " +
                "interventions. His rich legacy encompasses key advances in fields as diverse as" +
                " comic rays, nuclear technology, and early computers.\n" +
                "In their revealing book, The Pope of Physics, Gino Segre and Bettina " +
                "Hoerlin bring this scientific visionary to life. An examination of the human " +
                "dramas that touched Fermi's life as well as a thrilling history of scientific " +
                "innovation in the twentieth century, this is the comprehensive biography that" +
                " Fermi deserves.");
        bookService.save(book);
        return "test";
    }
}
