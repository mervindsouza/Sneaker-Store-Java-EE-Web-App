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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author Mervin
 */
@Entity
@Table(name = "Product")
//@NamedQueries({
//    @NamedQuery(productName = "Product.findAll", query = "select p from Product p ")
//    ,
//    @NamedQuery(productName = "Product.findByName", query = "select p from Product p where p.productName = :productName")
//})
public class Product {

    public Product() {
    }

//    public Product(Long Id, String productName, Date dateAdded, Integer productCount) {
//        this.Id = Id;
//        this.productName = productName;
//        this.dateAdded = dateAdded;
//        this.productCount = productCount;
//    }

    public Product(String productName, Date dateAdded, Integer productCount) {
        this.productName = productName;
        this.dateAdded = dateAdded;
        this.productCount = productCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Column
    @NotNull(message = "Product Name cannot be null.")
    @Size(min = 5, max = 50, message = "Product Name Must be Greater Than 5 Characters")
    private String productName;
    
    @Past(message = "Date Should be in past.")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    
    @Transient
    private Integer productCount;

    @OneToOne(mappedBy = "product")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private Category category;

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
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * Set the value of price
     *
     * @param productCount
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
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
     * Get the value of productName
     *
     * @return the value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the value of productName
     *
     * @param productName new value of productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * Get the value of category
     *
     * @return the value of category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set the value of category
     *
     * @param category new value of category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "Id=" + Id + ", name=" + productName + ", dateAdded=" + dateAdded + ", count=" + productCount + '}';
    }
}
