/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.web;

import edu.iit.sat.itmd4515.mdsouza5.domain.Category;
import edu.iit.sat.itmd4515.mdsouza5.domain.Customer;
import edu.iit.sat.itmd4515.mdsouza5.domain.Orders;
import edu.iit.sat.itmd4515.mdsouza5.domain.Product;
import edu.iit.sat.itmd4515.mdsouza5.ejb.CustomerService;
import edu.iit.sat.itmd4515.mdsouza5.ejb.OrdersService;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Dethrone
 */
@Named
@RequestScoped
public class AdministratorPortalController extends BaseController {

    @EJB
    private OrdersService ordersService;

    @EJB
    private CustomerService customerService;

    private static final Logger LOG = Logger.getLogger(AdministratorPortalController.class.getName());

    private Customer customer;
    private Product product;
    private List<Orders> orders;
    private Category category;
    
    
    

    public AdministratorPortalController() {
    }

    /**
     * Get the value of customer
     *
     * @return the value of customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the value of customer
     *
     * @param customer new value of customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
