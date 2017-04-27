/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.ejb;

import edu.iit.sat.itmd4515.mdsouza5.domain.Customer;
import edu.iit.sat.itmd4515.mdsouza5.domain.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author mervin
 */
@Named
@Stateless
public class CustomerService extends BaseService<Customer> {

    /**
     *
     */
    public CustomerService() {
        super(Customer.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Customer> findAll() {
        return getEntityManager().createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    /**
     *
     * @param username
     * @return
     */
    public Customer findByUsername(String username) {
        return  getEntityManager().createNamedQuery("Customer.findByUsername", Customer.class)
                .setParameter("username", username)
                .getSingleResult();

    }

    @Override
    public void update(Customer newDataFromJsf) {
        //getting ref to the old data
        Customer oldData = getEntityManager().find(Customer.class, newDataFromJsf.getId());
        
        newDataFromJsf.setOrders(oldData.getOrders());
        newDataFromJsf.setUser(oldData.getUser());
        
        //implement customer and orders as bi-directional relationship
        for(Orders o: oldData.getOrders()){
            o.getCustomers().remove(oldData);
        }
        oldData.setOrders(null);
        //after disassociating data from the database, we merge now
        getEntityManager().merge(oldData);
        //merge the new data
        getEntityManager().merge(newDataFromJsf);
    }
    
    
}
