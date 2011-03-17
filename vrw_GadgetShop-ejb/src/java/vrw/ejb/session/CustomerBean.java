/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vrw.ejb.session;

import javax.ejb.*;
import javax.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import vrw.ejb.entity.*;
import java.util.Collection;

/**
 *
 * @author Robbie McFarlane, Will Atterson, Viktor Peacock
 */
@Stateless
@Local(CustomerLocal.class)
public class CustomerBean implements CustomerLocal, Serializable {

    @PersistenceContext
    private EntityManager em;

    public Collection<Customer> findAll() {
        return em.createQuery("SELECT c FROM Customer c").getResultList();
    }

    public Customer find(String nickname) {
        return em.find(Customer.class, nickname);
    }

    public void register(Customer c) {
        em.persist(c);
    }

    public void update(Customer c) {
        em.persist(c);        
    }

    public void remove(Customer c) {
        c.setActive(false);
        em.persist(c);
    }
}
