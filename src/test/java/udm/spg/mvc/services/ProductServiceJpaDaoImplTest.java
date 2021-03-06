package udm.spg.mvc.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import udm.spg.mvc.config.JpaIntegrationConfig;
import udm.spg.mvc.domain.Product;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
    @DirtiesContext
    public void testListMethod() throws Exception {
        List<Product> products = productService.listAllProducts();

        assert products.size() == 5;
    }

    @Test
    @DirtiesContext
    public void testGetProductById() {
        Integer id = 1;
        Product product = productService.getProductById(id);
        assertEquals(product.getId(), id);
    }

    @Test
    @DirtiesContext
    public void testSaveOrUpdateProduct() {
        productService.saveOrUpdateProduct(new Product());
        assertEquals(productService.listAllProducts().size(), 6);
    }

    @Test
    @DirtiesContext
    public void testDeleteProduct() {
        productService.deleteProduct(1);
        assertEquals(productService.listAllProducts().size(), 4);
    }

}
