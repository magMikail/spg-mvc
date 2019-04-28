package udm.spg.mvc.services;

import udm.spg.mvc.domain.Customer;

import java.util.List;

/**
 * Created by magMikail on 4/27/2019.
 **/

public interface CustomerService {
    List<Customer> listAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Customer product);

    void deleteCustomer(Integer id);
}
