package udm.spg.mvc.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import udm.spg.mvc.config.JpaIntegrationConfig;
import udm.spg.mvc.domain.Customer;
import udm.spg.mvc.domain.Product;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by magMikail on 5/7/2019.
 **/

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(JpaIntegrationConfig.class) //deprecated
@ContextConfiguration(classes = JpaIntegrationConfig.class)
@ActiveProfiles({"jpadao"})
public class CustomerServiceJpaDaoImplTest {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    @DirtiesContext
    public void testListMethod() throws Exception {
        List<Customer> customers = customerService.listAllCustomers();
        assert customers.size() == 3;
    }

    @Test
    @DirtiesContext
    public void testGetCustomerById() {
        Integer id = 1;
        Customer customer = customerService.getCustomerById(id);
        assertEquals(customer.getId(), id);
    }

    @Test
    @DirtiesContext
    public void testSaveOrUpdateCustomer() {
        customerService.saveOrUpdateCustomer(new Customer());
        assertEquals(customerService.listAllCustomers().size(), 4);
    }

    @Test
    @DirtiesContext
    public void testDeleteCustomer() {
        customerService.deleteCustomer(1);
        assertEquals(customerService.listAllCustomers().size(), 2);
    }

}
