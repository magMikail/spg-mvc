package udm.spg.mvc.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import udm.spg.mvc.domain.Customer;
import udm.spg.mvc.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by magMikail on 5/7/2019.
 **/
@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl implements CustomerService {
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Customer> listAllCustomers() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Customer savedCustomer = em.merge(customer);
        em.getTransaction().commit();

        return savedCustomer;
    }

    @Override
    public void deleteCustomer(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
    }

}
