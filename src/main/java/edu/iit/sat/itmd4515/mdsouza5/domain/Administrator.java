/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.domain;

import edu.iit.sat.itmd4515.mdsouza5.domain.security.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mervin
 */
@Entity
@Table(name = "administrator")
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll",
            query = "select a from Administrator a")
    ,
    @NamedQuery(name = "Administrator.findAllByName",
            query = "select a from Administrator a where a.adminName = :adminName")
    ,
    @NamedQuery(name = "Administrator.findByUsername",
            query = "select a from Administrator a where a.user.userName = :username")
})
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adminName;
    private String adminEmail;

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    @OneToMany(mappedBy = "administrator")
    private List<Seller> sellers = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<Orders> orders = new ArrayList<>();
    
    @OneToMany(mappedBy = "administrator")
    private List<Product> products = new ArrayList<>();



    /**
     *
     */
    public Administrator() {
    }

    /**
     *
     * @param adminName
     * @param adminEmail
     */
    public Administrator(String adminName, String adminEmail) {
        this.adminName = adminName;
        this.adminEmail = adminEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     *
     * @return
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    /**
     *
     * @param adminEmail
     */
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Administrator{" + "id=" + id + ", adminName=" + adminName + ", email=" + adminEmail + ", user=" + user + '}';
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
