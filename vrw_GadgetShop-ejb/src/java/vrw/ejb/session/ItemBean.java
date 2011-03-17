
package vrw.ejb.session;

import java.io.Serializable;
import java.util.Collection;

import javax.ejb.*;

import javax.persistence.*;

import vrw.ejb.entity.Item;

@Stateless
@Local(ItemLocal.class)
public class ItemBean implements ItemLocal, Serializable  {
    
    @PersistenceContext
    private EntityManager em;
    
    public void add(Item item)
    {
        em.persist(item);
    }

    public Item find(int id)
    {
        return em.find(Item.class, id);
    }

    public Collection<Item> findAll()
    {
        return em.createQuery("SELECT i FROM Item i").getResultList();
    }
    
    public Collection<Item> findAllInShopWindow()
    {
        return em.createQuery("SELECT i FROM Item i WHERE i.inShopWindow = TRUE").getResultList();
    }

    public Collection<Item> search(String searchString)
    {
        String query = 
                "SELECT i FROM Item i WHERE i.id = :searchString "+
                "OR UPPER(i.name) LIKE :searchString "+
                "OR UPPER(i.desc) LIKE :searchString";
        
        return em.createQuery(query)
                .setParameter("searchString", searchString.toUpperCase())
                .getResultList();
    }
    
    
}
