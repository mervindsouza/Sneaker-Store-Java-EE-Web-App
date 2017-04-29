/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mervin
 */
@Entity
@Table(name = "Orders")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "select o from Orders o")
    ,
    @NamedQuery(name = "Orders.findByConfirmationNumber", query = "select o from Orders o where o.confirmationNumber = :confirmationNumber")})
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Temporal(TemporalType.DATE)
    private Date dateOrdered;
    private Integer confirmationNumber;
    private Float orderValue;
    private String orderStatus;

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ADMIN_ID")
    private Administrator administrator;

    /**
     *
     */
    public Orders() {
    }

    /**
     *
     * @param dateOrdered
     * @param confirmationNumber
     * @param orderValue
     */
    public Orders(Date dateOrdered, Integer confirmationNumber, Float orderValue) {
        this.dateOrdered = dateOrdered;
        this.confirmationNumber = confirmationNumber;
        this.orderValue = orderValue;
    }

//    public void addProduct(Product p) {
//        this.product = (List<Product>) p;
//        p.setOrders(this);
//    }
    public Integer getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(Integer confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Float getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Float orderValue) {
        this.orderValue = orderValue;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
