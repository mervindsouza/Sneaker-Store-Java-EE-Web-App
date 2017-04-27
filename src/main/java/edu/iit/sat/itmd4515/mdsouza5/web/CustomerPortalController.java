/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.web;

import edu.iit.sat.itmd4515.mdsouza5.domain.Administrator;
import edu.iit.sat.itmd4515.mdsouza5.domain.Category;
import edu.iit.sat.itmd4515.mdsouza5.domain.Customer;
import edu.iit.sat.itmd4515.mdsouza5.domain.Orders;
import edu.iit.sat.itmd4515.mdsouza5.domain.Product;
import static edu.iit.sat.itmd4515.mdsouza5.domain.Product_.category;
import edu.iit.sat.itmd4515.mdsouza5.ejb.AdministratorService;
import edu.iit.sat.itmd4515.mdsouza5.ejb.CustomerService;
import edu.iit.sat.itmd4515.mdsouza5.ejb.OrdersService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Dethrone
 */
@Named
@RequestScoped
public class CustomerPortalController extends BaseController {

    private static final Logger LOG = Logger.getLogger(CustomerPortalController.class.getName());

    @EJB
    private AdministratorService administratorService;
    @EJB
    private CustomerService customerService;
    @EJB
    private OrdersService ordersService;

    @Inject
    LoginController loginController;

    private Customer customer;
    private Administrator administrator;
    private Orders orders;
    private Product product;

    public CustomerPortalController() {
    }

    @Override
    @PostConstruct
    public void postConstruct() {
        super.postConstruct();
        customer = customerService.findByUsername(loginController.getRemoteUser());
        LOG.info("LoggedIn User : " + customer.toString());
        orders = (Orders) customer.getOrders();
        product = new Product();
        product.setCategory((Category) category);
        
    }

    //helper or utility methods to access other components
    //write action methods here
    public String getCustomerName() {
        return this.customer.getCustName();
    }

    //do this in administrator
    /*
    public String getOrdersDetails(Product p){
        List<String> names = new ArrayList<>();
        for(Orders o : p.getOrders()){
            
        }
        return String.join(',',names);
    }
     */
    //getters and setters for those components - implement relationship mapping
    //Implement all the doMethods in Administrator.
    public String doViewOrders(Orders o) {
        this.orders = o;
        return "/customer/viewOrders.xhtml";
    }

    public String doEditOrders(Orders o) {
        this.orders = o;
        o.setProduct(product);
        return "/customer/editOrders.xhtml";
    }

    public String doDeleteOrders(Orders o) {
        o.setProduct(product);
        return "/customer/welcome.xhtml";
    }

    public String doApproveOrders(Orders o) {
        o.setProduct(product);
        return "/customer/welcome.xhtml";
    }

    public String doExecute() {
        //productService.update(product); //merge entities through baseservice
//        context.addMessage(null, 
//                new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Updated.", "Updated Values "+orders.getProduct()));
        return "/customer/welcome.xhtml";
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
