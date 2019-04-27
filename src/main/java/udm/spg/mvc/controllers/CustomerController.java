package udm.spg.mvc.controllers;

/**
 * Created by magMikail on 4/27/2019.
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import udm.spg.mvc.services.CustomerService;

/**
 * Create a Customer model object. The object will have
 * first name,
 * last name,
 * email,
 * phone number,
 * address line one,
 * address line two,
 * city,
 * state,
 * zip code.
 * All properties are strings. All should be private and have getters and setters.
 * <p>
 * Add an id value to your customer object. The Id should be an Integer and have a getter and setter.
 * <p>
 * <p>
 * Create a Customer Service. Use an interface, Create an implementation like we did for the Product object.
 * <p>
 * <p>
 * <p>
 * Create a controller. Implement the ability to list, show one customer, add a customer, update a customer, and delete a customer by id.
 * <p>
 * Create the corresponding Thymeleaf templates.
 * <p>
 * At the end of this module you should have a working web application which will allow you to do CRUD operations on a customer object.
 */
@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customer")
    public String listProducts(Model model) {

        model.addAttribute("products", customerService.listAllCustomers());

        return "customers";
    }
}