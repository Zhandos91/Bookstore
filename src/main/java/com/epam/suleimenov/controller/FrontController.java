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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@SessionAttributes({"shoppingCart", "book", "customer", "bookList"})
public class FrontController {

    @Autowired
    CustomerService customerService;

    @Autowired
    BookService bookService;

    private Map<Book, Integer> shoppingCart = new HashMap<>();

    private static Logger logger = getLogger(FrontController.class);

    @RequestMapping(value = "/listBooks")
    public String home(Model model) {
        logger.info("Listing Books");
        List<Book> bookList = bookService.getList();
        model.addAttribute("bookList", bookList);
        return "listBooks";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("customer", new Customer());

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute(value = "customer") Customer existing_customer, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(existing_customer == null || existing_customer.getEmail().equals("") || existing_customer.getPassword().equals(""))
            return "login";
        Customer  customer = customerService.findCustomerByLogin(existing_customer.getEmail());
        logger.info("Found {}", customer);
        if(customer == null)
            return "login";

        if(customer.getPassword().equals(existing_customer.getPassword())) {
            redirectAttributes.addFlashAttribute("customer", customer);
            return "redirect:/listBooks";
        }
        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String registrationForm(Model model) {

        Customer customer = new Customer();
        logger.info("Signing up a new customer");
        model.addAttribute("customer", customer);
        model.addAttribute("address", new Address());

        return "customerForm";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registrationFormSubmit(@ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        logger.info("Customer {}", customer);
        customer.setAddresses(new ArrayList<Address>());
        customerService.save(customer);
        logger.info("CustomerId" + customer.getId());
        logger.info("{}" + customer);
        redirectAttributes.addFlashAttribute("customer", customer);
        return "redirect:/addAddress";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.GET)
    public String addAddress(Model model) {
        model.addAttribute("address", new Address());
        return "addressForm";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute Address address, @ModelAttribute Customer customer, BindingResult bindingResult) {

        logger.info("Adding address {}", address);
        logger.info("Adding address to a customer {}", customer);

        List<Address> addresses = customer.getAddresses();
        addresses.add(address);
        customerService.update(customer);

        return "redirect:/listBooks";
    }

    @RequestMapping(value = "/{book_id}", method = RequestMethod.GET)
    public String showBook(@PathVariable("book_id") Integer id, Model model ) {
        Book book = bookService.findById(id);
//           for(Map.Entry<Book, Integer> entry : shoppingCart.entrySet()) {
//
//           }

        logger.info("Showing {}", book);
        model.addAttribute("book", book);

        return "showBook";
    }

    @RequestMapping(value = "/remove/{book_id}", method = RequestMethod.GET)
    public String removeBookFromCart(@PathVariable("book_id") Integer id, Model model) {
        Book book = bookService.findById(id);
        logger.info("Removing the book from the cart");
        shoppingCart.remove(book);
        return "shoppingCart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute Book book, Model model, BindingResult bindingResult) {

        logger.info("Adding book to the shopping cart");
        if(shoppingCart.containsKey(book)) {
            logger.info("Book already exists {}", book);
            Integer quantity = shoppingCart.get(book);
            shoppingCart.put(book, quantity + 1);
        }
        else {
            shoppingCart.put(book, 1);
        }
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart";
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
