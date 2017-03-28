/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.ejb;

import edu.iit.sat.itmd4515.mdsouza5.domain.Customer;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author mervin
 */
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
        return getEntityManager().createNamedQuery("Customer.findByUsername", Customer.class)
                .setParameter("username", username)
                .getSingleResult();

    }
}
