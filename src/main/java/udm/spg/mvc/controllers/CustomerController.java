package udm.spg.mvc.controllers;

/**
 * Created by magMikail on 4/27/2019.
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import udm.spg.mvc.domain.Customer;
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

    @RequestMapping("customer/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.listAllCustomers());//?
        return "customer/list";
    }

    @RequestMapping("/customer/show/{id}")
    public String getCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/show";
    }

    @RequestMapping("/customer/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/customerform";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Customer customer) {
        Customer savedCustomer = customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customer/show/" + savedCustomer.getId();
    }

    @RequestMapping("/customer/new")
    public String newProduct(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @RequestMapping("/customer/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }
}