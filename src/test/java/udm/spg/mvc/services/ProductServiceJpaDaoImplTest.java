package udm.spg.mvc.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import udm.spg.mvc.config.JpaIntegrationConfig;
import udm.spg.mvc.domain.Product;

import java.util.List;

/**
 * Created by magMikail on 5/4/2019.
 **/
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(JpaIntegrationConfig.class) //deprecated
@ContextConfiguration(classes = JpaIntegrationConfig.class)
@ActiveProfiles({"jpadao"})
public class ProductServiceJpaDaoImplTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testListMethod() throws Exception {
        List<Product> products = productService.listAllProducts();

        assert products.size() == 5;
    }


}
