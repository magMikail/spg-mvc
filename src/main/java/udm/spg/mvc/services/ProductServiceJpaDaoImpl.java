package udm.spg.mvc.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import udm.spg.mvc.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by magMikail on 5/2/2019.
 **/
@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl implements ProductService {
    private EntityManagerFactory emf;

    @PersistenceUnit //jpa standart - not spring specific - inject in the Entity Manager Factory
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Product> listAllProducts() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getProductById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product savedProduct = em.merge(product);
        em.getTransaction().commit();

        return savedProduct;
    }

    @Override
    public void deleteProduct(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }
}
