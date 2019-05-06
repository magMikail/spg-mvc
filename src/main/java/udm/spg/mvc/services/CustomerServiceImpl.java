package udm.spg.mvc.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import udm.spg.mvc.domain.Customer;

import java.util.*;

/**
 * Created by magMikail on 4/27/2019.
 **/
@Service
@Profile("map")
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }


    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("1 First Name");
        customer1.setLastName("1 Last Name");
        customer1.setEmail("1 Email");
        customer1.setPhoneNumber("1 Phone Number");
        customer1.setAddressLineOne("1 Address Line One");
        customer1.setAddressLineTwo("1 Address Line Two");
        customer1.setCity("1 City");
        customer1.setState("1 State");
        customer1.setZipCode("1 Zip Code");
        customers.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("2 First Name");
        customer2.setLastName("2 Last Name");
        customer2.setEmail("2 Email");
        customer2.setPhoneNumber("2 Phone Number");
        customer2.setAddressLineOne("2 Address Line One");
        customer2.setAddressLineTwo("2 Address Line Two");
        customer2.setCity("2 City");
        customer2.setState("2 State");
        customer2.setZipCode("2 Zip Code");
        customers.put(2, customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("3 First Name");
        customer3.setLastName("3 Last Name");
        customer3.setEmail("3 Email");
        customer3.setPhoneNumber("3 Phone Number");
        customer3.setAddressLineOne("3 Address Line One");
        customer2.setAddressLineTwo("3 Address Line Two");
        customer3.setCity("3 City");
        customer3.setState("3 State");
        customer3.setZipCode("3 Zip Code");
        customers.put(3, customer3);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null) {
                customer.setId(Collections.max(customers.keySet()) + 1);
            }
            customers.put(customer.getId(), customer);

            return customer;
        } else {
            throw new RuntimeException("Customer Can't be nill");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

}
