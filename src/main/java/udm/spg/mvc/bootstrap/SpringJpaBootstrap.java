package udm.spg.mvc.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import udm.spg.mvc.domain.Customer;
import udm.spg.mvc.domain.Product;
import udm.spg.mvc.services.CustomerService;
import udm.spg.mvc.services.ProductService;

import java.math.BigDecimal;

/**
 * Created by magMikail on 5/2/2019.
 **/
@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ProductService productService;
    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadCustomers();
    }

    public void loadProducts() {

        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdateProduct(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdateProduct(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdateProduct(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdateProduct(product4);

        Product product5 = new Product();
        product5.setDescription("Product 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdateProduct(product5);
    }

    private void loadCustomers() {
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
        customerService.saveOrUpdateCustomer(customer1);

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
        customerService.saveOrUpdateCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("3 First Name");
        customer3.setLastName("3 Last Name");
        customer3.setEmail("3 Email");
        customer3.setPhoneNumber("3 Phone Number");
        customer3.setAddressLineOne("3 Address Line One");
        customer3.setAddressLineTwo("3 Address Line Two");
        customer3.setCity("3 City");
        customer3.setState("3 State");
        customer3.setZipCode("3 Zip Code");
        customerService.saveOrUpdateCustomer(customer3);
    }

}
