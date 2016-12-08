package com.epam.suleimenov.controller;

import com.epam.suleimenov.domain.*;
import com.epam.suleimenov.service.BookService;
import com.epam.suleimenov.service.CustomerService;
import com.epam.suleimenov.service.OrderService;
import com.epam.suleimenov.validator.AddressFormValidator;
import com.epam.suleimenov.validator.CustomerFormValidator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;


@Controller
@SessionAttributes({"shoppingCart", "book", "customer", "delivery_methods", "order", "orders"})
public class FrontController implements MessageSourceAware {

    @Autowired
    CustomerService customerService;

    @Autowired
    BookService bookService;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerFormValidator customerFormValidator;

    @Autowired
    AddressFormValidator addressFormValidator;


    private MessageSource messageSource;

    @InitBinder("customer")
    public void initCustomerBinder(WebDataBinder binder) {
        binder.setValidator(customerFormValidator);
//        binder.addValidators(customerFormValidator, addressFormValidator );

    }

    @InitBinder("address")
    public void initAddressBinder(WebDataBinder binder) {
        binder.setValidator(addressFormValidator);
//        binder.addValidators(customerFormValidator, addressFormValidator );

    }

    private List<Delivery>  delivery_methods = new ArrayList<>();

    private Map<Book, Integer> shoppingCart = new HashMap<>();

    private static Logger logger = getLogger(FrontController.class);





    {
        logger.info("Initializing delivery method");
        Delivery delivery = new Delivery();
        delivery.setType("Next Day Air");
        delivery.setEstimated_time("1-2 business days");
        delivery.setCost(8.0);
        delivery_methods.add(delivery);

        delivery = new Delivery();
        delivery.setType("Second Day Air");
        delivery.setEstimated_time("2-3 business days");
        delivery.setCost(6.0);
        delivery_methods.add(delivery);

        delivery = new Delivery();
        delivery.setType("Priority Mail");
        delivery.setEstimated_time("3-4 business days");
        delivery.setCost(4.0);
        delivery_methods.add(delivery);

        delivery = new Delivery();
        delivery.setType("Standard Ground Delivery");
        delivery.setEstimated_time("4-8 business days");
        delivery.setCost(2.0);
        delivery_methods.add(delivery);

    }


    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/listBooks")
    public String home(Model model) {
        logger.info("Listing Books");
        List<Book> bookList = bookService.getList();
        for(Book mybook: bookList)
            logger.info("Showing book {}", mybook);


        model.addAttribute("bookList", bookList);
//        List<Order> orders = orderService.getList();
//        List<Order> orders = customer.getOrders();
//        model.addAttribute("orders", orders);
        return "listBooks";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("customer", new Customer());

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute(value = "customer") Customer existing_customer, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(existing_customer == null || existing_customer.getEmail().equals("") || existing_customer.getPassword().equals("")) {
            String message = messageSource.getMessage("loginForm.error", null, LocaleContextHolder.getLocale());

            return "login";
        }
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

    @RequestMapping(value = "/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String registrationForm(Model model) {

        Customer customer = new Customer();
        logger.info("Signing up a new customer");
        model.addAttribute("customer", customer);
//        model.addAttribute("address", new Address());

        return "customerForm";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registrationFormSubmit( @Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        logger.info("Customer {}", customer);

        if(bindingResult.hasErrors()) {
            return "customerForm";
        }



        customer.setOrders(new ArrayList<Order>());
        customer.setAddresses(new ArrayList<Address>());
        customerService.save(customer);
        logger.info("CustomerId" + customer.getId());
        logger.info("{}" + customer);
        redirectAttributes.addFlashAttribute("customer", customer);
        return "redirect:/addAddress";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.GET)
    public String addAddress(Model model) {
        logger.info("Adding address");
        model.addAttribute("address", new Address());
        return "addressForm";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addAddress(@Valid @ModelAttribute Address address, @ModelAttribute Customer customer, BindingResult bindingResult) {

        logger.info("Adding address {}", address);
        if(bindingResult.hasErrors())
            return "addressForm";
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


    @RequestMapping(value = "/shipping", method = RequestMethod.GET)
    public String showShippingOption(Model model){

        Delivery delivery = new Delivery();
        logger.info("Showing shipping choice {}", delivery);
        model.addAttribute("delivery", delivery);
        model.addAttribute("delivery_methods", delivery_methods);
        return "shipping";
    }

    @RequestMapping(value = "/shipping", method = RequestMethod.POST)
    public String submitShippingInfo(@ModelAttribute Delivery delivery, Model model, BindingResult bindingResult) {

       for(Delivery myDelivery: delivery_methods) {
           if(myDelivery.getType().equals(delivery.getType())) {
               logger.info("Submitting before Shipping {}", delivery);
               delivery.setEstimated_time(myDelivery.getEstimated_time());
               delivery.setCost(myDelivery.getCost());
               logger.info("Submitting after Shipping {}", delivery);
           }

       }
        logger.info("Submitting Shipping {}", delivery);
        model.addAttribute(delivery);

        Order order = new Order();
        order.setOrdered_date(new Date());
        order.setTracking_num((int)Math.round(Math.random() * 55555));
        double total_price = 0;
        int quantity = 0;

//        List<Book> bookList = new ArrayList<>();

        for(Map.Entry<Book, Integer> entry : shoppingCart.entrySet()) {
            total_price = total_price + entry.getKey().getPrice() * entry.getValue();
            quantity = quantity + entry.getValue();
//            bookList.add(entry.getKey());
           }
//        order.setBooks(bookList);
        total_price = total_price + quantity*delivery.getCost()/2;
        total_price = total_price + delivery.getCost();
        order.setQuantities(quantity);
        order.setTotal_price(total_price);
        order.setPayment_method("online");
        order.setDelivery(delivery);
        model.addAttribute("order", order);
        return "orderInfo";
    }


    @RequestMapping(value = "/submitOrder")
    public String submitOrder(@ModelAttribute Order order, @ModelAttribute Customer customer, Model model,BindingResult bindingResult) {


        order.setStatuses(new ArrayList<Status>());
        order.setHistories(new ArrayList<History>());
        Status status = new Status();
        status.setInfo("ordered");
        order.getStatuses().add(status);


        logger.info("Delivery {}", order.getDelivery());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date expected_delivery = calendar.getTime();
        order.setExpected_delivery(expected_delivery);

        if(customer.getOrders() == null)
            customer.setOrders(new ArrayList<Order>());

        customer.getOrders().add(order);

      customerService.update(customer);

       Set<OrderBook> orderBooks = new HashSet<>();
        for(Map.Entry<Book, Integer> entry : shoppingCart.entrySet()) {
            OrderBook orderBook = new OrderBook();
            orderBook.setQuantity(entry.getValue());
            orderBook.setBook(entry.getKey());
            orderBook.setOrder(order);
            orderBooks.add(orderBook);
            orderService.saveOrderBook(orderBook);
        }
        order.setOrderBooks(orderBooks);

        for(Map.Entry<Book, Integer> entry : shoppingCart.entrySet()) {
            entry.getKey().setOrderBooks(orderBooks);
        }


        Customer saved_customer = customerService.update(customer);

        List<Order> orders = saved_customer.getOrders();

        orderService.update(order);
        model.addAttribute("orders", orders);
        logger.info("Submitting order {}", order);
        model.addAttribute("order", order);


        shoppingCart.clear();
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("customer", saved_customer);
        return "orderSuccess";
    }

    @RequestMapping(value = "/orderStatus")
    public String showOrderStatus(@ModelAttribute Customer customer, Model model) {
        List<Order> orders = customer.getOrders();
        model.addAttribute("orders", orders);
        for(Order order: orders) {
            logger.info("Listing order {}", order);
            for(OrderBook myorder: order.getOrderBooks() )
                logger.info("MYBOOK {}", myorder.getBook());
        }

        return "orderStatus";
    }

    @RequestMapping(value = "/showShoppingCart", method = RequestMethod.GET)
    public String showShoppingCart() {

        return "shoppingCart";
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
