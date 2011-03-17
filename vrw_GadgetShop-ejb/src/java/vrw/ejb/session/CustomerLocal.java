/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vrw.ejb.session;

import java.util.Collection;
import vrw.ejb.entity.Customer;

/**
 * Session bean for managing customers
 * 
 * @author 
 */
public interface CustomerLocal {    
    
    /**
     * Finds all customers.
     * 
     * @return all customers 
     */
    public Collection<Customer> findAll();    
    
    /**
     * Finds a customer by nickname
     * 
     * @param nickname nickname to look for
     * @return customer or null if no customer with such a nickname is found
     */
    public Customer find(String nickname);    
    
    /**
     * Registers a new customer
     * 
     * @param c new customer
     */
    public void register(Customer c);
    
    /**
     * Updates existing customer
     * 
     * @param c existing customer
     */
    public void update(Customer c);
    
    /**
     * Sets existing customer to inactive ("soft" remove)
     * 
     * @param c existing customer
     */
    public void remove(Customer c);        
}
