/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author Mervin FP
 */
@Entity
@Table(name = "Product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "select p from Product p ")
    ,
    @NamedQuery(name = "Product.findByName", query = "select p from Product p where p.name = :name")
})
public class Product {

    public Product() {
    }

//    public Product(Long Id, String name, Date dateAdded, Integer count) {
//        this.Id = Id;
//        this.name = name;
//        this.dateAdded = dateAdded;
//        this.count = count;
//    }
    public Product(String name, Date dateAdded, Integer count) {
        this.dateAdded = dateAdded;
        this.name = name;
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @NotNull(message = "The Name Of Product Cannot be Null.")
    @Column(unique = true)
    private String name;
    
    @Past(message = "Product Date cannot be in the future.")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Transient
    private Integer count;
    
    @OneToOne(mappedBy = "product")
    private Orders orders;

    /**
     * Get the value of orders
     *
     * @return the value of orders
     */
    public Orders getOrders() {
        return orders;
    }

    /**
     * Set the value of orders
     *
     * @param orders new value of orders
     */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }


    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Set the value of price
     *
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Get the value of dateAdded
     *
     * @return the value of dateAdded
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * Set the value of dateAdded
     *
     * @param dateAdded new value of dateAdded
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Product{" + "Id=" + Id + ", name=" + name + ", dateAdded=" + dateAdded + ", count=" + count + '}';
    }
}
