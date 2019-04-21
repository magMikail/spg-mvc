package udm.spg.mvc.services;

import udm.spg.mvc.domain.Product;

import java.util.List;

/**
 * Created by Mikhail Mahutsiy on 4/21/2019.
 **/

public interface ProductService {
    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);
}
